package com.mms_training.stepDefinitions;

import com.mms_training_basepage.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooksStepDef extends TestBase{
	
	@Before
	public void setUp() {
		initialization();
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
