package stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class nejmStepDef {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@When("I am on the nejm home page {string}")
	public void i_am_on_the_nejm_home_page_something(String site) throws Throwable {
		String userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userDir + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(site);

	}

	@Then("I verify the NEJM home page header buttons should be displayed")
	public void i_verify_the_nejm_home_page_header_buttons_should_be_displayed() throws Throwable {
		String headerLink = driver.findElement(By.xpath("//a[@class='g-header__logo']")).getAttribute("href");
		softAssert.assertEquals(headerLink, "https://www.nejm.org/", "Header Link is not displayed");

		boolean signInBtn = driver
				.findElement(
						By.xpath("//ul[@class='g-nejm-group__user-tools']//a[@data-interactiontype='sign_in_click']"))
				.isDisplayed();
		softAssert.assertTrue(signInBtn, "Sign In Button is not displayed");

		boolean createAccountBtn = driver
				.findElement(By.xpath(
						"//ul[@class='g-nejm-group__user-tools']//a[@data-interactiontype='create_account_click']"))
				.isDisplayed();
		softAssert.assertTrue(createAccountBtn, "Create Account Button is not displayed");

		boolean subscribeBtn = driver
				.findElement(
						By.xpath("//ul[@class='g-nejm-group__user-tools']//a[@data-interactiontype='subscribe_click']"))
				.isDisplayed();
		softAssert.assertTrue(subscribeBtn, "Subscribe Button is not displayed");

		boolean headerLogo = driver.findElement(By.xpath("//a[@aria-label='NEJM Logo']")).isDisplayed();
		softAssert.assertTrue(headerLogo, "Header Logo is not displayed");

		softAssert.assertAll();

	}

	@Then("I store All the search results for the searched word {string} and search relevancy should be greater than {double}")
	public void i_store_all_the_search_results_for_the_searched_word_and_search_relevancy_should_be_greater_than(
			String searchWord, Double actualRelevancy) throws Throwable {

		int searchWordCount = 0, totalResults = 0, count = 0;
		float expectedRelevancy;

		driver.findElement(By.xpath("//a[@title='search']")).click();
		driver.findElement(By.xpath("//input[@id='sli_search_2']")).sendKeys(searchWord);
		driver.findElement(By.xpath("//div[@id='search']//button[@title='search' and @type='submit']")).click();

		List<WebElement> searchResultList = driver.findElements(By.xpath("//span[@class='m-result__main']/strong"));
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

		Assert.assertTrue(expectedRelevancy > actualRelevancy, "Searched Word is not very Relevant");

		driver.close();

	}

}
