package com.mms_training.stepDefinitions;

import org.testng.Assert;

import com.mms_training.pageobject.SearchResultsPage;
import com.mms_training_basepage.TestBase;

import io.cucumber.java.en.Then;

public class SearchPageStepDef extends TestBase {

	SearchResultsPage searchResultPage = new SearchResultsPage();

	@Then("I store All the search results for the searched word {string} and search relevancy should be greater than {double}")
	public void i_store_all_the_search_results_for_the_searched_word_and_search_relevancy_should_be_greater_than(
			String searchWord, Double actualRelevancy) throws Throwable {
		Assert.assertTrue(searchResultPage.verifyRelevancyPerct(searchWord, actualRelevancy),
				"Searched Word is not very Relevant");

	}
}
