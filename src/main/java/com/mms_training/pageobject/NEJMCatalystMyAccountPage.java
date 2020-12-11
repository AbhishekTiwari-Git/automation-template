package com.mms_training.pageobject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mms_training_basepage.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;

import static io.restassured.RestAssured.*;

public class NEJMCatalystMyAccountPage extends TestBase {

	@FindBy(xpath = "//div[@class='header_top-bar_right']//a[@title='Create Account']/span")
	WebElement createAccountBtn;

	@FindBy(name = "uccEmail")
	WebElement emailInputFld;

	@FindBy(name = "uccPwd")
	WebElement pwdInputFld;

	@FindBy(name = "uccFirstName")
	WebElement fnInputFld;

	@FindBy(name = "uccLastName")
	WebElement lnInputFld;

	@FindBy(name = "uccSuffix")
	WebElement suffixDD;

	@FindBy(xpath = "//select[@name='uccSuffix']/option[text()='MD']")
	WebElement suffixOption;

	@FindBy(name = "uccSpecialty")
	WebElement primarySpeciltyDD;

	@FindBy(xpath = "//div[@data-result='Allergy']")
	WebElement primarySpecltyOption;

	@FindBy(name = "uccRole")
	WebElement roleDD;

	@FindBy(xpath = "//select[@name='uccRole']/option[@value='CEO']")
	WebElement roleOption;

	@FindBy(name = "uccPlaceOfWork")
	WebElement placeOfWork;

	@FindBy(xpath = "//select[@name='uccPlaceOfWork']/option[@value='CLI']")
	WebElement placeOfWorkOption;

	@FindBy(name = "uccNameOfOrg")
	WebElement nameOfOrg;

	@FindBy(name = "uccCountry")
	WebElement countryDD;

	@FindBy(xpath = "//select[@name='uccCountry']/option[@value='USA']")
	WebElement countryOption;

	@FindBy(xpath = "//button[text()='Register']")
	WebElement registerBtn;

	@FindBy(xpath = "//div[@class='header_top-bar_right']//a[@title='TestQA_fn TestQA_ln']")
	WebElement loggedInUserID;

	@FindBy(xpath = "//div[@class='infoSoftAuth']")
	WebElement summaryPageSignIn;

	@FindBy(xpath = "//label[@class='checkbox--primary']//span/b")
	List<WebElement> alertSectionChkbxs;

	@FindBy(xpath = "//div[@class='my-account_msg--lg']/p")
	WebElement savedSectionMsg;

	@FindBy(xpath = "//ul[@class='my-account_nav-list']//a[@title='Summary']")
	WebElement sideNavSummaryBtn;

	@FindBy(xpath = "//ul[@class='my-account_nav-list']//a[@title='Alerts']")
	WebElement sideNavAlertBtn;

	@FindBy(xpath = "//ul[@class='my-account_nav-list']//a[@title='Saved']")
	WebElement sideNavSavedBtn;

	LocalDateTime timeStamp = LocalDateTime.now();
	String email, password, response;
	CloseableHttpResponse httpResponse;
	String[] urlTest;
	String[] authTokenUrl;

	public NEJMCatalystMyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void openMyAccountUrl() {
		driver.get(prop.getProperty("myAccountUrl"));
	}

	public void registerUser(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", createAccountBtn);

		for (Map<String, String> data : userdata) {
			email = (data.get("Email") + timeStamp.getNano() + "@nejmemail.com");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			emailInputFld.click();
			emailInputFld.sendKeys(email);
			password = (data.get("Password"));
			pwdInputFld.click();
			pwdInputFld.sendKeys(password);
			fnInputFld.sendKeys(data.get("First Name"));
			lnInputFld.sendKeys(data.get("Last Name"));
			suffixDD.click();
			suffixOption.click();
			primarySpeciltyDD.click();
			primarySpecltyOption.click();
			executor.executeScript("arguments[0].scrollIntoView(true);", roleDD);
			roleDD.click();
			roleOption.click();
			placeOfWork.click();
			placeOfWorkOption.click();
			nameOfOrg.sendKeys(data.get("Name of Organization"));
			countryDD.click();
			countryOption.click();
			registerBtn.click();
		}

		JSONObject body_json = new JSONObject();
		body_json.put("username", email);
		body_json.put("password", password);
		body_json.put("exp", "2021-08-03T15:33:24.583Z");

		response = given().baseUri("https://myaccount.nejm-qa.org").headers("Content-Type", "application/json")
				.body(body_json).when().post("/qa/generateSsoUrlToken").getBody().asString();

	}

	public void navigateToRespUrl() {
		urlTest = response.split(",");
		authTokenUrl = urlTest[1].split("//");
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.get("https://" + authTokenUrl[1].replace("}", ""));
	}

	public boolean verifyAutomaticLogin() {
		return loggedInUserID.isDisplayed();
	}

	public String verifySummarySection() {
		sideNavSummaryBtn.click();
		String summaryPage = summaryPageSignIn.getText();
		return summaryPage;
	}

	public boolean verifyAlertsSection(String expectedCheckBx1, String expectedCheckBx2, String expectedCheckBx3) {
		boolean actualCheckBx1 = false, actualCheckBx2 = false, actualCheckBx3 = false, flag = false;
		sideNavAlertBtn.click();
		List<WebElement> alertsCheckboxesList = alertSectionChkbxs;
		for (WebElement checkboxes : alertsCheckboxesList) {
			String value = checkboxes.getText();
			switch (value) {
			case "Connect":
				actualCheckBx1 = checkboxes.getText().equals(expectedCheckBx1);
				break;
			case "Editors' Picks":
				actualCheckBx2 = checkboxes.getText().equals(expectedCheckBx2);
				break;
			case "General Information":
				actualCheckBx3 = checkboxes.getText().equals(expectedCheckBx3);
				break;
			default:
				flag = false;

			}

		}
		if ((actualCheckBx1 == true && actualCheckBx2 == true) && actualCheckBx3 == true) {
			flag = true;
		}
		return flag;

	}

	public String verifySavedSection() {
		sideNavSavedBtn.click();
		System.out.println("Saved Section Message===>" + savedSectionMsg.getText());
		String saveSectnMsg = savedSectionMsg.getText();
		return saveSectnMsg;
	}

}
