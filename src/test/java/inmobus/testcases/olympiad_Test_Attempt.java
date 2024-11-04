package inmobus.testcases;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.listeners.TestAllureListeners;
import com.qa.hubspot.listeners.TestListeners;

import inmobius.POM.student_registerPOM;
@Listeners({ TestAllureListeners.class, TestListeners.class })
public class olympiad_Test_Attempt extends base_class {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	@Test
	public void olympiad_TestAttempt() throws InterruptedException, AWTException {
		student_registerPOM stdregister= new student_registerPOM(driver);
		stdregister.student_button_click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
      WebElement mouseovericoe=driver.findElement(By.xpath("//div[@class=\"iticks-last-msg\"]"));
				action.moveToElement(mouseovericoe).perform();
				Thread.sleep(2000);
		stdregister.closebutton();
        Thread.sleep(1000);
        System.out.println(student_register.admissionID);
		stdregister.enter_LoginID(student_register.admissionID);
		stdregister.enter_password(password);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		stdregister.click_on_Login();
		WebElement validationmessage=stdregister.validationmessage();
		if(validationmessage.isDisplayed()) 
			Thread.sleep(2000);
			stdregister.enter_password(resetpassword);
			stdregister.click_on_Login();
			Thread.sleep(2000);
			driver.navigate().refresh();
//		WebElement element = driver.findElement(By.xpath("//h5[text()=\"Math Olympiad\"]/following::a[1]"));
		WebElement element = driver.findElement(By.xpath("//h5[text()=\"HOTS Olympiad\"]//following::a[@class=\"view__detailbar-btn\"][1]"));
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
      actions.doubleClick(element).perform();
		Thread.sleep(2000);
		

	}
}
