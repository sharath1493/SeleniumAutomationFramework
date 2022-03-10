package com.tmb.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.constants.FrameworkConstants;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		FrameworkConstants.setMethodName(result.getMethod().getMethodName());
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass("'" + result.getMethod().getMethodName() + "' test is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail("'" + result.getMethod().getMethodName() + "' test is Failed", true);
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip("'" + result.getMethod().getMethodName() + "' test is Skipped");
		// Add Screenshots
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * Empty as of now
		 */
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
