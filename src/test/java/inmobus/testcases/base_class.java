package inmobus.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import inmobius.utilities.EmailUtils;
import inmobius.utilities.readConfig;
import inmobius.utilities.xutils;
import io.github.bonigarcia.wdm.WebDriverManager;



public class base_class {
//	private static final Logger LOGGER = LoggerFactory.getLogger(BaseClass.class);
	
	readConfig rcfg=new readConfig();
	xutils xt=new xutils();
	
	public String baseUrl = rcfg.getApplicationUrl() ;
	public String username = rcfg.getUsername();
	public String school_Code= rcfg.get_schoolcode();
	public String LoginID = rcfg.getLoginID();
	public String password=rcfg.getPassword();
	public String grade=rcfg.selectGradeInFilter();
	public String resetpassword=rcfg.new_Password();
	public static WebDriver driver;
//    public static Logger logger;
   
    @Parameters("browser")
	@BeforeClass
	public void setUp(String bw) throws InterruptedException
	{
		
		
//			System.setProperty("webdriver.chrome.driver",rcfg.getChromepath());
			 WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
	
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(5000);
		System.out.println("before");
//		LOGGER.info("Page URL -> "+driver.getCurrentUrl());
		System.out.println("after");
	
}
	
// @AfterClass
	public void tearDown()
	{
		driver.close();;
	}

// @AfterSuite
 public void afterSuite() {
	 EmailUtils util=new EmailUtils();
	 util.sendEmail();
     System.out.println("Suite completed. Perform after-suite actions here.");
 }



}
