package com.selenium_utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_basepage.TestBase;

public class Utility extends TestBase {
	long timeout = Long.parseLong(prop.getProperty("waitTimeout"));
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	
	public void waitForElementToBeVisible(WebElement element) {
         wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public void executeJavascript(String script, WebElement element) {
		((JavascriptExecutor) driver).executeScript(script, element);
	}
	
	public void scroll(String script, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
