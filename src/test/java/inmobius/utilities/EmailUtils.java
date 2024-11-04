package inmobius.utilities;



import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.testng.annotations.Listeners;

import com.qa.hubspot.listeners.TestListeners;


//@Listeners(TestListeners.class)
	public class EmailUtils  {

		public void sendEmail() {
		    final String username = "venkatesh.v@infinitylearn.com";
		    final String password = "Keshav@123";
		    readConfig rcfg=new readConfig();
		    Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", "outlook.office365.com");
		    props.put("mail.smtp.port", "465");
		    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		        }
		    });
		    try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("venkatesh@infinitylearn.com"));
		       	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
					"venkatesh.v@infinitylearn.com," +
					"arun.rout@infinitylearn.com"
				));
	 
				message.setSubject("Daily Sanity Check-In: Inmobius");
		        // Set email body
				String emailBody = "Hi Team,\n\n";
				emailBody += "Please find inmobius daily sanity report attached.\n\n";
	 
				String latestReportURL = rcfg.getreportpath();
				if (latestReportURL != null) {
					emailBody += "Download the latest report: " + latestReportURL + "\n\n";
				}
	 
				emailBody += "Test Execution Statistics:\n";
				emailBody += "\t Total Tests: " + TestListeners.getTotalTests() + "\n";
				emailBody += "\t Passed Tests: " + TestListeners.getPassedTests() + "\n";
				emailBody += "\t Failed Tests: " + TestListeners.getFailedTests() + "\n";
				emailBody += "\t Skipped Tests: " + TestListeners.getSkippedTests() + "\n\n";
	 
				List<String> failedTestNames = TestListeners.getFailedTestNames();
				if (!failedTestNames.isEmpty()) {
					// emailBody += "⚠️⚠️⚠️ Failed Test Cases  ⚠️⚠️⚠️:\n ";
					emailBody += "\u26A0\uFE0F\u26A0\uFE0F\u26A0\uFE0F Failed Test Cases \u26A0\uFE0F\u26A0\uFE0F\u26A0\uFE0F:\n";
	 
	 
					for (String testName : failedTestNames) {
						emailBody += "\t - " + testName + "\n";
					}
					emailBody += "\n";
					emailBody += "We are currently investigating the test failures to determine if they are consistent or intermittent. Failures due to flakiness or network component loading times will be ignored, while those related to bugs will be communicated separately once investigated thoroughly. \n";
					emailBody += "\n\n";
				}
	 
				emailBody += "Kind Regards,\nTeam Automation";
		        Multipart multipart = new MimeMultipart();
		        BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setContent(emailBody, "text/plain; charset=UTF-8");
		        multipart.addBodyPart(messageBodyPart);
	 
				System.out.println("Email body to be sent:");
				System.out.println(emailBody);
		        // // Attach latest report file as attachment
		        // File latestReportFile = getLatestReportFile();
		        // if (latestReportFile != null) {
		        //     DataSource source = new FileDataSource(latestReportFile);
		        //     messageBodyPart = new MimeBodyPart();
		        //     messageBodyPart.setDataHandler(new DataHandler(source));
		        //     messageBodyPart.setFileName(latestReportFile.getName());
		        //     multipart.addBodyPart(messageBodyPart);
		        // } else {
		        //     System.out.println("No report file found to attach to the email.");
		        // }
				message.setContent(multipart);
	            // Check if the environment variable indicating Jenkins is set
//	            String jenkinsEnv = System.getenv("JENKINS_ENV");
//	            boolean isRunningOnJenkins = (jenkinsEnv != null && jenkinsEnv.equals("true"));
//	            System.out.println("jenkinsEnv,isRunningOnJenkins values :"+ jenkinsEnv + isRunningOnJenkins);
//	            if (isRunningOnJenkins) {
//	                // Code is running on Jenkins, send the email
//	                Transport.send(message);
//	                System.out.println("Email sent successfully.");
//	            } else {
//	                // Code is running locally, do not send the email
//	                System.out.println("Skipping email sending as running locally.");
//	            }
		    } catch (MessagingException e) {
		        e.printStackTrace();
		        throw new RuntimeException("Error occurred while sending email: " + e.getMessage());
		    }
		}
	}