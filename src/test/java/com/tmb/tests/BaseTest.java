package com.tmb.tests;

import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTest {

	protected BaseTest() {
	}

	WebDriver driver;

	@BeforeMethod
	protected void setUp(Object[] data, Method m) throws Exception {
		Map<String, String> a = (Map<String, String>) data[0];
		Driver.initDriver(a.get("browser"), m.getName());
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
