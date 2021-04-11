package com.selenium.stepDefinitions;

import com.selenium.pageobject.worldomerterPage;
import com.selenium_basepage.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class worldometerStepDef extends TestBase {

	worldomerterPage wmPage = new worldomerterPage();

	@When("I am on the worldometer home page")
	public void i_am_on_the_worldometer_home_page() {
		wmPage.navToWM();
	}
	
	@And("I print the world population numbers")
	public void print_numbers() {
		wmPage.print_numbers();
	}

}
