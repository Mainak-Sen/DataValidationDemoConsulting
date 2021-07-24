package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	protected static RemoteWebDriver driver;
	public Properties prop;

	public RemoteWebDriver initializeDriver() throws IOException

	{

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		// String browsername = System.getProperty("browser");
		String browsername = prop.getProperty("browser");
		// System.out.println(browsername);

		if (browsername.contains("chrome")) {
			// intialize chrome
			// pick chrome driver from project directory as mentioned below
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			// firefox can be initialized
		} else {
			// Internet Explorer can be initialized
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// implicit wait
		return driver;

	}

}
