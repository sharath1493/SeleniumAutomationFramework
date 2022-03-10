package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports e = null;
	public static ExtentTest test;

	public static void initReport() {

		if (Objects.isNull(e)) {
			e = new ExtentReports();
			ExtentSparkReporter s = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
			e.attachReporter(s);

			s.config().setTheme(Theme.DARK);
			s.config().setDocumentTitle("TMB");
			s.config().setReportName("Selenium");
		}

	}

	public static void createTest(String testcasename) {
		test = e.createTest(testcasename);
		ExtentManager.setExtentTest(test);

	}

	public static void flushReport() {
		if (Objects.nonNull(e)) {
			e.flush();

			try {
				ExtentManager.unload();
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void addAuthors(String[] authors) {
		for (String author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author);

		}
	}

	public static void addCategories(CategoryType[] categories) {
		for (CategoryType category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());

		}
	}
}
