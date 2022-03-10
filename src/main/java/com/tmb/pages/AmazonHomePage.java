package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage{
	
	private By buttonHamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
	
	public AmazonHamburgerPage clickHamburgerMenu()
	{
		doClick(buttonHamburgerMenu, WaitStrategy.CLICKABLE, "HamburgerMenu" );
		return new AmazonHamburgerPage();
	}

	
}
