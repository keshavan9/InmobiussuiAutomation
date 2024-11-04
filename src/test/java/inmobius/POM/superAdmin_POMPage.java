package inmobius.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class superAdmin_POMPage {
	public static WebDriver driver;
	public WebDriverWait wait;


	public superAdmin_POMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);;
	}


//Locators
	
	@FindBy(xpath="//span[contains(text(),'Login here')] ")
	WebElement loginElement;
	
	@FindBy(xpath = "//select[@id=\"role_filter\"]")
	WebElement clickSuperAdmin;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement Submitbutton;

	@FindBy(xpath = "//button[normalize-space()='Add Event']")
	WebElement addEvent;

	@FindBy(xpath = "//a[@id='create_event_btn']")
	WebElement createEvent;

//	@FindBy(xpath ="//select[@id='name']")
	
	@FindBy(xpath = "//input[@id='start_date']")
	WebElement startDate;

	@FindBy(xpath = "//*[@id=\"event_form\"]/div[2]/div/div[3]/div/div/div[4]/button[2]")
	WebElement startDate_ApplyDate;

	@FindBy(xpath = "//input[@id='end_date']")
	WebElement endDate;

	@FindBy(xpath = "//*[@id=\"event_form\"]/div[2]/div/div[4]/div/div/div[4]/button[2]")
	WebElement endDate_ApplyDate;

	@FindBy(xpath = "//input[@id='start_time']")
	WebElement start_time;

	@FindBy(xpath = "//*[@id='end_time']")
	WebElement end_Time;

	@FindBy(xpath = "//input[contains(@id,\"school_id\")]")
	WebElement enterschoolName;

	@FindBy(xpath = "//select[@id='grade']")
	WebElement selectGrade;
	@FindBy(xpath = "//select[@id='consumption_type']")
	WebElement selectConsumption_Type;

	@FindBy(xpath = "//button[@id='event_form_submit']")
	WebElement eventSave_Publish;
	
	@FindBy(xpath="//input[@id=\"school_id\"]")
	WebElement SelectSchoolinFilter;
	
	@FindBy(xpath="//*[@id=\"school_select\"]")
	WebElement SelectSchoolinplannerpage;
	
	@FindBy(xpath="//div[@id='grade_filter']//select[@class=\"nice-select--grade custom--select\"]")
	WebElement selectGradeinFilter;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/section[1]/nav[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]/*[name()='svg'][1]")
	WebElement logout_toggle;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']//a[@id='logout']")
	WebElement Logout_button;
	
	@FindBy(xpath="//*[@id=\"signup\"]/div/div[2]")WebElement school_icon;
	public void clickon_school() {school_icon.click();}
	
	@FindBy(xpath="//*[@id=\"signup\"]/form/div/div/div[3]/p/span")WebElement school_login;
	public void clickon_schoolLogin() {school_login.click();}
	
	@FindBy(xpath = "//select[@name='name']")
	WebElement selectEventType;

	
	@FindBy(xpath="//*[@id=\"level\"]") WebElement SelectEventLeavel;
	public WebElement SelectEventLeavel() {
		SelectEventLeavel.click();
		return SelectEventLeavel;
	}
		@FindBy(xpath="//*[@id=\"rounds\"]") 
		WebElement SelectEventRounds;
		
		public WebElement SelectEventRounds() {
			SelectEventRounds.click();
			return SelectEventRounds;
		
	}
	
	// Method of locators//
	
	public WebElement selectEventType() {
		selectEventType.click();
		return selectEventType;
	}
	
	public void clickHereToLogin() {
		loginElement.click();
	}

	public WebElement selectAccountType() {
		clickSuperAdmin.click();
		return clickSuperAdmin;
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

	public void clickAddEvent() {
		addEvent.click();
	}

	public void clickCreateEvent() {
		createEvent.click();
	}


	public void eventStart_Date() {
		startDate.click();
	}

	public void startdate_ApplyDate() {
		startDate_ApplyDate.click();
	}

	public void eventend_Date() {
		endDate.click();
	}

	public void endDate_ApplyDate() {
		endDate_ApplyDate.click();
	}

	public void enterStart_time() {
		start_time.click();
	}

	public void enterend_time() {
		end_Time.click();
	}

	public WebElement enterschoolName(String schoolName) {
		enterschoolName.click();
		enterschoolName.sendKeys(schoolName);
		return enterschoolName;
	}

	public WebElement selectGrade() {
		selectGrade.click();
		return selectGrade;
	}

	public WebElement selectConsumption_Type() {
		selectConsumption_Type.click();
		return selectConsumption_Type;
	}

	public void eventSave_Publish() {
		eventSave_Publish.click();
	}
	public WebElement SelectSchoolinFilter(String schoolName) {
		SelectSchoolinFilter.click();
		SelectSchoolinFilter.sendKeys(schoolName);
		return SelectSchoolinFilter;
	}
	public WebElement SelectgradeinFilter() {
		selectGradeinFilter.click();
		return selectGradeinFilter;
	}
	public WebElement logouttoggle() {
		logout_toggle.click();
		return logout_toggle;
	}
	
public WebElement logoutbutton() {
	Logout_button.click();
	return Logout_button;
}

public WebElement SelectSchoolinplannerpage(String schoolName) {
	SelectSchoolinplannerpage.click();
	SelectSchoolinplannerpage.sendKeys(schoolName);
	return SelectSchoolinplannerpage;
}


	
}

