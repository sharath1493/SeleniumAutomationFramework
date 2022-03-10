package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {

	private By linkWelcome = By.xpath("//a[@id='welcome']");
	private By linkLogout = By.linkText("Logout");

	// https://opensource-demo.orangehrmlive.com/index.php/dashboard

	public OrangeHRMLoginPage clickLogout() {
		doClick(linkWelcome, WaitStrategy.CLICKABLE, "Welcome Link");

		// Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2)); // Another way
		// of Thread.sleep. But it does not ask to throw exception
		doClick(linkLogout, WaitStrategy.CLICKABLE, "Log Out Link");

		return new OrangeHRMLoginPage();
	}

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageURL() {
		return getPageURL();
	}
}
