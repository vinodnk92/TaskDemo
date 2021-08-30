package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import CommonMethods.CommonMethod;
import Utility.Log;

public class sauceHomePage {
	WebDriver driver;
	CommonMethod cm;

	public sauceHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);

	}

	
	public By sortdropdown = By.xpath("//select[@class='product_sort_container']");
	public By homePage = By.xpath("//select[@class='product_sort_container']");
	//public By firstitenCart = By.xpath("(//*[text()='Sauce Labs Onesie'])//following::button[1]");
	public By cartButton = By.id("shopping_cart_container");
	public By item1 = By.xpath("(//button[text()='Remove'])[1]/parent::div/parent::div/descendant::div[@class='inventory_item_name']");
	public By item2 = By.xpath("(//button[text()='Remove'])[2]/parent::div/parent::div/descendant::div[@class='inventory_item_name']");
	public By continueShoping = By.id("continue-shopping");
	public By finishButton = By.id("finish");
	public By checkout = By.id("checkout");
	public By firstname = By.id("first-name");
	public By lastname = By.id("last-name");
	public By postalcode = By.id("postal-code");
	public By continuebtn = By.id("continue");
	public By totalprice = By.xpath("//*[@id=\"checkout_summary_container\"]//following::div[@class='summary_subtotal_label']");
	
	
	public void verifyCartPrice(float totalpricecount,float totalPrice2) throws Exception {
	
		if(totalpricecount==totalPrice2)
		{
			Log.info("purchasing item is verified");
		}
		else
		{
			Log.error("purchasing item is not equal");
		}
	
		
	}
	
	
	public void clickOnContinueButton() throws Exception {
		cm.findElement(continuebtn).click();
	}
	public void EnterDetails(String firs_tname,String Last_name,String pin_code) throws Exception {
		cm.findElement(firstname).sendKeys(firs_tname);
		cm.findElement(lastname).sendKeys(Last_name);
		cm.findElement(postalcode).sendKeys(pin_code);
	}
	
	public void clickOncheckout() throws Exception {
		cm.findElement(checkout).click();
	}
	public void clickOnFinish() throws Exception {
		cm.findElement(finishButton).click();
	}
	public float getItemPrice(String ItemnName) throws Exception {
		
	 By ItemPrice=By.xpath("//*[contains(text(),'"+ItemnName+"')][1]/../following-sibling::div[@class='item_pricebar']/div[@class='inventory_item_price']");
		
		String price=cm.findElement(ItemPrice).getText();
		String itemPricestr = price.substring(1, price.length());
		float itemPriceint=Float.parseFloat(itemPricestr);
		return itemPriceint;
	}
	public float getItemTotalPrice() throws Exception {
		
			String price=cm.findElement(totalprice).getText();
			String itemPricestr = price.substring(13, price.length());
			float itemPriceint=Float.parseFloat(itemPricestr);
			return itemPriceint;
		
		}
	
	public void verifyPurchasingItem(String Item) throws Exception {
		By purchasingCart=By.xpath("(//div[contains(text(),'"+Item+"')])");
		boolean trueval=cm.findElement(purchasingCart).isDisplayed();
		if(trueval==true)
		{
			Log.info("purchasing item is verified");
		}
		else
		{
			Log.error("purchasing item is not equal");
		}
	
	}
	public void clickOnContinueShoping() throws Exception {
			cm.findElement(continueShoping).click();
		}
	public void removeItem(String ItenName) throws Exception {
		By secondItemCart = By.xpath("(//*[text()='"+ItenName+"'])//following::button[1]");
			cm.findElement(secondItemCart).click();
		}
	
	public void clickOnCartButton() throws Exception {
		
			cm.findElement(cartButton).click();
		}
	
	public void addSecondItemToCart(String ItenName2) throws Exception {
		By secondItemCart = By.xpath("(//*[text()='"+ItenName2+"'])//following::button[1]");
			cm.findElement(secondItemCart).click();
		}
public void addFirstItemToCart(String ItenName1) throws Exception {
	By firstitenCart = By.xpath("(//*[text()='"+ItenName1+"'])//following::button[1]");
		cm.findElement(firstitenCart).click();
	}
	public void SelectDropdownValue(String dropdownvalue) throws Exception {
		
		Select value = new Select(cm.findElement(sortdropdown));
		value.selectByVisibleText(dropdownvalue);
	}

	public void verifyHomePage() throws Exception {
		if(cm.findElement(homePage).isDisplayed())
		{
			Log.info("Home Page is Displayed");
		}
		else
		{
			Log.error("Home Page is not Displayed");
		}
	}
	
	public void verifyFirstItemName(String FirstItem) throws Exception {
		cm.findElement(item1).getText();
		String firstItemName = cm.findElement(item1).getText();
		if(firstItemName.equals(FirstItem))
		{
			Log.info("First item is verified");
		}
		else
		{
			Log.error("First item is not equal");
		}
		

	}
	public void verifySecondItemName(String secondItem) throws Exception {
		cm.findElement(item2).getText();
		String secondItemName = cm.findElement(item2).getText();
		if(secondItemName.equals(secondItem))
		{
			Log.info("Second item is verified");
		}
		else
		{
			Log.error("Second item is not equal");
		}
		
		

	}
}
