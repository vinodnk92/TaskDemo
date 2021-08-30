package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CommonMethods.CommonMethod;

public class Test {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		CommonMethod cm = new CommonMethod(driver);
		System.setProperty("webdriver.chrome.driver","D:\\eclipsWorkspace\\SeleniumCucumberBDDFramework\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		cm.wait(2);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		 WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
		if(cartIcon.isDisplayed()){
			System.out.println("User lands on the home page");
		}else{
			System.out.println("User unable to land on the home page");
		}
		//select the value low to high value from drop-down
		WebElement selectValue = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select value = new Select(selectValue);
		value.selectByVisibleText("Price (low to high)");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		if(driver.findElement(By.xpath("//span[contains(text(),'Price (low to high)')]")).isDisplayed()){
			System.out.println("Iteams are sorted into low to high");
		}else{
			System.out.println("unable to sort the items");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		//Retrieve the first item name and click on Add to cart button 
		WebElement firstItemValue = driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]/parent::div/parent::div/descendant::div[@class='inventory_item_name']"));
		String firstItemName = firstItemValue.getText();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		//Retrieve the first item name and click on Add to cart button
		WebElement secondItemValue = driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]/parent::div/parent::div/descendant::div[@class='inventory_item_name']"));
		String secondItemName = secondItemValue.getText();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		cartIcon.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		//verify user navigated to cart page
		if(driver.findElement(By.xpath("//span[text()='Your Cart']")).isDisplayed()){
			System.out.println("Use is able to naviate to cart page");
		}else{
			System.out.println("Unable to naviate to cart page");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		//verify selected items names are present in cart
		WebElement firstCartValue = driver.findElement(By.xpath("(//button[text()='Remove'])[1]/parent::div/parent::div/descendant::div[@class='inventory_item_name']"));
		String firstCartIteam = firstCartValue.getText();
		if(firstItemName.contains(firstCartIteam)){
			System.out.println("Selected first item is added in to the cart");
		}else{
			System.out.println("Unable to add selected item into cart page");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		WebElement secondCartValue = driver.findElement(By.xpath("(//button[text()='Remove'])[2]/parent::div/parent::div/descendant::div[@class='inventory_item_name']"));
		String secondCartIteam = secondCartValue.getText();
		if(secondCartIteam.contains(secondItemName)){
			System.out.println("Selected Second item is added in to the cart");
		}else{
			System.out.println("Unable to add selected item into cart page");
		}	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		if(driver.findElement(By.xpath("(//button[text()='Remove'])[2]")).isDisplayed()){
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			cm.wait(2);
			driver.findElement(By.xpath("(//button[text()='Remove'])[2]")).click();
			System.out.println("Remove the item from cart");
		}else{
			System.out.println("Unable to remov the item from cart");
		}
		//click on the continue-shopping button
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		if(driver.findElement(By.id("continue-shopping")).isDisplayed()){
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			cm.wait(2);
			driver.findElement(By.id("continue-shopping")).click();
			System.out.println("user clicked on continue-shopping");
		}else{
			System.out.println("Unable to click in continue-shopping buttont");
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		cm.wait(2);
		WebElement thirdItemValue = driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]/parent::div/parent::div/descendant::div[@class='inventory_item_name']"));
		String thirdItemName = thirdItemValue.getText();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    cm.wait(2);
	    WebElement thirdCartValue = driver.findElement(By.xpath("(//button[text()='Remove'])[2]/parent::div/parent::div/descendant::div[@class='inventory_item_name']"));
		String thirdCartIteam = thirdCartValue.getText();
		if(thirdCartIteam.contains(thirdItemName)){
			System.out.println("Selected Second item is added in to the cart");
		}else{
			System.out.println("Unable to add selected item into cart page");
		}	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("checkout")).click();
		if(driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).isDisplayed()){
			System.out.println("User navigate to checkout page");
		}else{
			System.out.println("Unable to naviate to checkout page");
		}
		driver.findElement(By.id("first-name")).sendKeys("jack");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("last-name")).sendKeys("sk");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("postal-code")).sendKeys("560037");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		driver.findElement(By.id("continue")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		cm.wait(2);
		if(driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).isDisplayed()){
			System.out.println("User navigate to overview page");
		}else{
			System.out.println("Unable to naviate to overview page");
		}
		WebElement firstCheckoutValue = driver.findElement(By.xpath("(//div[contains(text(),'$')])[1]/preceding::div[@class='inventory_item_name']"));
		String firstCheckoutName = firstCheckoutValue.getText();
		if(firstCheckoutName.contains(firstItemName)){
			System.out.println("Selecte first item is dsplayed in the checkout page");
		}else{
			System.out.println("Selected first item is not displayed in the checkout page");
		}
		
		
		WebElement thirdCheckoutValue1 = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Onesie')][1]/../following-sibling::div[@class='item_pricebar']/div[@class='inventory_item_price']"));
		String thiedCheckoutName1 = thirdCheckoutValue1.getText();
		
	//	str = str.substring(1, str.length() - 1);
		WebElement thirdCheckoutValue = driver.findElement(By.xpath("(//div[contains(text(),'$')])[2]/preceding::div[@class='inventory_item_name']"));
		String thiedCheckoutName = thirdCheckoutValue.getText();
		if(thiedCheckoutName.contains(thirdItemName)){
			System.out.println("Selecte third item is dsplayed in the checkout page");
		}else{
			System.out.println("Selected third item is not displayed in the checkout page");
		}
		if(driver.findElement(By.id("finish")).isDisplayed()){
			driver.findElement(By.id("finish")).click();
			System.out.println("Click on the finisg button in checkout overview page");
		}else{
			System.out.println("Unable to click on fnish button in the checkout overview page");
		}
		if(driver.findElement(By.xpath("//span[contains(text(),'Checkout: Complete!')]")).isDisplayed()){
			System.out.println("Checkout completed");
		}else{
			System.out.println("Unable to complete the checkout");
		}
		driver.close();		
		 
	}

}
