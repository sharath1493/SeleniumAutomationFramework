package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected String getPageURL() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	protected void doSendKeys(By by, String text, WaitStrategy waitstrategy, String element) {
		WebElement ele = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
		ele.clear();
		ele.sendKeys(text);
		ExtentLogger.pass("Value '"+text + "' is entered in field: " + element, true);
	}

	protected void doClick(By by, WaitStrategy waitstrategy, String element) {
		WebElement ele = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
		ele.click();
		ExtentLogger.pass("'"+element + "' is clicked successfully", true);
	}

}
