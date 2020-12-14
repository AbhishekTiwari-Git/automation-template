package com.mms_training.stepDefinitions;

import org.testng.Assert;

import com.mms_training.pageobject.NEJMCatalystMyAccountPage;
import com.mms_training_basepage.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NEJMCatalystMyAccountStepDef extends TestBase {

	NEJMCatalystMyAccountPage nejmCatalystPage = new NEJMCatalystMyAccountPage();

	@Given("I am on My Account NEJM Catalyst page")
	public void i_am_on_my_account_nejm_catalyst_page() {
		nejmCatalystPage.openMyAccountUrl();
	}

	@When("I Register user with the following details")
	public void i_register_user_with_the_following_details(DataTable dataTable) throws InterruptedException {
		nejmCatalystPage.registerUser(dataTable);
	}
	
	@When("I sign out of the application")
	public void i_sign_out_of_the_application() throws InterruptedException {
		nejmCatalystPage.signOut();
	}

	@When("I navigate to the Auth token url")
	public void i_navigate_to_the_Auth_token_url() {
		nejmCatalystPage.navigateToRespUrl();
	}

	@Then("I verify that user is logged in automatically")
	public void i_verify_that_user_is_logged_in_automatically() {
		Assert.assertTrue(nejmCatalystPage.verifyAutomaticLogin(), "User is not Logged In automatically");
	}

	@Then("I verify that My account summary section is not accessible and displays a message to sign in")
	public void i_verify_that_my_account_summary_section_is_not_accessible_and_displays_a_message_to_sign_in() {
		String expectedMsg = prop.getProperty("summarySectionMsg");
		Assert.assertEquals(nejmCatalystPage.verifySummarySection(), expectedMsg, "Summary Page is Accessible");
	}

	@Then("I verify My Account Alert Section displays the following checkboxes {string} {string} {string}")
	public void i_verify_my_account_alert_section_displays_the_following_checkboxes(String expectedCheckBx1,
			String expectedCheckBx2, String expectedCheckBx3) {
		Assert.assertTrue(nejmCatalystPage.verifyAlertsSection(expectedCheckBx1, expectedCheckBx2, expectedCheckBx3),
				"Alerts Section is either not accessible or some information is missing");
	}

	@Then("I verify My Account Saved section displayed with a message")
	public void i_verify_my_account_saved_section_displayed_with_a_message() {
		String expectedMsg = prop.getProperty("savedSectionMsg");
		Assert.assertEquals(nejmCatalystPage.verifySavedSection(), expectedMsg, "Saved section is not not Accessible");
	}

}
