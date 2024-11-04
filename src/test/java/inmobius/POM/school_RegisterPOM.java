package inmobius.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class school_RegisterPOM {
         public static WebDriver driver;
		public WebDriverWait wait;


		public school_RegisterPOM(WebDriver driver) {
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 10);;
		}
		
		@FindBy(xpath="//li[@id=\"invitecode\"]")
		WebElement invitationcode_button;
		
		
		public void invitation_codebutton() {
			invitationcode_button.click();
		}
		
		@FindBy(xpath="//*[@id=\"mapNewCode\"]")
		WebElement mapnewcode;
		public void mapnew_code_button_click() {
			mapnewcode.click();
		}
		
		@FindBy(xpath="//*[@id=\"tenant_id\"]")
		WebElement enter_Tenantname;
		
		public void enter_TenantID(String tenanName) throws InterruptedException {
			enter_Tenantname.sendKeys(tenanName);
		   
			
		}
		
		@FindBy(xpath="//*[@id=\"tenant_id\"]")
		WebElement enter_Tenantnameclick;
		
		public void enter_TenantIDclick() {
		
			enter_Tenantnameclick.click();
		}
		
		
		@FindBy(xpath="//button[text()=\"Map\"]")
		WebElement map;
		public void map_click() {
			map.click();
			}
		
		
		
		@FindBy(xpath="//*[@id=\"myInput\"]")
		WebElement enterTenant;
		public void enter_tenantName(String tenantName) {
			enterTenant.sendKeys(tenantName);
		}
		
		@FindBy(xpath="//div[@class=\"dropdown action__dropdown v-align-middle ms-2\"]")
		WebElement logout_toggle;
		public WebElement logouttoggle() {
			logout_toggle.click();
			return logout_toggle;
		}
		
		
		@FindBy(xpath="//*[@id=\"main\"]/nav/div/div/div[2]/div[2]/div")
		WebElement LogoutDropdown;
		
		public void LogoutDropdown() {
			LogoutDropdown.click();
		}
		
		
		@FindBy(xpath="//*[@id=\"logout\"]")
		WebElement Logout;
		
		public void SALogout() {
			Logout.click();
		}
		
		
		
		@FindBy(xpath="//ul[@class='dropdown-menu show']//a[@id='logout']")
		WebElement Logout_button;
		public WebElement logoutbutton() {
			Logout_button.click();
			return Logout_button;
		}
		
		@FindBy(xpath="//img[@alt=\"School\"]")
		WebElement schoolbutton;
		public void schoolbuttononhomepage() {
			schoolbutton.click();
		}
		
		@FindBy(xpath="//input[@name=\"firstName\"]")
		WebElement school_firstname;
		public void school_firstName(String firstName) {
			school_firstname.sendKeys(firstName);
			}
		@FindBy(xpath="//input[@placeholder=\"Enter your email id\"]") WebElement emailID;
		public void email_ID(String mailid) {
			emailID.sendKeys(mailid);
		}
		@FindBy(xpath="//input[@name=\"schoolName\"]") WebElement SchoolName;
		public void school_name(String schoolName) {
			SchoolName.sendKeys(schoolName);
		}
		@FindBy(xpath="//input[@placeholder=\"Enter invitation code\"]") WebElement invitation_code;
		public void enter_invitationcode(String code)
		{invitation_code.sendKeys(code);}
		
		@FindBy(xpath="//input[@name=\"phoneNumber\"]") WebElement number;
		public void enter_number(String Number) {
			number.sendKeys(Number);
		}
		
//		@FindBy(xpath="//button[text()=\"Continue\"]") WebElement continue_Button;
//		public void click_on_continue() throws InterruptedException {
//			Thread.sleep(2000);
//			continue_Button.click();}
		
		@FindBy(xpath="//*[@aria-label=\"Please enter OTP character 1\"]") WebElement enter_Otp;
		public void enter_Opt(String OTP) {
			enter_Otp.sendKeys(OTP);
		}
		
		@FindBy(xpath="//button[text()=\"Continue\"]") WebElement continue_button;
		public void click_continuebutton() {
			continue_button.click();
		}
		
		@FindBy(xpath="//*[@class=\"iticks-last-msg\"]") WebElement chatbot;
		public void click_chatbot() {
			chatbot.click();
		}
		
		@FindBy(xpath="//*[@class=\"icon-sm light-icon\"]") WebElement chatbot_close;
		public void close_chatbot() {
			chatbot_close.click();
		}
		
		@FindBy(xpath="//a[text()=\"Start Now\"]") WebElement start_button;
		public void start_now() {
			start_button.click();
		}
		
		@FindBy(xpath="//*[@id=\"root\"]//span[text()=\"Select...\"][1]") WebElement schooltype_dropdown;
		public void schooltype_dropdown() {
			schooltype_dropdown.click();
		}
		
		@FindBy(xpath="//div[text()=\"Public\"]") WebElement select_schooltype;
		public void select_schooltype() {
			select_schooltype.click();
		}
		
		@FindBy(xpath="//input[@name=\"board\"]") WebElement SchoolBoard;
		public void schoolBoard(String board) {
			SchoolBoard.sendKeys(board);
		}
		
		@FindBy(xpath="//input[@name=\"branch_name\"]") WebElement branchName;
		
		public void Enter_BranchName(String BranchName) {
			branchName.sendKeys(BranchName);
			}
		
		@FindBy(xpath="//textarea[@name=\"address\"]") WebElement schoolAddress;
		public void enter_schoolAddress(String Address) {
			schoolAddress.sendKeys(Address);
		}
		
		@FindBy(xpath="//span[text()=\"Select...\"]") WebElement country_dropdown;
          public void click_country_dropdown() {
	    country_dropdown.click();
  }
          @FindBy(xpath="//div[text()=\"India\"]") WebElement select_country;
          public void select_india() {
        	  select_country.click();
          }

          @FindBy(xpath="//span[text()=\"Select...\"][1]") WebElement state_dropdown;
          public void click_statedropdown() {
        	  state_dropdown.click();
          }
          
          @FindBy(xpath="//*[@id=\"root\"]/div/section/form/section/main/div[2]/div/div[9]/div/div/div[3]/div/div[17]") WebElement select_state;
          public void selectstate() {
        	  select_state.click();
          }
          
}

