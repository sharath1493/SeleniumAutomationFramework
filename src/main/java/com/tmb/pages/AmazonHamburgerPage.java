package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;

public class AmazonHamburgerPage extends BasePage {

	private String linksHamburgerLinks = "//div[normalize-space()='%s']/parent::a";
	private String linksMobileComputer = "//a[normalize-space()='%s']";
	

	public AmazonHamburgerPage clickLinksonHamburgerMenu(String link) {
		String linkXpath = DynamicXpathUtils.getDynamicXpath(linksHamburgerLinks, link);
		doClick(By.xpath(linkXpath), WaitStrategy.CLICKABLE, link);
		return this;
	}
	
	public AmazonLaptopsPage clickLaptopsLink(String link)
	{
		String linkXpath = DynamicXpathUtils.getDynamicXpath(linksMobileComputer, link);
		doClick(By.xpath(linkXpath), WaitStrategy.CLICKABLE, link);
		return new AmazonLaptopsPage();

	}

}
