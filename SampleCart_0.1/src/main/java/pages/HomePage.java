package pages;

import org.openqa.selenium.By;

import utilities.CommonFunctions;

public class HomePage {

	static By imgHomePage = By.id("header_logo");

	public static void isPageDisplayed() throws Exception {

		try {
			CommonFunctions.waitForPageLoad(imgHomePage);
		} catch (Exception e) {
			throw new Exception("Page can not be loaded " + e.getMessage());
		}
	}
	
	public static void performClick(String action) throws Exception{
		try{
			
		switch (action.toLowerCase().replaceAll(" ", "")) {
		case value:
			
			break;

		default:
			break;
		}	
		}catch (Exception e) {
throw new Exception(e.getMessage());
		}
	}

}
