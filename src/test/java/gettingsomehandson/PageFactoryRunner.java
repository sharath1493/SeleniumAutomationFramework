package gettingsomehandson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageFactoryRunner {

	private WebDriver driver;

	@BeforeMethod
	public void first() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void last() {
		driver.quit();
	}

	@Test
	public void pftest1() {
		driver.get("https://www.google.com/");
		PageFactoryDemo p = new PageFactoryDemo(driver);
		p.findelements10times();
	}

	@Test
	public void pfcachetest1() {
		driver.get("https://www.google.com/");
		PageFactoryCacheDemo pc = new PageFactoryCacheDemo(driver);
		pc.findelements10times();
	}

	@Test
	public void bylocatortest1() {
		driver.get("https://www.google.com/");
		ByLocatorDemo b = new ByLocatorDemo(driver);
		b.findelements10times();
	}

}
