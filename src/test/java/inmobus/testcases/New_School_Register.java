package inmobus.testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.groovy.json.internal.Exceptions;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.listeners.TestAllureListeners;

import inmobius.POM.school_RegisterPOM;
import inmobius.POM.student_registerPOM;
import inmobius.POM.superAdmin_POMPage;
import inmobius.utilities.readConfig;
import inmobius.utilities.xutils;

@Listeners({ TestAllureListeners.class })
public class New_School_Register extends base_class {
	readConfig rcfg = new readConfig();
	public String AdminUSN = rcfg.getAdminUsername();
	public String AdminPWD = rcfg.getAdminPassword();
	public String schAdminUser = rcfg.schoolAdminUsername();
	public String schAdminPassword = rcfg.schoolAdminUserpwd();
	public String SchoolName = rcfg.getSchoolName();
	xutils xt = new xutils();
	String result;
	String invitecode;
	String finalcode;
	WebElement NextPageLink;
	String TenantName;
	public static String schoolID;
	public static String copiedText;
	public static String copiedText1;
	@Test(priority = 1, description="New School Registration and Login is successful")
	public void New_School_Registration() throws Exception {
		student_registerPOM stdregister = new student_registerPOM(driver);
		superAdmin_POMPage al = new superAdmin_POMPage(driver);
//  insights itd = new insights();  // Create an object of insights class
		school_RegisterPOM srp = new school_RegisterPOM(driver);

		al.clickon_school();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		al.clickon_schoolLogin();
		Select objSelect = new Select(al.selectAccountType());
//		objSelect.selectByIndex(2);
//		al.enterUserName(AdminUSN);
//		al.enterPassword(AdminPWD);
//		al.clickOnLogin();
//		Thread.sleep(5000);
//		srp.invitation_codebutton();
//		Thread.sleep(5000);
//		srp.mapnew_code_button_click();
//		Thread.sleep(3000);
//
//		// Accessing formattedTenantInfo from insights class
//		String Tenantname1 = insights.formattedTenantInfo; // Access the static variable
////    String Tenantname1 = insights.NewTenantName;
//		System.out.println(Tenantname1);
//		srp.enter_TenantID(Tenantname1);
		xt.login();
		xt.generateInvitationCode();
		Thread.sleep(1000);
		String invitecode = xt.invitationCode;
		String finalinvitecode = invitecode.replace("\"", "");
		System.out.println(finalinvitecode);
		driver.navigate().refresh();
//		srp.LogoutDropdown();
//		srp.SALogout();
		driver.get(baseUrl);
		srp.schoolbuttononhomepage();
		srp.school_firstName("Automation School");
////				Thread.sleep(4000);
////				srp.click_chatbot();
////				srp.close_chatbot();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		srp.email_ID("username" + randomInt + "@gmail.com");
		srp.school_name("Automation school");
		Thread.sleep(1000);
//				finalcode=xutils.cleanString(invitecode);
		srp.enter_invitationcode(finalinvitecode);
		long randomNumber = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println(randomNumber);
		String str = Long.toString(randomNumber);
		srp.enter_number(str);
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		srp.click_continuebutton();
		xutils xl = new xutils();
		String isd_code = "+91";
		String phone = str;
		String tenant_id = "99999";
		String product_id = "100";
		Thread.sleep(2000);
		srp.enter_Opt(xl.generateOTP(isd_code, phone, tenant_id, product_id));
////				srp.enter_Opt("1111");
		Thread.sleep(2000);
		srp.click_continuebutton();
		Thread.sleep(3000);
//		  WebElement mouseovericoe=driver.findElement(By.xpath("//div[@class=\"iticks-last-msg\"]"));
//		  Actions action=new Actions(driver);
//			action.moveToElement(mouseovericoe).perform();
//			Thread.sleep(2000);
//	         stdregister.closebutton();
		Thread.sleep(2000);
//          js.executeScript("window.scrollBy(0,450)", "");
		while (true) {
			try {

				WebElement startbutton = driver.findElement(By.xpath("//a[text()=\"Start Now\"]"));

				if (startbutton.isDisplayed()) {
					startbutton.click();
					break; // Exit loop if the element is visible
				}
			} catch (Exception e) {
				// If the element is not found, continue scrolling
			}
		}
		srp.schooltype_dropdown();
		srp.select_schooltype();
		srp.schoolBoard("CBSE");
		srp.Enter_BranchName("Main");
		srp.enter_schoolAddress("School Address");
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(2000);
		srp.click_country_dropdown();
		srp.select_india();
		srp.click_statedropdown();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		srp.selectstate();
		WebElement city = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[10]/div/div/div[1]"));
		city.click();
		WebElement selectcity = driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[10]/div/div/div[3]/div/div[5]"));
		selectcity.click();
		WebElement pncfield = driver.findElement(By.xpath("//input[@name=\"pincode\"]"));
		pncfield.sendKeys("560068");
		WebElement fees = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[12]/div/div/div[1]"));
		fees.click();
		WebElement feesselect = driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[12]/div/div/div[3]/div/div[1]"));
		feesselect.click();
		WebElement tierclick = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[13]/div/div/div[1]"));
		tierclick.click();
		WebElement tierselect = driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[13]/div/div/div[3]/div/div[1]"));
		tierselect.click();
		Thread.sleep(4000);
		WebElement mouseovericoe = driver.findElement(By.xpath("//div[@class=\"iticks-last-msg\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseovericoe).perform();
		Thread.sleep(2000);
		stdregister.closebutton();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,450)", "");
		WebElement DesignationClick = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[19]/div/div"));
		DesignationClick.click();
		Thread.sleep(1000);
		WebElement desigselect = driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[19]/div/div/div[3]/div/div[1]"));
		desigselect.click();

		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(1000);

		WebElement continuebt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/form/section/div/button"));
		continuebt.click();
		Thread.sleep(2000);
//		action.moveToElement(mouseovericoe).perform();
//		Thread.sleep(2000);
//		stdregister.closebutton();

//		WebElement element_toggle = driver.findElement(
//				By.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[3]/div/div/div[2]/input"));
//		element_toggle.click();
//		Thread.sleep(1000);

		WebElement stdcount = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[3]/div/div/div[2]/input"));
		stdcount.clear();
		stdcount.sendKeys("500");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement finishbtn = driver.findElement(By.xpath("//*[text()=\"Finish\"]"));
		finishbtn.click();
		Thread.sleep(1000);
	 
		
		WebElement clickcontinue = driver.findElement(By.xpath("//*[text()=\"Click here to login\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", clickcontinue);
		Thread.sleep(1000);
		clickcontinue.click();
		objSelect.selectByIndex(1);
		al.enterUserName(str);

		String lastThreeDigits = str.substring(str.length() - 3);
		String schoolpwd = "school" + lastThreeDigits;
		al.enterPassword(schoolpwd);
		al.clickOnLogin();
		Thread.sleep(2000);
		WebElement schoolIDSearch=driver.findElement(By.xpath("//*[@id=\"schoolName\"]"));
		schoolIDSearch.click();
		  action.doubleClick(schoolIDSearch).perform();

		  action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	        // Simulate Ctrl + C to copy the text
	        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

	        // Retrieve the copied text from the system clipboard
	       copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
	       // Print the copied text
	        System.out.println("Copied Text: " + copiedText);
	       
	       if (!copiedText.endsWith(")")) {
	            // Add closing parenthesis if missing
	            copiedText1 = copiedText + ")";
	        }

	        // Print the modified text
	        System.out.println(copiedText);
	    
         schoolID = copiedText.replaceAll("[^SCH\\d]", "").trim();
        
         System.out.println("School Registration is successful and The School ID is:"+ schoolID);
	}
}
