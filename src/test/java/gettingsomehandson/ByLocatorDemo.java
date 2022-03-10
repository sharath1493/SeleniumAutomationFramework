package gettingsomehandson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ByLocatorDemo {

	private By searchbylocator = By.name("q");

	private WebDriver driver;

	ByLocatorDemo(WebDriver driver) {
		this.driver = driver;
	}

	public void findelements10times() {
		long st = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			WebElement searchbox = this.driver.findElement(searchbylocator);

			searchbox.clear();
			searchbox.sendKeys("Loading");
		}
		System.out.println(System.currentTimeMillis() - st);
	}
}
