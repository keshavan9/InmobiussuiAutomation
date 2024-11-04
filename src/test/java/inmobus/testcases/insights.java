package inmobus.testcases;

import static org.testng.Assert.assertNotNull;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.Status;
import com.qa.hubspot.listeners.TestAllureListeners;
import com.qa.hubspot.listeners.TestListeners;

import inmobius.POM.gatewayDashbaord;
//import inmobius.utilities.ExtentReports1;
import inmobius.utilities.readConfig;
import inmobius.utilities.xutils;

@Listeners({ TestAllureListeners.class, TestListeners.class })
public class insights extends base_class {
	xutils xt = new xutils();
	readConfig rcfg = new readConfig();
	public static String formattedTenantInfo;
	public static String NewTenantName;
	public static String tenantId;
//	public void insights() throws IOException, InterruptedException {
//		gatewayDashbaord gdboard=new gatewayDashbaord(driver);
//		driver.get("https://insights.devinfinitylearn.in/");
//		String Insights_ID = rcfg.getinsightsID();
//		String insights_PWD = rcfg.getinsightspassword();
//		gdboard.insightsLogin_ID(Insights_ID);
//		gdboard.insightsLogin_password(insights_PWD);
//		gdboard.Login_button();
//		WebElement textfield=driver.findElement(By.xpath("//input[@class=\"inputBox\"]"));
//		 String rd =System.getProperty("user.dir") + rcfg.getxlsheetpath();
//			String d = xutils.getCellData(rd, "InputData", 1, 1);
//			try {
//				textfield.sendKeys(d);
//			} catch (NoSuchElementException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
////				ExtentReports1.test.log(Status.FAIL, textfield+e.getMessage());
//			
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		 driver.findElement(By.xpath("//button[text()=\"Get Data\"]")).click();
//		 Thread.sleep(5000);
//		String Stduentcount=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/p")).getText();
//		 System.out.println("Students count for the school ID 'SCH1001006805' is "+ Stduentcount);
//		  StringBuffer num = new StringBuffer();
//		        for (int i=0; i<Stduentcount.length(); i++)  
//		{  
//		            if (Character.isDigit(Stduentcount.charAt(i)))  
//		                num.append(Stduentcount.charAt(i));  
//		           
//		        }   	
//			    int b = Integer.parseInt(num.toString());
//             System.out.println(b);
//				if (b==0) {
//					Assert.fail();
//				}
//		}

	@Test(priority = 0)
	public void tenantDetails() throws InterruptedException, AWTException {
		gatewayDashbaord gdboard = new gatewayDashbaord(driver);
		driver.get("https://gatewayadmin.infinitylearn.com/login");
		String GatewayDSB_ID = rcfg.gatewayDashbaord_ID();
		String insights_PWD = rcfg.getinsightspassword();
		gdboard.GatewayLogin_ID(GatewayDSB_ID);
		gdboard.GatewayLogin_PWD(insights_PWD);
		gdboard.GatewayLogin_btn();
		Thread.sleep(3000);
		gdboard.select_Tenant();
		Thread.sleep(3000);
		gdboard.create_Tenant();
		Thread.sleep(1000);
		gdboard.select_product();
//        WebElement productID = driver.findElement(By.xpath("//*[@id=\"floatingproducts-option-1\"]"));
		WebElement productID = driver.findElement(By.xpath("//li[text()=\"InMobius\"]"));
		productID.click();
//		NewTenantName ="TestingTenant nine";
		NewTenantName=xt.Create_Tenant();
		gdboard.TenantTextField(NewTenantName);
		gdboard.Tenant_Code();
		gdboard.Tenant_ContactName("Automation");
		gdboard.Tenant_phone("9066998064");
		gdboard.Tenant_Eamil("venkatesh.v@infintylearn.com");
//        gdboard.Tenat_Grades();
//        gdboard.Tenant_SelectGrade();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
		gdboard.Tenant_Source();
		gdboard.Select_Tenant_Source();
		gdboard.Tenant_Submitbutton();
		Thread.sleep(2000);
		driver.navigate().refresh();
		gdboard.select_Tenant();
		Thread.sleep(3000);
		WebElement prodcut = driver.findElement(By.xpath("//*[@id=\"floating_Product\"]"));
		prodcut.click();
		WebElement selectproduct = driver.findElement(By.xpath("//li[text()=\"InMobius\"]"));
		selectproduct.click();
		WebElement searchField = driver.findElement(By.xpath("//input[@class=\"search-element\"]"));
		searchField.sendKeys(NewTenantName);
		searchField.click();
		Thread.sleep(1000);
		searchField.sendKeys(Keys.ENTER);
		
	   WebElement tenantIdElement = driver
				.findElement(By.xpath("//td[contains(text(),'" + NewTenantName + "')]/preceding-sibling::td"));
		tenantId = tenantIdElement.getText();
		System.out.println("Tenant ID: " + tenantId);
		formattedTenantInfo = NewTenantName + "-(" + tenantIdElement.getText() + ")";
		System.out.println(formattedTenantInfo);
		
	}

}
