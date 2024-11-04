package inmobus.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.Status;
import com.qa.hubspot.listeners.TestAllureListeners;
import com.qa.hubspot.listeners.TestListeners;

import inmobius.POM.adminLogin_checkEventPOM;
import inmobius.POM.superAdmin_POMPage;
//import inmobius.utilities.ExtentReports1;
import inmobius.utilities.readConfig;
import inmobius.utilities.xutils;

@Listeners({ TestAllureListeners.class, TestListeners.class })


public class adminlogin_eventcreate extends base_class{
		readConfig rcfg=new readConfig();
		public String AdminUSN = rcfg.getAdminUsername();
		public String AdminPWD = rcfg.getAdminPassword();
		public String schAdminUser= rcfg.schoolAdminUsername();
		public String schAdminPassword=rcfg.schoolAdminUserpwd();
		public String SchoolName=rcfg.getSchoolName();
	    public String result;
	    public String results;
	     
//	      @BeforeSuite
//	  	public void beforeSuite() {
//	  		ExtentReports1.initReports();
//	  		}
//	      @BeforeMethod
//	  	public void setup(Method method) throws IOException {
//
//	  		ExtentReports1.createTest(method.getName());
//	  	}
	@Test(priority = 2, description="New Organic student registration is successful")
		 public void event_create() throws InterruptedException, IOException {
			 superAdmin_POMPage al = new superAdmin_POMPage(driver);
			 adminLogin_checkEventPOM sace = new adminLogin_checkEventPOM(driver);
		       	  al.clickon_school();
		       	JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(2000);
			      al.clickon_schoolLogin();
					Select objSelect = new Select(al.selectAccountType());
			        objSelect.selectByIndex(2);
					al.enterUserName(AdminUSN);
					al.enterPassword(AdminPWD);
					al.clickOnLogin();
					Thread.sleep(10000);
					al.clickAddEvent();
					al.clickCreateEvent();
					Thread.sleep(3000);
					String Freshschool = New_School_Register.copiedText1;
					al.SelectSchoolinFilter(Freshschool);
					Select objSelect1 = new Select(al.selectEventType());
					objSelect1.selectByValue("SCORE");
					Thread.sleep(2000);
					Select objSelect2 = new Select(al.SelectEventLeavel());
					objSelect2.selectByValue("Prelims");
					Select objSelect3 = new Select(al.SelectEventRounds());
					objSelect3.selectByValue("Round 3");
					WebElement TimeElement = driver.findElement(By.xpath("//input[@id='start_date']"));
				   js.executeScript("arguments[0].scrollIntoView();", TimeElement);
					al.eventStart_Date();
					Thread.sleep(2000);
					al.eventend_Date();
					Thread.sleep(2000);
					WebElement clear = driver.findElement(By.xpath("//input[@id='start_time']"));
					String s = Keys.chord(Keys.CONTROL, "a");
					clear.sendKeys(s);
					clear.sendKeys(Keys.DELETE);
					String starttime=xutils.event_start_time();
					clear.sendKeys(starttime);
					WebElement clearendtime = driver.findElement(By.xpath("//*[@id='end_time']"));
					String s1 = Keys.chord(Keys.CONTROL, "a");
					clearendtime.sendKeys(s1);
					clearendtime.sendKeys(Keys.DELETE);
					 clearendtime.sendKeys(xutils.event_end_time());
					 js.executeScript("window.scrollBy(0,500)", "");
					al.eventSave_Publish();
					Thread.sleep(2000);
					System.out.println(Freshschool);
					al.SelectSchoolinplannerpage(Freshschool);
//					al.SelectSchoolinFilter(SchoolName);
					Thread.sleep(2000);
					Select objSelect6 = new Select(al.SelectgradeinFilter());
					objSelect6.selectByValue(grade);
					Thread.sleep(8000);
				 result = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("h:mm"));
				 driver.navigate().refresh();
//				 results = LocalTime.parse(xutils.event_end_time(), DateTimeFormatter.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("h:mm"));
				 WebElement eventfinder = driver.findElement(By.xpath("//*[contains(text(),'" + result + "')]"));
					     if (eventfinder.isDisplayed()) {
						System.out.println("Events are visible in super admin Dashboard with  creation time "+ result );
					} else {
						System.out.println("Events not visible in super admin dashbaord ");
					}
				driver.navigate().refresh();
				WebDriverWait wait=new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(al.logouttoggle()));
			    al.logoutbutton();
			    Thread.sleep(3000);
		       Select objSelect8 = new Select(sace.selectAccountType());
		        objSelect8.selectByIndex(1);
		        sace.enterUserName(schAdminUser);
		        sace.enterPassword(schAdminPassword);
		        sace.clickOnLogin();
				Select objSelect10 = new Select(sace.SelectgradeinFilter());
				objSelect10.selectByValue(grade);
				Thread.sleep(5000);
				WebElement eventfinders = driver.findElement(By.xpath("//*[contains(text(),'" +result+ "')]"));
				System.out.println(eventfinders);
				if (eventfinders.isDisplayed()) {
					System.out.println("Events are visible in School Admin Dashboard");
//					ExtentReports1.test.log(Status.PASS, "Finally");
				} else {
					System.out.println("Events not visible in School Admin Dashbaord");
//					ExtentReports1.test.log(Status.FAIL, "Finally");
				}
		 
		}
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//		try {
//			ExtentReports1.flushReports();
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		 }
		 

