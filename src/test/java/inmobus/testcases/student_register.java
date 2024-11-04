package inmobus.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.listeners.TestAllureListeners;
import com.qa.hubspot.listeners.TestListeners;

import inmobius.POM.student_registerPOM;
import inmobius.utilities.xutils;
@Listeners({ TestAllureListeners.class, TestListeners.class })
public class student_register extends base_class {
  public String str;
  public  String text;
  public static String admissionID;
	
  @Test(priority = 3, description="New Organic student registration is successful")
	public void student_registration() throws InterruptedException {
		student_registerPOM stdregister= new student_registerPOM(driver);
//		New_School_Register ncr=new New_School_Register();
		stdregister.student_button_click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(2000);
		stdregister.create_account_in_loginpage();
		stdregister.enter_firstname(username);
		stdregister.click_on_grade();
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(3000);
		stdregister.choose_grade();
//		stdregister.school_code(school_Code);  
	        // Accessing schoolID from New_School_Register class
	        String schoolCode = New_School_Register.schoolID;
	        
	        // Use the schoolCode
	        stdregister.school_code(schoolCode);
		long randomNumber = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println(randomNumber);
		String str = Long.toString(randomNumber);
		stdregister.phone_Number(str);
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(5000);
		stdregister.continue_button();
		xutils xl=new xutils();
		String isd_code="+91";
		String phone=str;
	    String tenant_id="99999";
	    String product_id="100";
		Thread.sleep(5000);
		stdregister.enter_Opt(xl.generateOTP(isd_code, phone, tenant_id, product_id));
		Thread.sleep(10000);
		stdregister.click_Continue_button();
//		 WebElement  profile= stdregister.schedule_textdisplayed();
//		 if(profile.isDisplayed()) {
//		    	System.out.println("Student Register successful");
//		    	profile.click();
//		    }else {
//		    	stdregister.phone_Number(" ");
//		    	stdregister.phone_Number(str);
////		    	System.out.println("Student Registration fail");
//		    	stdregister.click_Continue_button();
//		      }
		   admissionID=driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div/div/div[2]/div[1]/p[2]")).getText();
		stdregister.user_profil_click();
		   stdregister.logout_button();
		 stdregister.enter_LoginID(admissionID);
	    stdregister.enter_password(password);
	    stdregister.click_on_Login();
	    
	 WebElement  profile1= stdregister.schedule_textdisplayed();
	    if(profile1.isDisplayed()) {
	    	System.out.println("Student login successful");
	    }else {
	    	System.out.println("Student Login fail");
	    }
		Actions act = new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div[2]/div/div/div/div/button"));
		ele.click();
		Thread.sleep(2000);
		 WebElement logo=stdregister.infinitylearn_Logo();
		 if(logo.isDisplayed()) {
			 Thread.sleep(2000);
			 System.out.println("Able to Click on take test User redirecting to Test Attempt page");
		 }else {
			 System.out.println("Take test is not working");
		 }
	    
}

	}

	
