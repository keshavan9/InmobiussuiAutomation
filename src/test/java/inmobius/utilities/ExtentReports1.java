//package inmobius.utilities;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ViewName;
//
//public final class ExtentReports1 {
//
//	private ExtentReports1() {
//
//	}
//
//	public static ExtentReports extent;
//	public static ExtentTest test;
//
//	public static void initReports() {
//
//		extent = new ExtentReports();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		Date date = new Date();
//		String timestamp = formatter.format(date);
//		String fileName = "extent-report_" + timestamp + ".html";
//		ExtentSparkReporter spark = new ExtentSparkReporter("reports/" + fileName).viewConfigurer().viewOrder()
//				.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR,
//						ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG })
//				.apply();
//		extent.attachReporter(spark);
//		extent.setSystemInfo("Environment", "TEST");
//		extent.setSystemInfo("OS Version", System.getProperty("os.name"));
//		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
//		extent.setSystemInfo("User Name", System.getProperty("user.name"));
//		spark.config().setDocumentTitle("Test Reports");
//		spark.config().setReportName("Testing reports");
//	}
//
//	public static void flushReports() throws IOException {
//		extent.flush();
//	}
//
//	public static void createTest(String testName) {
//		test = extent.createTest(testName);
//	}
//}
