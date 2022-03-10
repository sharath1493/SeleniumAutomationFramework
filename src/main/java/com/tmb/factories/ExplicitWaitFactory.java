package com.tmb.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWait(By by, WaitStrategy waitstrategy)
	{
		WebElement element=null;
		if(waitstrategy.equals(WaitStrategy.CLICKABLE))
		{
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy.equals(WaitStrategy.PRESENCE))
		{
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy.equals(WaitStrategy.VISIBLE))
		{
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if(waitstrategy.equals(WaitStrategy.NONE))
		{
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
