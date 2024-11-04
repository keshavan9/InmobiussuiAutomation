package inmobius.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;

	public readConfig()
	{
		File src = new File("./Configuration/Config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);	
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is : "+e.getMessage());	
		}
	}
	
	public String getLoginID() {
		String LoginID=pro.getProperty("LoginID");
		return LoginID;
	}

	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseUrl");
		return url;
	}
	public String getxlsheetpath()
	{
		String xlpathh = pro.getProperty("xlsheet");
		return xlpathh;
	}

	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEpath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}


	public String getPath() {
		String path = pro.getProperty("Path");
		return path;
	}
	
	public String get_schoolcode() {
		String school_Code = pro.getProperty("schoolcode");
	    return school_Code;
	}
	public String selectGradeInFilter() {
		String grade = pro.getProperty("grade");
		return grade;
	}
	
	
	public String schoolAdminUsername() {
		String SchoolAdminUSN = pro.getProperty("schoolAdmin");
		return SchoolAdminUSN;
	}
	
	
	public String schoolAdminUserpwd() {
		String schoolAdminUserpwd = pro.getProperty("schoolAdminPwd");
		return schoolAdminUserpwd;
	}
	public String studentLoginPage() {
		String studentLoginPage = pro.getProperty("StudentLogin");
		return studentLoginPage;
	}
	public String studentUserName() {
		String studentUserName = pro.getProperty("stUserName");
		return studentUserName;
	}
	public String studentPassword() {
		String studentPassword = pro.getProperty("stPassword");
		return studentPassword;
	}
	public String new_Password() {
		String set_new_Password = pro.getProperty("newPassword");
		return set_new_Password;
	}
	public String getAdminUsername()
	{
		String username = pro.getProperty("Adminusername");
		return username;
	}

	public String getAdminPassword()
	{
		String password = pro.getProperty("Adminpassword");
		return password;
	}

	public String getSchoolName()
	{
		String password = pro.getProperty("SchoolName");
		return password;
	}
	public String getreportpath()
	{
		String reportspath = pro.getProperty("reportpath");
		return reportspath;
	}
	public String getinsightsID()
	{
		String insightsID = pro.getProperty("insightsID");
		return insightsID;
	}
	
	public String getinsightspassword()
	{
		String insightspassword = pro.getProperty("insightspassword");
		return insightspassword;
	}
	
	
	public String gatewayDashbaord_ID()
	{
		String insightspassword = pro.getProperty("gatewayDashbaord_ID");
		return insightspassword;
	}
	
}


