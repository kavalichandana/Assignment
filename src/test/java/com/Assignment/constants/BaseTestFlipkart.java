package com.Assignment.constants;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestFlipkart implements AutomationConstants {

	public static WebDriver driver;
	public static Logger log;
	private String chromeOptionsMap;
	private String options;
	public static String url1;
	public static long timeout;
	public int amazonprice;
	public int Flipkartprice;

	public BaseTestFlipkart() {

		log = log.getLogger("LOg_ Logger");
		PropertyConfigurator.configure("Log4j.properties");
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}

	public void initFrameWork() {
		log.info("initilizing framework");
		url1 = com.Assignment.Generic.Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "URL1");
		timeout = Long
				.parseLong(com.Assignment.Generic.Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "IMPLICIT"));
	}

	@BeforeClass
	public void initApplication2() {
		initFrameWork();
		System.setProperty(GECKO_KEY, DRIVER_PATH + CHROME_FILE);
		DesiredCapabilities desiredcapablities = DesiredCapabilities.chrome();
		desiredcapablities.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		desiredcapablities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredcapablities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(desiredcapablities);

		driver.manage().window().maximize();
		driver.get(url1);
		log.info("TimeOut:" + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeaplication2() {
		driver.quit();
	}

	public void preCondition2() {

		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains(
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))

		{
			log.info("user successfully logged in");
		}

		else {
			log.info("user logged in wrong page");

		}
	}

}