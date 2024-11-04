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

public class student_login_withOTP extends base_class{

	@Test
	public void login_With_Otp() throws InterruptedException{
		student_registerPOM stdregister= new student_registerPOM(driver);
		stdregister.student_button_click();
		student_register stdreg=new student_register();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement mouseovericoe=driver.findElement(By.xpath("//div[@class=\"iticks-last-msg\"]"));
		action.moveToElement(mouseovericoe).perform();
		Thread.sleep(2000);
       stdregister.closebutton();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(2000);
		WebElement otpclick=driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div/div[5]/a"));
		otpclick.click();
		WebElement enternumber=driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div[1]/div/div/input"));
		enternumber.sendKeys("1211249333");
		WebElement sentotpclick=driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/button"));
		sentotpclick.click();
		xutils xl=new xutils();
		String isd_code="+91";
		String phone="1211249333";
	    String tenant_id="99999";
	    String product_id="100";
		Thread.sleep(5000);
		stdregister.enter_Opt(xl.generateOTP(isd_code, phone, tenant_id, product_id));
		Thread.sleep(10000);
		WebElement clickoncontinue=driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/button"));
		clickoncontinue.click();
		System.out.println("Student login with OTP is successful");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div/div/div/div[1]/div/div/a"));
		act.doubleClick(ele).perform();
		Thread.sleep(2000);
		System.out.println("Take test clicked");
	}
}
