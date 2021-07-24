package RSADataValidationProject.DataValidationDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AutomationPractisePage;
import resources.Base;
import resources.Utilities;

/*Test class to write the logic and execute test script for AutomationPractisePage*/
public class DataValidationTest extends Base {

	private static Logger log = LogManager.getLogger(DataValidationTest.class.getName());
	private static AutomationPractisePage automationPractisePage;
	private static Map<String, String> fieldValueMap;

	@BeforeTest
	public void Setup() throws IOException {
		// initialize the driver and launch the desired url
		driver = initializeDriver();
		log.info("Driver is initialised ");
		driver.get(prop.getProperty("url"));
		log.info("Successfully launched url");

		// delete dataFile of last run if it exists
		try {
			Files.deleteIfExists(Paths.get("./Data/dataFile.txt"));
		} catch (NoSuchFileException e) {
			System.out.println("No such file exists");
		}
		log.info("Successfully deleted report file of previous run");

		// copy latest file from shared directory and get the map of field-value
		fieldValueMap = Utilities.getFieldValueMappingFromLatestFile(prop.getProperty("sharedDirectory"));
		log.info("Successfully extracted field-value mapping from latest modified file");
	}

	@Test(priority = 0)
	public void isAutomationPracticePageLoaded() {

		automationPractisePage = new AutomationPractisePage(driver);
		Assert.assertEquals(driver.getTitle(), "Practice Page");
	}

	@Test
	public void validateCheckBoxOption1Text() {

		Assert.assertEquals(fieldValueMap.get("checkBoxOption1"),
				automationPractisePage.getCheckBoxOption1Text().trim());
	}

	@Test
	public void validateHeaderText() {

		Assert.assertEquals(fieldValueMap.get("header"), automationPractisePage.getHeaderText().trim());
	}

	@Test
	public void validateRadioOption1Text() {

		Assert.assertEquals(fieldValueMap.get("radioOption1"), automationPractisePage.getRadioOption1Text().trim());
	}

	@Test
	public void validatePromotionText() {

		Assert.assertEquals(fieldValueMap.get("promotion"), automationPractisePage.getPromotionText().trim());
	}

	@Test
	public void validateOpenWindowButtonText() {

		Assert.assertEquals(fieldValueMap.get("openWindowButton"),
				automationPractisePage.getOpenWindowButtonText().trim());
	}

	@AfterTest
	public void teardown() {
		// tear-down method for cleanup process
		driver.quit();
		log.info("Successfully quit driver");
		driver = null;
	}

}
