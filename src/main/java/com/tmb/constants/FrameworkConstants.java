package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\executables\\chromedriver.exe";

	private static final String GECKODRIVERPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\executables\\geckodriver.exe";

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\config\\config.properties";

	private static final String EXCELPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\TestData.xlsx";

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output";
	private static String extentreportfilepath = "";

	// Excel sheet values
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String TESTDATAITERATIONSHEET = "DATA";
	private static String methodname;

	public static String getExtentReportPath() {
		if (extentreportfilepath.isEmpty()) {
			extentreportfilepath = createExtentReportFilePath();
		}

		return extentreportfilepath;
	}

	private static String createExtentReportFilePath() {
		try {
			if (ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
				return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "/index.html";
			} else {
				return EXTENTREPORTFOLDERPATH + "/" + "index.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static final long EXPLICITWAITTIME = 15;

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static long getExplicitWaitTime() {
		return EXPLICITWAITTIME;
	}

	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}

	public static String getTestDataIterationSheet() {
		return TESTDATAITERATIONSHEET;
	}

	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}

	public static String getMethodName() {
		return methodname;
	}

	public static void setMethodName(String methodname) {
		FrameworkConstants.methodname = methodname;
	}

}
