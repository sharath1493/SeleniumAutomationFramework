package testnglistenershandson;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before Suite in Runner");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("After Suite in Runner");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before Method in Runner");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("After Method in Runner");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("Before Test in Runner");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("After Test in Runner");
	}

	@Test
	public void test1() {
		System.out.println("Test1");
	}

	@Test()
	public void test2() {
		System.out.println("Test2");
		Assert.assertTrue(false);
	}

	@Test
	public void test3() {
		System.out.println("Test3");
	}

}
