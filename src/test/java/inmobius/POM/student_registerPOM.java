package inmobius.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class student_registerPOM  {
	public static WebDriver driver;
	public WebDriverWait wait;


	public student_registerPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);;
	}
//Locators
	@FindBy(xpath="//img[@alt='Student']")
	WebElement student_button;
	
	@FindBy(xpath="//*[@id=\"signup\"]/div/div/form/div/div[6]/p/span")
	WebElement create_Student_Account;
	
	@FindBy(xpath="//input[@name=\"firstName\"]")
	WebElement first_name;
	
	@FindBy(xpath="//button[@type=\"button\"]")
	WebElement select_grade;
	
	@FindBy(xpath="/html/body/div[1]/div/header/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/button/ul/li[5]")
	WebElement choose_grade;
	
	@FindBy(xpath="//*[@name=\"invitationCode\"]")
	WebElement school_code;
	
	@FindBy(xpath="//*[@placeholder=\"Enter your login ID\"]")
	WebElement enterLoginID;
	
	@FindBy(xpath="//*[@placeholder=\"Enter your Password\"]")
	WebElement enterPassword;
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@alt=\"Profile\"]")
	WebElement profilebutton;
	
	@FindBy(xpath="//*[text()=\"Change password\"]")
	WebElement changepassword;
	
	@FindBy(xpath="//*[@placeholder=\"New Password\"]")
	WebElement newpassword;
	
	@FindBy(xpath="//*[@class=\"close-icon\"]")
	WebElement closeicon;
	public void closebutton() {
		closeicon.click();
	}
	public void new_Password(String newPassword) { newpassword.sendKeys(newPassword);}
	
	@FindBy(xpath="//*[@placeholder=\"Confirm Password\"]")
	WebElement confirm_passsword;
	
	public void confirm_password(String confirm_Passsword) {confirm_passsword.sendKeys(confirm_Passsword);}
	
	
	@FindBy(xpath="//*[text()=\"Reset password\"]")WebElement resetpassword_button;
	public void reset_passwordbutton_click() {resetpassword_button.click();}
	
	@FindBy(xpath="//*[@name=\"phoneNumber\"]")
	WebElement phonenumber;
	
	
	@FindBy(xpath="//*[text()=\"Continue\"]") WebElement continue_butto;
	public void continue_button() {continue_butto.click();}
	
	@FindBy(xpath="//*[@aria-label=\"Please enter OTP character 1\"]") WebElement enter_Otp;
	public void enter_Opt(String OTP) {
		enter_Otp.sendKeys(OTP);
	}
	
	@FindBy(xpath="//*[text()=\"Create Account\"]") WebElement continue_button;
	public void click_Continue_button() {continue_button.click();}
	
   @FindBy(xpath="//*[text()=\"Log Out\"]") WebElement logout;
	public void logout_button() {logout.click();}
     
	
	@FindBy(xpath="//p[text()=\"Copy\"]")WebElement copy_ID;
	public void copy_ID() { copy_ID.click();}
   
	@FindBy(xpath="//h4[text()=\"Scheduled\"]")
	WebElement profile;
	
	public WebElement schedule_textdisplayed() {
		profile.isDisplayed();
		return profile;
	}
	
	@FindBy(xpath="//span[text()=\"Login ID & password don’t match\"]") WebElement worningText;
	public WebElement validationmessage() {
		worningText.isDisplayed();
		return worningText;
	}
	
	@FindBy(xpath="//img[@class=\"logo-img\"]")WebElement infinitylearn_Logo;
	public WebElement infinitylearn_Logo() {
		infinitylearn_Logo.isDisplayed();
		return infinitylearn_Logo;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/nav/div/div/div[2]/div[1]/div/img") 
	WebElement profilebutton_aftrepasswordchange;
	
	public void profilebutton_afterresetpassword() {
		profilebutton_aftrepasswordchange.click();
	}
	
	
   
	public void student_button_click() {
		student_button.click();
	} 
	
	public void create_account_in_loginpage() {
		create_Student_Account.click();
	}
	
	public void enter_firstname(String firstname) {
		first_name.sendKeys(firstname);
	}
	public void click_on_grade() {
		select_grade.click();
	}
	public void choose_grade() {
		choose_grade.click();
	}
	public void school_code(String school_Code) {
		school_code.sendKeys(school_Code);
	}
	public void enter_LoginID(String LoginID) {
		enterLoginID.sendKeys(LoginID);
	}
	public void enter_password(String password){
		enterPassword.clear();
	enterPassword.sendKeys(password);
}
	public void click_on_Login() {
		loginButton.click();
	}
	public void user_profil_click() {
		profilebutton.click();
	
	}
	
//	public void click_profile() {
//		profilebutton.click();
//	}
	public void change_Password() {
		changepassword.click();
	}

	public void phone_Number(String randomNumber) {
		phonenumber.sendKeys(randomNumber);
		
	}

	
}
