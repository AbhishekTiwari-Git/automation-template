package com.selenium.pageobject;

import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_basepage.TestBase;

public class worldomerterPage extends TestBase {

	@FindBy(xpath = "//div[@class='maincounter-number']//span[@rel='current_population']")
	WebElement mainCountr;

	@FindBy(xpath = "//div[contains(@class,'sec-box')]//span[@class='rts-counter']")
	List<WebElement> popNumsList;

	public worldomerterPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToWM() {
		driver.get(prop.getProperty("url"));
	}

	public void print_numbers() {
		long start_time = System.currentTimeMillis();
		long wait_time = 20000;
		long end_time = start_time + wait_time;

		while (System.currentTimeMillis() < end_time) {
			System.out.println("=================================================================");
			System.out.println("Current World Population==>" + mainCountr.getText());
			for (int i = 0; i < popNumsList.size(); i++) {
				switch (i + 1) {
				case 1:
					System.out.println("Birth Today===>" + popNumsList.get(i).getText());
					break;
				case 2:
					System.out.println("Deaths Today===>" + popNumsList.get(i).getText());
					break;
				case 3:
					System.out.println("Gwroth Today===>" + popNumsList.get(i).getText());
					break;
				case 4:
					System.out.println("Births this yr===>" + popNumsList.get(i).getText());
					break;
				case 5:
					System.out.println("Deaths this year===>" + popNumsList.get(i).getText());
					break;
				case 6:
					System.out.println("Growth This Year===>" + popNumsList.get(i).getText());
					break;
				}

			}
		}

	}
}
