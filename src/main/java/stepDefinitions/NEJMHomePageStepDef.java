package stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import BasePage.TestBase;
import PageObject.NEJMHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NEJMHomePageStepDef extends TestBase {

	NEJMHomePage nejmHP;

	@When("I am on the nejm home page {string}")
	public void i_am_on_the_nejm_home_page_something(String site) throws Throwable {
		nejmHP = new NEJMHomePage();
		nejmHP.openURL(site);

	}

	@Then("I verify the NEJM home page header buttons should be displayed")
	public void i_verify_the_nejm_home_page_header_buttons_should_be_displayed() throws Throwable {
		nejmHP = new NEJMHomePage();
		Assert.assertTrue(nejmHP.verifyHomePageBtns(), "NEJM Home Buttons are not displayed as expected");

	}
}
