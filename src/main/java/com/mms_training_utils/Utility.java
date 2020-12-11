package com.mms_training_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mms_training_basepage.TestBase;

public class Utility extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public void executeJavascript(String script, WebElement element) {
		((JavascriptExecutor) driver).executeScript(script, element);
	}
	
	public void scroll(String script, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
