package com.selenium.stepDefinitions;

import com.selenium_basepage.TestBase;
import com.selenium_utils.TakeScreenshot;
import com.selenium_utils.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooksStepDef extends TestBase{
	
	TakeScreenshot takeScreenshot = new TakeScreenshot();
	
	@Before
	public void setUp() {
		initialization();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		try{
			if(!getStatus(scenario).equals("1")){
				takeScreenshot.takeScreenShotForCucumber("Screenshot"+scenario);
			}
		}catch(Exception e){
			System.out.println("Error in taking screen shot");
			e.printStackTrace();
		}finally {
			driver.close();
		}
	}
	
	public String getStatus(Scenario scenario){
		System.out.println("Scenario ***"+scenario.getStatus().toString().toUpperCase());
		switch (scenario.getStatus().toString().toUpperCase()) {
		case "PASSED":
			return "1";
		case "FAILED":
			return "2";
		default:
			return "-1";
		}
	}

}
