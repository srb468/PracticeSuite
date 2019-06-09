package Selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {

	WebDriver driver = null;

	@Parameters("browser")
	
	@Test
	public void launch(String brName) throws MalformedURLException {

		if (brName.equalsIgnoreCase("chrome")) {
			/*DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setPlatform(Platform.WINDOWS);
			URL url = new URL("localhost:444/wd/hub");
			*/WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div/div/h2/span")).click();
	}
	
	/*@Test
	public void exec() {
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div/div/h2/span")).click();
	}
	*/
}
