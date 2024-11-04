package com.qa.hubspot.listeners;

import java.util.ArrayList;
	import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import inmobius.utilities.LoggerUtil;
import junit.framework.TestListener;

public class TestListeners implements IRetryAnalyzer, ITestListener{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

	    private static int totalTests = 0;
	    private static int passedTests = 0;
	    private static int failedTests = 0;
	    private static int skippedTests = 0;
	    private int counter = 0;
	    private int retryLimit = 1;
	    private static List<String> failedTestNames = new ArrayList<>();


	    @Override
	    public void onStart(final ITestContext context) {
	        // Optional: Code to execute before any test starts
	    }

	    @Override
	    public void onTestStart(final ITestResult result) {
	        totalTests++;
	    }

	    @Override
	    public void onFinish(final ITestContext context) {
	        System.out.println("Total Tests: " + totalTests);
	        System.out.println("Passed Tests: " + passedTests);
	        System.out.println("Failed Tests: " + failedTests);
	        System.out.println("Skipped Tests: " + skippedTests);
	    }

	    @Override
	    public void onTestSuccess(final ITestResult result) {
	        passedTests++;
	        logTestResult(result, "SUCCESS");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        failedTests++;
	        logTestResult(result, "FAILURE");
	        // Add the name of the failed test case to the list
	        failedTestNames.add(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(final ITestResult result) {
	        skippedTests++;
	        logTestResult(result, "SKIPPED");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
	        logTestResult(result, "FAILED WITH SUCCESS PERCENTAGE");
	    }

	    private void logTestResult(ITestResult result, String status) {
	   LoggerUtil.logConsoleMessage(status);
	      
	    }

	    @Override
	    public boolean retry(ITestResult result) {
	        if (counter < retryLimit) {
	            counter++;
	            return true;
	        }
	        return false;
	    }

	    // Getter methods for test execution statistics
	    public static int getTotalTests() {
	        return totalTests;
	    }

	    public static int getPassedTests() {
	        return passedTests;
	    }

	    public static int getFailedTests() {
	        return failedTests;
	    }

	    public static int getSkippedTests() {
	        return skippedTests;
	    }

	    public static List<String> getFailedTestNames() {
	        return failedTestNames;
	    }
}

	
