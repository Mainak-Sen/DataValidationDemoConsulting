package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutomationPractisePage {

	private static RemoteWebDriver driver;

	// private locators
	private By checkBoxOption1 = By.xpath("//div[@id='checkbox-example']//label[1]");
	private By header = By.xpath("//h1");
	private By promotion = By.xpath("//a[@href='https://rahulshettyacademy.com/#/documents-request']");
	private By radioOption1 = By.xpath("//div[@id='radio-btn-example']//label[1]");
	private By openWindowButton = By.id("openwindow");

	public AutomationPractisePage(RemoteWebDriver driver2) {
		AutomationPractisePage.driver = driver2;
	}

	/* gets the text of CheckBoxOption1 */
	public String getCheckBoxOption1Text() {
		return driver.findElement(checkBoxOption1).getText();
	}

	/* gets the text of Header */
	public String getHeaderText() {
		return driver.findElement(header).getText();
	}

	/* gets Promotion text from web-page */
	public String getPromotionText() {
		return driver.findElement(promotion).getText();
	}

	/* gets the text of RadioOption1 */
	public String getRadioOption1Text() {
		return driver.findElement(radioOption1).getText();
	}

	/* gets the text of OpenWindowButton */
	public String getOpenWindowButtonText() {
		return driver.findElement(openWindowButton).getText();
	}

}
