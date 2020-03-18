package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.InitializeDriver;

public class CommonFunctions {
	static WebElement element;
	static WebDriver driver = InitializeDriver.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 5000);
	
	
	public static void waitForPageLoad(By locator) throws Exception {
		try {
			element = driver.findElement(locator);
			
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw new Exception("Element is not identified " + e.getMessage());
		}

	}
	
	public static void clickOnElement(By locator) throws Exception {
		try {
			element = driver.findElement(locator);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			throw new Exception("Element is not clickable " + e.getMessage());
		}
	}
	
	public static void enterTextInTextField(By locator, String text) throws Exception {
		try {
			element = driver.findElement(locator);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
		} catch (Exception e) {
			throw new Exception("Value can not be entered into the text box " + e.getMessage());
		}
	}
	
	public static void selectByValue(By locator, String text) throws Exception {
		try {
			element = driver.findElement(locator);
			wait.until(ExpectedConditions.visibilityOf(element));
			Select dropDown=new Select(element);
			dropDown.selectByValue(text);
		} catch (Exception e) {
			throw new Exception("Value can not be entered into the text box " + e.getMessage());
		}
	}
}
