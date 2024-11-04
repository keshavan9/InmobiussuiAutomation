package inmobus.testcases;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.hubspot.listeners.TestAllureListeners;
import com.qa.hubspot.listeners.TestListeners;

import inmobius.POM.student_registerPOM;
@Listeners({ TestAllureListeners.class, TestListeners.class })
public class reset_password extends base_class  {

	
	@Test(description="Change password")
	public void student_Change_Password() throws InterruptedException {
		student_registerPOM stdregister= new student_registerPOM(driver);
		student_register register=new student_register();
		stdregister.student_button_click();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement mouseovericoe=driver.findElement(By.xpath("//div[@class=\"iticks-last-msg\"]"));
		action.moveToElement(mouseovericoe).perform();
		Thread.sleep(3000);
       stdregister.closebutton();
		stdregister.enter_LoginID(LoginID);
		stdregister.enter_password(resetpassword);
		stdregister.click_on_Login();
		Thread.sleep(5000);
//	    stdregister.profiledisplayed();
//	    WebElement  profile= stdregister.profiledisplayed();
//	    profile.click();
		stdregister.user_profil_click();
	    stdregister.change_Password();
	    stdregister.new_Password(resetpassword);
	    stdregister.confirm_password(resetpassword);
	    stdregister.reset_passwordbutton_click();
	    System.out.println("Password updated");
	    driver.navigate().refresh();
	    Thread.sleep(3000);
	    stdregister.profilebutton_afterresetpassword();
	    Thread.sleep(2000);
	   stdregister.logout_button();
	    Thread.sleep(1000);
	    stdregister.enter_LoginID(LoginID);
	    stdregister.enter_password(resetpassword);
	    stdregister.click_on_Login();
	    Thread.sleep(5000);
	    WebElement  Text= stdregister.schedule_textdisplayed();
		 if(Text.isDisplayed()) {
			 System.out.println("Password reset is done and able to login with new password");
		 }else {
			 System.out.println("Unable to updated password because of login failed");
		 }
		 
}
}
