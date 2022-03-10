package com.tmb.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.FrameworkException;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.ReadPropertyFile;

/**
 * 
 * Driver class is responsible for invoking and closing browser
 * <p>
 * it is also responsible for setting the driver variable to DriverManager which
 * is implemented with Thread Safety using ThreadLocal Concept
 * <p>
 * 
 * @author shara
 *
 */

public final class Driver {

	private Driver() {
	}

	public static void initDriver(String browser, String methodName) {

		System.out.println(Thread.currentThread().getId());

		if (Objects.isNull(DriverManager.getDriver())) {

			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, methodName));
			} catch (MalformedURLException e) {
				throw new FrameworkException("Malformed Remote WebDriver URL", e);
			}

			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL).toLowerCase());

		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			// driver = null;
			DriverManager.unload(); // Removing the driver reference
		}

	}

}
