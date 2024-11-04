package inmobus.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.listeners.TestAllureListeners;
import com.qa.hubspot.listeners.TestListeners;

import inmobius.POM.student_registerPOM;
import inmobius.utilities.xutils;

@Listeners({ TestAllureListeners.class, TestListeners.class })
public class student_forgotpassword extends base_class {

	
	@Test
	public void forgotpassword() throws InterruptedException {
	
			student_registerPOM stdregister= new student_registerPOM(driver);
			stdregister.student_button_click();
			student_register stdreg=new student_register();
			Thread.sleep(2000);
			Actions action = new Actions(driver);
          WebElement mouseovericoe=driver.findElement(By.xpath("//div[@class=\"iticks-last-msg\"]"));
					action.moveToElement(mouseovericoe).perform();
					Thread.sleep(2000);
			stdregister.closebutton();
			WebElement forgotpassword=driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div/div[2]/div[2]/span"));
			forgotpassword.click();
			WebElement enternumber=driver.findElement(By.xpath("//input[@name=\"phoneNumber\"]"));
			enternumber.sendKeys("1211249333");
			WebElement sentotpclick=driver.findElement(By.xpath("//button[text()=\"Send OTP\"]"));
			sentotpclick.click();
			xutils xl=new xutils();
			String isd_code="+91";
			String phone="1211249333";
		    String tenant_id="99999";
		    String product_id="100";
			Thread.sleep(5000);
			stdregister.enter_Opt(xl.generateOTP(isd_code, phone, tenant_id, product_id));
			Thread.sleep(10000);
			 WebElement continuebutton=  driver.findElement(By.xpath("//button[text()=\"Continue\"]"));
			 continuebutton.click();
			 Thread.sleep(1000);
			WebElement newpassword=driver.findElement(By.xpath("//*[@id=\"signup\"]/form/div/div[2]/div[1]/div/input"));
			newpassword.sendKeys("Test@123");
			WebElement confirmpassword=driver.findElement(By.xpath("//*[@id=\"signup\"]/form/div/div[2]/div[2]/div/input"));
			confirmpassword.sendKeys("Test@123");
			WebElement resetpassword=driver.findElement(By.xpath("//*[@id=\"signup\"]/form/div/div[2]/div[3]/button"));
			resetpassword.click();
			Thread.sleep(1000);
			WebElement backtologin=driver.findElement(By.xpath("//a[@class=\"back_login\"]"));
			backtologin.click();
			stdregister.enter_LoginID("10068058VSAP");
			stdregister.enter_password("Test@123");
			stdregister.click_on_Login();
			WebElement  profile= stdregister.schedule_textdisplayed();
			if(profile.isDisplayed()) {
				System.out.println("Forgot password functionality is working fine and able to login with new password ");
			}else {
			System.out.println("Forgot password functionality is not working working as expected");
			
			}
			
	}

}
