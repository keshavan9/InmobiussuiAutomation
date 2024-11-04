package inmobius.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gatewayDashbaord {
	public static WebDriver driver;
	public WebDriverWait wait;
	
	
	public gatewayDashbaord(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 10);;
	}
	@FindBy(xpath="//*[@id=\"floatingadmission_number\"]")
	WebElement Login_ID;
	
	public void insightsLogin_ID(String Username) {
		Login_ID.sendKeys(Username);
	} 
	//--------------------------------------------------------------------------------
	
	
	@FindBy(xpath="//*[@id=\"floatingpassword\"]")
	WebElement Login_Password;
	
	public void insightsLogin_password(String PWD) {
		Login_Password.sendKeys(PWD);
	} 
	//----------------------------------------------------------------
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElement Login_button;
	
	public void Login_button() {
		Login_button.click();
	} 
	
	//----------------------------------------------------
	
	@FindBy(xpath="//input[@id=\"floatingadmission_number\"]")
	WebElement GatewayLogin;
	
	public void GatewayLogin_ID(String LoginID) {
		GatewayLogin.sendKeys(LoginID);
	} 
	//-------------------------------------------------------
	
	@FindBy(xpath="//input[@id=\"floatingpassword\"]")
	WebElement GatewayLogin_PWD;
	
	public void GatewayLogin_PWD(String Password) {
		GatewayLogin_PWD.clear();
		GatewayLogin_PWD.sendKeys(Password);
	} 
	//--------------------------------------------------------------
	
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElement GatewayLogin_btn;
	
	public void GatewayLogin_btn() {
		GatewayLogin_btn.click();
	}
	//----------------------------------------------------------
		
//		@FindBy(xpath="//span[text()=\"Tenants\"]")
		@FindBy(xpath="//*[@id=\"main\"]/div/div/ul/div[2]/div/div[2]/div/div/ul/a[1]/div[2]/span")
		WebElement Tenant;
		
		public void select_Tenant() {
			Tenant.click();
		}
	//--------------------------------------------------------------
		
		@FindBy(xpath="//*[@id=\"main\"]/section/div[1]/button")
	
		WebElement Create_Tenant;
		
		public void create_Tenant() {
			Create_Tenant.click();
		}
		//------------------------------------------------------
		
		@FindBy(xpath="//*[@id=\"floatingproducts\"]")
		WebElement Select_Prodcut;
		
		public void select_product() {
			Select_Prodcut.click();
		}
		//-----------------------------------------------
		@FindBy(xpath="//button[text()=\"Generate Code\"]")
		WebElement Tenant_Code;
		
	   public void Tenant_Code() {
		Tenant_Code.click();
	}
	   //---------------------------------------
	   @FindBy(xpath="//*[@id=\"floatingtenant_name\"]")
	   WebElement TenantNameTextField;
	   
	   public void TenantTextField(String TenantName) {
		   TenantNameTextField.sendKeys(TenantName);
	   }
	   //------------------------------------------
	   @FindBy(xpath="//*[@id=\"floatingprimary_contact_name\"]")
	   WebElement ContactName;
	   
	   public void Tenant_ContactName(String Name) {
		   ContactName.sendKeys(Name);
	   }
	   //------------------------------------------
	  
	   @FindBy(xpath="//*[@id=\"floatingprimary_contact_phone\"]")
	   WebElement Tenant_Contact_phone;
	   
	   public void Tenant_phone(String phone) {
		   Tenant_Contact_phone.sendKeys(phone);
	   }
	   //---------------------------------------------
	 
	   @FindBy(xpath="//*[@id=\"floatingprimary_contact_email\"]")
	   WebElement Tenant_email;
	   
	   public void Tenant_Eamil(String Email) {
		   Tenant_email.sendKeys(Email);
	   }
	   
	   //---------------------------------------
	   @FindBy(xpath="//*[@id=\"floatinggrades\"]")
	   WebElement Selectgrades;
	   
	   public void Tenat_Grades() {
	   Selectgrades.click();
	   }
	   //---------------------------------------------
	   @FindBy(xpath="//*[@id=\"floatinggrades-option-0\"]")
	   WebElement SelectAll;
	   
	   public void Tenant_SelectGrade() {
		   SelectAll.click();
	   }
	   //----------------------------------------------------
	   
	   @FindBy(xpath="//*[@id=\"floatingsource\"]")
	   WebElement Tenant_Source;
	   
	   public void Tenant_Source() {
		   Tenant_Source.click();
	   }
	   //---------------------------------------------------------
	   @FindBy(xpath="//*[@id=\"floatingsource-option-0\"]")
	   WebElement Select_Tenantrsource;
	   
	   public void Select_Tenant_Source() {
		   Select_Tenantrsource.click();
	   }
	   //--------------------------------------------------------
	   @FindBy(xpath="//button[text()=\"Submit\"]")
	   WebElement Submitbutton;
	   
	   public void Tenant_Submitbutton() {
		   Submitbutton.click();
	   }
	   
	   
	   
       
}





	
