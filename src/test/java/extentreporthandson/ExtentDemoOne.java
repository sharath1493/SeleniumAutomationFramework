package extentreporthandson;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentDemoOne {

	@Test
	public void test1() throws IOException {
		ExtentReports e = new ExtentReports();
		ExtentSparkReporter s = new ExtentSparkReporter("samplespark.html");
		e.attachReporter(s);

		s.config().setTheme(Theme.DARK);
		s.config().setDocumentTitle("TMB");
		s.config().setReportName("Selenium");

		ExtentTest test = e.createTest("Test1");
		test.pass("Passed . yay");

		ExtentTest test1 = e.createTest("Test1");
		test1.fail("Failed . Nay");

		e.flush();

		Desktop.getDesktop().browse(new File("samplespark.html").toURI());
	}

}
