package CommonMethods;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.Log;

public class CommonMethod {

	WebDriver driver;

	public CommonMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 public WebElement findElement(By locator) {
	        try {
	            WebElement element = driver.findElement(locator);
	            return element;
	        } catch (NoSuchElementException e) {
	        	Log.error(e.getLocalizedMessage());
	        	throw e;
	        }
	    }
	 public Boolean isElementPresent(By targetElement) throws InterruptedException {
	        Boolean isPresent = driver.findElements(targetElement).size() > 0;
	        return isPresent;
	    }
	public void wait(int seconds) {
		try {
			for (int i = 1; i <= seconds; i++) {
				Thread.sleep((seconds - seconds) + 1 * 1000);

			}
			Log.info("Waiting for " + seconds + " Seconds");
		} catch (InterruptedException e) {
			Log.error(e.getLocalizedMessage());
		}
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
		Log.info(element + " is clicked");

	}

	public void click(WebElement element) {
		try {
			element.click();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void clickByXPTH(String elementXpath) {
		try {
			WebElement element = driver.findElement(By.xpath(elementXpath));
			element.click();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void clickByAction(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void clickActionByXpath(String elementXpath) {
		try {
			WebElement element = driver.findElement(By.xpath(elementXpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void type(WebElement element, String data) {
		try {
			element.sendKeys(data);
			Log.info("on " + element + " " + data + " is entered");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void selectFromDropdownByValue(WebElement element, String value) {
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			Log.info(value + " is selected");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public void selectFromDropdownByindex(WebElement element, int index) {

		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			Log.info(index + " is selected");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public void selectFromDropdownVisibleText(WebElement element, String VisibleText) {

		try {
			Select s = new Select(element);
			s.selectByVisibleText(VisibleText);
			Log.info(VisibleText + " is selected");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public void clickOnTab(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
			Log.info(element + " tab is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public String getText(WebElement element) {

		String value = element.getText();
		return value;

	}

	public int createRandomNumber() {
		int randomnumb = 0;
		try {
			Random rand = new Random();
			randomnumb = rand.nextInt(10000);
			Log.info(randomnumb + " Random number is created");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
		}
		return randomnumb;

	}

	public void mouseHover(WebElement target) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(target).build().perform();
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
