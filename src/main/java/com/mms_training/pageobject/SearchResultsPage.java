package com.mms_training.pageobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mms_training_basepage.TestBase;

public class SearchResultsPage extends TestBase {

	@FindBy(xpath = "//a[@title='search']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@id='sli_search_2']")
	WebElement searchInput;

	@FindBy(xpath = "//div[@id='search']//button[@title='search' and @type='submit']")
	WebElement submitSearch;

	@FindBy(xpath = "//span[@class='m-result__main']/strong")
	List<WebElement> searchResults;

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyRelevancyPerct(String searchWord, Double actualRelevancy) {
		boolean flag = false;
		int searchWordCount = 0, totalResults = 0, count = 0;
		double expectedRelevancy;
		searchIcon.click();
		searchInput.sendKeys(searchWord);
		submitSearch.click();

		List<WebElement> searchResultList = searchResults;
		List<HashMap> result = new ArrayList<HashMap>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		result.add(map);

		for (WebElement resultList : searchResultList) {
			map.put(resultList.getText(), count = count + 1);
		}

		Set<java.util.Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (java.util.Map.Entry<String, Integer> entry : entrySet) {
			System.out.println("Key is===>" + entry.getKey() + " " + "Value is==>" + entry.getValue());
			String searchResult = entry.getKey().toLowerCase();

			Pattern p = Pattern.compile("heart");
			Matcher m = p.matcher(searchResult);

			while (m.find()) {
				searchWordCount++;
			}
			totalResults++;
		}
		expectedRelevancy = ((searchWordCount * 100) / totalResults);

		if (expectedRelevancy > actualRelevancy) {
			flag = true;
		}
		return flag;
	}

}
