package com.pg.test.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.TimesPanel;

import com.pg.test.genric.AutoConts;
import com.pg.test.util.TestUtil;
import com.pg.test.util.WebEventListener;

public class BasePage implements AutoConts {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public BasePage() {
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/pg/test/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Browser Initialization method Access the method creating the class instance
	// and pass browser name as parameters

	public static void initilization() throws InterruptedException, AWTException {

		// String BrowserName = prop.getProperty("browser");
		String BrowserName = "chrome";
		if (BrowserName.equals("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		} else if (BrowserName.equals("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("safari")) {
			System.setProperty(SAFARI_KEY, SAFARI_VALUE);
			driver = new SafariDriver();
		} else if (BrowserName.equals("iexplorer")) {
			System.setProperty(IE_KEY, IE_VALUE);
			driver = new InternetExplorerDriver();

		} else if (BrowserName.equals("edge")) {
			System.setProperty(EDGE_KEY, EDGE_VALUE);
			driver = new InternetExplorerDriver();
		}


		
		// Event Listener
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		WebDriverWait wait = new WebDriverWait(driver, 20);



	}
}
