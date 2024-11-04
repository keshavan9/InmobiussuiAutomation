package inmobius.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adminLogin_checkEventPOM {
	public static WebDriver driver;
	public WebDriverWait wait;


	public adminLogin_checkEventPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);;
	}
//Locators
	@FindBy(xpath="//span[contains(text(),'Login here')] ")
	WebElement loginElement;
	@FindBy(xpath = "//select[@id=\"role_filter\"]")
	WebElement clickschoolAdmin;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement Submitbutton;
	
	@FindBy(xpath="//input[@id=\"school_id\"]")
	WebElement SelectSchoolinFilter;
	
	@FindBy(xpath="//div[@id='grade_filter']//select[@class=\"nice-select--grade custom--select\"]")
	WebElement selectGradeinFilter;
	
	public void clickHereToLogin() {
		loginElement.click();
	}

     public WebElement selectAccountType() {
	clickschoolAdmin.click();
	return clickschoolAdmin;
}
     public void enterUserName(String Username) {
 		userName.sendKeys(Username);
 	}

 	public void enterPassword(String Password) {
 		password.sendKeys(Password);
 	}

 	public void clickOnLogin() {
 		Submitbutton.click();
 	}
	public WebElement SelectSchoolinFilter(String schoolName)
	{
		SelectSchoolinFilter.click();
		SelectSchoolinFilter.sendKeys(schoolName);
		return SelectSchoolinFilter;
	}
	public WebElement SelectgradeinFilter() {
		selectGradeinFilter.click();
		return selectGradeinFilter;
	}
}
