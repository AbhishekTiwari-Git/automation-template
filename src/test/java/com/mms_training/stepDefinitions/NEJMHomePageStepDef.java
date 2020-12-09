package com.mms_training.stepDefinitions;

import org.testng.Assert;

import com.mms_training.pageobject.NEJMHomePage;
import com.mms_training_basepage.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NEJMHomePageStepDef extends TestBase {

	NEJMHomePage nejmHP = new NEJMHomePage();

	@When("I am on the nejm home page")
	public void i_am_on_the_nejm_home_page_something() throws Throwable {
		nejmHP.openURL();

	}

	@Then("I verify the NEJM home page header buttons should be displayed")
	public void i_verify_the_nejm_home_page_header_buttons_should_be_displayed() throws Throwable {
		Assert.assertTrue(nejmHP.verifyHomePageBtns(), "NEJM Home Buttons are not displayed as expected");

	}
}
