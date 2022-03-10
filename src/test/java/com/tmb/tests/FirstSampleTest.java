package com.tmb.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class FirstSampleTest extends BaseTest {

	private FirstSampleTest() {
	}

	@Test(enabled = false)
	public void firstTest1() {

		WebDriver driver = DriverManager.getDriver();

		Assert.assertEquals(driver.getTitle(), "Google");

		driver.findElement(By.name("q")).sendKeys("Testing Mini Bytes", Keys.ENTER);

		Assert.assertTrue(driver.getTitle().contains("Testing Mini Bytes"));

		List<WebElement> a = driver.findElements(By.xpath("//div/a/h3"));

		Assert.assertEquals(a.size(), 8);
		

		for (WebElement e : a) {
			if (e.getText().equals("Testing Mini Bytes - YouTube")) {
				e.click();
				break;
			}
		}

		Assert.assertTrue(driver.getTitle().contains("YouTube"));
		
		

	}

	@Test(enabled = false)
	public void firstTest2() {
		WebDriver driver = DriverManager.getDriver();

		Assert.assertEquals(driver.getTitle(), "Noogler");

	}

}
