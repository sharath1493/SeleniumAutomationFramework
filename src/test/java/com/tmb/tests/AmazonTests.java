package com.tmb.tests;

import java.time.Duration;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AmazonHomePage;
import com.tmb.pages.AmazonLaptopsPage;

public final class AmazonTests extends BaseTest {

	@FrameworkAnnotation(author = { "SG", "Billy" }, category = { CategoryType.MINIREGRESSION, CategoryType.REGRESSION, CategoryType.SMOKE })
	@Test
	public void demoAmazonTest(Map<String, String> m) {
		
		System.out.println("Test Started");

		AmazonLaptopsPage clickLaptopsLink = new AmazonHomePage().clickHamburgerMenu()
				.clickLinksonHamburgerMenu("Mobiles, Computers").clickLaptopsLink("Laptops");

		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

		String title = clickLaptopsLink.getLaptopPageTitle();

		System.out.println(title);
		System.out.println("Test Ended before Assertion");

		Assertions.assertThat(title).isNotEmpty().isNotNull();
		System.out.println("Test Ended After Assertion");


	}

}
