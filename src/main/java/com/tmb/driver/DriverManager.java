package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {
	}

	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return tl.get();
	}

	static void setDriver(WebDriver driverref) {
		if (Objects.nonNull(driverref)) {
			tl.set(driverref);
		}

	}

	static void unload() {
		tl.remove();
	}
}
