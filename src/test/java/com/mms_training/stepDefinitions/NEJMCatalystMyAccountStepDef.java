package com.mms_training.stepDefinitions;

import com.mms_training.pageobject.NEJMCatalystMyAccountPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class NEJMCatalystMyAccountStepDef {
	
	NEJMCatalystMyAccountPage nejmCatalystPage = new NEJMCatalystMyAccountPage();

	@Given("I am on My Account NEJM Catalyst page")
	public void i_am_on_my_account_nejm_catalyst_page() {
		nejmCatalystPage.openMyAccountUrl();
	}

	@Given("I Register user with the following details")
	public void i_register_user_with_the_following_details(DataTable dataTable) {
		nejmCatalystPage.registerUser(dataTable);
	}

}
