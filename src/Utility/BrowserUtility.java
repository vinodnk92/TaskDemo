package Utility;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class BrowserUtility
{
	public final static String PROJECT_DIRECTORY = System.getProperty("user.dir");
	
	public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url,String Headless) throws Exception
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", PROJECT_DIRECTORY+"\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(Headless.equalsIgnoreCase("YES"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			Log.info("Open browser");
			driver.manage().window().maximize();
			Log.info("Maximize browser");
			driver.get(url);
			Log.info("Navigate to URL"+url);
			Thread.sleep(5000);
			return driver;	
		}else 
		if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", PROJECT_DIRECTORY+"\\drivers\\IEDriverServer.exe");
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);//to move mouse manually			
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;	
		} else
			if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", PROJECT_DIRECTORY+"\\drivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if(Headless.equalsIgnoreCase("YES"))
			{
				options.setHeadless(true);
			}
			driver=new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			return driver;	
		}
			return null;			
	}

}
