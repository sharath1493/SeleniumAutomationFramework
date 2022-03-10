package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private static ThreadLocal<ExtentTest> et = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return et.get();
	}

	static void setExtentTest(ExtentTest test) {
		et.set(test);
	}

	static void unload() {
		et.remove();
	}

}
