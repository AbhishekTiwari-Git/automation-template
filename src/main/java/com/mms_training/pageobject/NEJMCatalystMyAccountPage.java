package com.mms_training.pageobject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mms_training_basepage.TestBase;

import io.cucumber.datatable.DataTable;

public class NEJMCatalystMyAccountPage extends TestBase {
	
	
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
	
	LocalDateTime timeStamp = LocalDateTime.now();
	
	public void openMyAccountUrl() {
		driver.get(prop.getProperty("myAccountUrl"));
	}
	
	public void registerUser(DataTable dataTable) {
		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);
		
		for(Map<String, String> data:userdata) {
			emailInputFld.sendKeys(data.get("Email"+timeStamp+"@nejmemail.com"));
			pwdInputFld.sendKeys(data.get("Password"));
			fnInputFld.sendKeys(data.get("First Name"));
			lnInputFld.sendKeys(data.get("Last Name"));
			suffixDD.click();
			suffixOption.click();
			primarySpeciltyDD.click();
			primarySpecltyOption.click();
			roleDD.click();
			roleOption.click();
			placeOfWork.click();
			placeOfWorkOption.click();
			nameOfOrg.sendKeys(data.get("Name of Organization"));
			countryDD.click();
			countryOption.click();
			registerBtn.click();
		}
	}

}
