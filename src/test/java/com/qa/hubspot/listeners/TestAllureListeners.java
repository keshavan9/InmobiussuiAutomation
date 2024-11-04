package com.qa.hubspot.listeners;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import inmobus.testcases.base_class;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import junit.framework.TestListener;


public class TestAllureListeners extends base_class implements ITestListener{
	
    public static List<ITestNGMethod> passedtests = new ArrayList<>();
    public static List<ITestNGMethod> failedtests = new ArrayList<>();
    public static List<ITestNGMethod> skippedtests = new ArrayList<>();

    private final static Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("TEST SUIT STARTED :" + iTestContext.getSuite().getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test :" + iTestResult.getName() + " STARTED.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if (driver != null) {
            LOGGER.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            Allure.addAttachment(UUID.randomUUID().toString(),
                    new ByteArrayInputStream(((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES)));
        }
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
        LOGGER.warn("Test : " + iTestResult.getName() + " FAILED.");
        failedtests.add(iTestResult.getMethod());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        passedtests.add(iTestResult.getMethod());
        LOGGER.warn("Test : " + iTestResult.getName() + " PASSED.");
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        skippedtests.add(iTestResult.getMethod());
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
