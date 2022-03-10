package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.listeners.RetryFailedTests;
import com.tmb.pages.OrangeHRMHomePage;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataProvideUtils;

public final class OrangeHRMTests extends BaseTest {
	
	@FrameworkAnnotation(author = "Ana De Armes", category = CategoryType.FUNCTIONAL)
	@Test(dataProvider = "getData", dataProviderClass = DataProvideUtils.class, retryAnalyzer = RetryFailedTests.class)
	public void validateLoginLogout(Map<String, String> m) {

		Assertions.assertThat(new OrangeHRMLoginPage().getLoginPageTitle()).isEqualTo("OrangeHRM");

		OrangeHRMHomePage ohhp = new OrangeHRMLoginPage().enterUsername(m.get("username"))
				.enterPassword(m.get("password")).clickLogin();

		Assertions.assertThat(ohhp.getHomePageURL())
				.isEqualTo("https://opensource-demo.orangehrmlive.com/index.php/dashboard");

		String loginpagetitle = ohhp.clickLogout().getLoginPageTitle();

		Assertions.assertThat(loginpagetitle).isEqualTo("OrangeHRM");

	}

	@FrameworkAnnotation(author = "Bond", category = CategoryType.SANITY)
	@Test(dataProvider = "getData", dataProviderClass = DataProvideUtils.class, retryAnalyzer = RetryFailedTests.class)
	public void newTest(Map<String, String> m) {

		Assertions.assertThat(new OrangeHRMLoginPage().getLoginPageTitle()).isEqualTo("OrangeHRM");

		OrangeHRMHomePage ohhp = new OrangeHRMLoginPage().enterUsername(m.get("username"))
				.enterPassword(m.get("password")).clickLogin();

		Assertions.assertThat(ohhp.getHomePageURL())
				.isEqualTo("https://opensource-demo.orangehrmlive.com/index.php/dashboard");

		String loginpagetitle = ohhp.clickLogout().getLoginPageTitle();

		Assertions.assertThat(loginpagetitle).isEqualTo("OrangeHRM");

	}

	@FrameworkAnnotation(author = "Tristan", category = CategoryType.MINIREGRESSION)
	@Test
	public void test(Map<String, String> m) {
		Assert.assertTrue(false);
	}

	@DataProvider(name = "yourdata", parallel = true)
	public Object[][] mydata() {
		return new Object[][] {
				{ "Admin", "admin123" }/*
										 * , { "Admin", "admin123" }, { "Admin", "admin1233" }, { "Admin", "admin123" },
										 * { "Admin1", "admin123" }, { "Admin1", "admin1231" }
										 */ };

	}

}
