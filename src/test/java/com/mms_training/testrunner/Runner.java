package com.mms_training.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)	
@CucumberOptions(features="src/test/resources/Features/nejm.feature",
			glue={"com.mms_training.stepDefinitions"},
			plugin={ "pretty","html:target/cucumber-html-report", "json:target/cucumber.json",
					"pretty:target/cucumber-pretty.txt",
			"usage:target/cucumber-usage.json" },
			dryRun = false,
			publish=true)
public class Runner {

}
