package stepDefinitions;

import BasePage.TestBase;
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
