package com.mms_training.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mms_training_basepage.TestBase;

import org.openqa.selenium.support.FindBy;

public class NEJMHomePage extends TestBase {
	
	@FindBy(xpath = "//a[@class='g-header__logo']")
	WebElement headerLink;
	
	@FindBy(xpath = "//ul[@class='g-nejm-group__user-tools']//a[@data-interactiontype='sign_in_click']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//ul[@class='g-nejm-group__user-tools']//a[@data-interactiontype='create_account_click']")
	WebElement createAccountBtn;
	
	@FindBy(xpath = "//ul[@class='g-nejm-group__user-tools']//a[@data-interactiontype='subscribe_click']")
	WebElement subscribeBtn;
	
	@FindBy(xpath = "//a[@aria-label='NEJM Logo']")
	WebElement headerLogo;
	
	public NEJMHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void openURL() {
		driver.get(prop.getProperty("url"));
	}

	public boolean verifyHomePageBtns() {
		boolean flag = false;
		boolean nejmHomePageTitle = driver.getTitle().equals(prop.getProperty("homePageTitle"));
		boolean signIn = signInBtn.isDisplayed();

		boolean createAccountButton = createAccountBtn.isDisplayed();

		boolean subscribeButton = subscribeBtn.isDisplayed();

		boolean nejmHeaderLogo = headerLogo.isDisplayed();

		if ((((nejmHomePageTitle == true && signIn == true) && createAccountButton == true) && subscribeButton == true)
				&& nejmHeaderLogo == true) {
			flag=true;
		}

			return flag;
	}
}
