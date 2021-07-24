package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutomationPractisePage {

	private static RemoteWebDriver driver;

	private By checkBoxOption1 = By.xpath("//div[@id='checkbox-example']//label[1]");
	private By header = By.xpath("//h1");
	private By promotion = By.xpath("//a[@href='https://rahulshettyacademy.com/#/documents-request']");
	private By radioOption1 = By.xpath("//div[@id='radio-btn-example']//label[1]");
	private By openWindowButton = By.id("openwindow");

	public AutomationPractisePage(RemoteWebDriver driver2) {
		AutomationPractisePage.driver = driver2;
	}

	public String getCheckBoxOption1Text() {
		return driver.findElement(checkBoxOption1).getText();
	}

	public String getHeaderText() {
		return driver.findElement(header).getText();
	}

	public String getPromotionText() {
		return driver.findElement(promotion).getText();
	}

	public String getRadioOption1Text() {
		return driver.findElement(radioOption1).getText();
	}

	public String getOpenWindowButtonText() {
		return driver.findElement(openWindowButton).getText();
	}

}
