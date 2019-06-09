package Selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Grid {
	
	WebDriver driver = null;

	@Parameters("browser")
	public void launch(String brName) throws MalformedURLException {
		

		if (brName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setPlatform(Platform.WINDOWS);
			URL url = new URL("localhost:444/wd/hub");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brName.equalsIgnoreCase("firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}
	
}
