package stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePage.TestBase;
import PageObject.SearchResultsPage;
import io.cucumber.java.en.Then;

public class SearchPageStepDef extends TestBase {

	SearchResultsPage searchResultPage;

	@Then("I store All the search results for the searched word {string} and search relevancy should be greater than {double}")
	public void i_store_all_the_search_results_for_the_searched_word_and_search_relevancy_should_be_greater_than(
			String searchWord, Double actualRelevancy) throws Throwable {
		searchResultPage = new SearchResultsPage();
		Assert.assertTrue(searchResultPage.verifyRelevancyPerct(searchWord, actualRelevancy),
				"Searched Word is not very Relevant");

	}
}
