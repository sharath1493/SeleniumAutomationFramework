package testnglistenershandson;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Before suite in Listener");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("After suite in Listener");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Before Test in Listener");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("After Test success in Listener");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("After Test Failure in Listener");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("After Test Skip in Listener");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("After Test success with some percentage in Listener");

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("After Test Failure with timeout in Listener");

	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
