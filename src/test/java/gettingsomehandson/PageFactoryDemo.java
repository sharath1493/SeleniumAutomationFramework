package gettingsomehandson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemo {

	@FindBy(name = "q")
	private WebElement searchbox;

	private WebDriver driver;

	PageFactoryDemo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void findelements10times() {
		long st = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			searchbox.clear();
			searchbox.sendKeys("Loading");
		}
		System.out.println(System.currentTimeMillis() - st);
	}
}
