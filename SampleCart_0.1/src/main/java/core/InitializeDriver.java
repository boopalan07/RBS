package core;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.DataManager;

public class InitializeDriver {

	public static WebDriver driver = null;

	public static void initializeDriver() throws Exception {

		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-web-security");
			options.addArguments("--ignore-certificate-errors");
			options.setExperimentalOption("useAutomationExtension", false);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			String path = System.getProperty("user.dir");
			String chromePath = path + "\\src\\main\\resources\\driver\\chromedriver.exe";
			System.setProperty("webdriver,chrome.driver", chromePath);
			driver = new ChromeDriver(capabilities);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}

	}

	public static void launchURL() throws Exception {
		try {
			driver.get(DataManager.getConfigData("appURL"));
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new Exception("Home Page can not be launched" + "\n" + e.getMessage());
		}
	}
}
