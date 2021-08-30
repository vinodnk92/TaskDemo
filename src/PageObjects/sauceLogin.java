package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;
import Utility.Log;

public class sauceLogin {
	WebDriver driver;
	CommonMethod cm;

	public sauceLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);

	}

	
	public By usernameField = By.id("user-name");
	public By passwordField = By.id("password");
	public By loginButton = By.id("login-button");
	
	
	
	public void enterUsername(String usrname) throws Exception {
		cm.findElement(usernameField).sendKeys(usrname);
		Log.info("Enter UserName"+usrname);
	}

	public void enteruPassword(String password) throws Exception {
		cm.findElement(passwordField).sendKeys(password);
	}
	public void clickOnLogin() throws Exception {
		cm.findElement(loginButton).click();
		

	}

}
