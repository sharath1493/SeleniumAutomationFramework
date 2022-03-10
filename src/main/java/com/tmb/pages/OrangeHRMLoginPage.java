package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {

	private By textboxUsername = By.id("txtUsername");
	private By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private By btnLogin = By.id("btnLogin");
	private By linkForgotPassword = By.linkText("Forgot your password?");

	public OrangeHRMLoginPage enterUsername(String uname) {

		doSendKeys(textboxUsername, uname, WaitStrategy.VISIBLE, "Username textbox");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String pwd) {

		doSendKeys(textboxPassword, pwd, WaitStrategy.VISIBLE,"Password textbox");
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		doClick(btnLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new OrangeHRMHomePage();
	}

	public OrangeHRMForgotPasswordPage clickForgotPassword() {
		doClick(linkForgotPassword, WaitStrategy.CLICKABLE, "Forgot Password Link");
		return new OrangeHRMForgotPasswordPage();
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}

}
