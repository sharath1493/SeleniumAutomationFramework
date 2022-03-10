package com.tmb.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {
	}

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(String browser, String methodName) throws MalformedURLException {
		WebDriver driver = null;
		String runmode = ReadPropertyFile.get(ConfigProperties.RUNMODE);
		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("name", methodName);


		if (browser.equalsIgnoreCase("chrome"))

		{
			if (runmode.equalsIgnoreCase("remote")) {
				// placeholder for remote driver
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--no-sandbox");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("sauce:options", sauceOpts);
				cap.setBrowserName(BrowserType.CHROME);
				cap.setCapability(ChromeOptions.CAPABILITY, co);
				cap.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.get(ConfigProperties.REMOTEDRIVERURL)), cap);
				System.out.println(driver);

			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("remote")) {
				// placeholder for remote driver
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("sauce:options", sauceOpts);
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.get(ConfigProperties.REMOTEDRIVERURL)), cap);

			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else {
			if (runmode.equalsIgnoreCase("remote")) {
				// placeholder for remote driver
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("sauce:options", sauceOpts);
				cap.setBrowserName(BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.get(ConfigProperties.REMOTEDRIVERURL)), cap);

			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}

		return driver;

	}

}
