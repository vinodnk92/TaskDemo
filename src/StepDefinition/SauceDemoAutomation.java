package StepDefinition;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import CommonMethods.CommonMethod;
import Listeners.ExtentReportListener;
import PageObjects.sauceHomePage;
import PageObjects.sauceLogin;
import Utility.BrowserUtility;
import Utility.ExcelHandler;
import Utility.PropertiesFileReader;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SauceDemoAutomation extends ExtentReportListener {
	public static WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();
	sauceLogin saucelogin;
	sauceHomePage saucehomepage;
	CommonMethod cm = new CommonMethod(driver);

	@Given("hit the www.saucedemo.com url")
	public void hit_the_compact_identity_url() throws Exception {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			test = extent.createTest(Feature.class, "www.saucedemo.com Automation");
			test = test.createNode(Scenario.class, "hit the www.saucedemo.com url");
			logInfo = test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser"),
					properties.getProperty("URL"),properties.getProperty("HeadLess"));

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@When("enter username")
	public void enter_username() throws Exception {
		ExtentTest logInfo = null;
		saucelogin = new sauceLogin(driver);
		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String username = TestDataInMap.get("UserName");
			logInfo = test.createNode(new GherkinKeyword("When"), "enter username");
			saucelogin.enterUsername(username);
			cm.wait(1);
			
			

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@When("enter password")
	public void enter_password() throws Exception {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String password = TestDataInMap.get("Password");
			
			logInfo = test.createNode(new GherkinKeyword("When"), "enter password");

			new sauceLogin(driver).enteruPassword(password);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Click on login button")
	public void click_on_login_button() throws Exception {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "Click on login button");

			new sauceLogin(driver).clickOnLogin();
			cm.wait(1);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	
	@Then("Verify home page")
	public void verify_home_page() {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "Verify home page");

			new sauceHomePage(driver).verifyHomePage();
			cm.wait(1);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Sort the items \\(Lowest Price sort)")
	public void sort_the_items_Lowest_Price_sort() {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String dropdownval = TestDataInMap.get("dropdownval");
			
			logInfo = test.createNode(new GherkinKeyword("When"), "Sort the items \\\\(Lowest Price sort)");
			cm.wait(2);
			new sauceHomePage(driver).SelectDropdownValue(dropdownval);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Add two or more items to the shopping cart")
	public void add_two_or_more_items_to_the_shopping_cart() {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String firstItem = TestDataInMap.get("ItenName1");
			String secondItem = TestDataInMap.get("ItenName2");
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Add first items to the shopping cart");
			new sauceHomePage(driver).addFirstItemToCart(firstItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Add items items to the shopping cart");
			new sauceHomePage(driver).addFirstItemToCart(secondItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Visit the shopping cart")
	public void visit_the_shopping_cart() {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "Visit the shopping cart");

			new sauceHomePage(driver).clickOnCartButton();
			cm.wait(2);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Assert that the items that you added are in the cart")
	public void assert_that_the_items_that_you_added_are_in_the_cart() {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String firstItem = TestDataInMap.get("ItenName1");
			String secondItem = TestDataInMap.get("ItenName2");
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "verify first item");
			new sauceHomePage(driver).verifyFirstItemName(firstItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "verify second item");
			new sauceHomePage(driver).verifySecondItemName(secondItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Remove an item and then continue shopping")
	public void remove_an_item_and_then_continue_shopping() {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			
			String secondItem = TestDataInMap.get("ItenName2");
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Remove 1 item from cart");
			new sauceHomePage(driver).removeItem(secondItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Click on continue button");
			new sauceHomePage(driver).clickOnContinueShoping();
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Add another item")
	public void add_another_item() {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			
			String secondItem = TestDataInMap.get("ItenName2");
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Add another item");
			new sauceHomePage(driver).addSecondItemToCart(secondItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Assert you are purchasing the correct items")
	public void assert_you_are_purchasing_the_correct_items() {
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String firstItem = TestDataInMap.get("ItenName1");
			String secondItem = TestDataInMap.get("ItenName2");
			
			
			logInfo = test.createNode(new GherkinKeyword("When"), "Visit the shopping cart");
			cm.wait(2);
			new sauceHomePage(driver).clickOnCartButton();
			
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "verify first item");
			new sauceHomePage(driver).verifyPurchasingItem(firstItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "verify second item");
			new sauceHomePage(driver).verifyPurchasingItem(secondItem);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}


	@Then("Assert the total price")
	public void assert_the_total_price() {
		saucehomepage = new sauceHomePage(driver);
		ExtentTest logInfo = null;
		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String firstItem = TestDataInMap.get("ItenName1");
			String secondItem = TestDataInMap.get("ItenName2");
			String firstName = TestDataInMap.get("firstname");
			String lastName = TestDataInMap.get("lastname");
			String pinCode = TestDataInMap.get("pincode");
			
			cm.wait(2);
			
			float itemPrice1=saucehomepage.getItemPrice(firstItem);
			float itemPrice2=saucehomepage.getItemPrice(secondItem);
			float TotalPrice=itemPrice1+itemPrice2;
			
			cm.wait(2);
			
			logInfo = test.createNode(new GherkinKeyword("When"), "Click On Checkout");
			saucehomepage.clickOncheckout();
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Enter First Name,Last Name,Postal code");
			saucehomepage.EnterDetails(firstName,lastName,pinCode);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Click on continue button");
			saucehomepage.clickOnContinueButton();
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
			float totalpricecount=saucehomepage.getItemTotalPrice();
			cm.wait(2);
			logInfo = test.createNode(new GherkinKeyword("When"), "Assert the total price");
			saucehomepage.verifyCartPrice(totalpricecount,TotalPrice);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@Then("Finish checkout")
	public void finish_checkout() {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "Finish checkout");
			cm.wait(2);
			
			new sauceHomePage(driver).clickOnFinish();
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	@After()
	public void closeBrowser() {
		driver.quit();
	}
}
