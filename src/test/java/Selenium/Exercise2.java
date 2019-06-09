package Selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise2 {

	WebDriver driver = null;
	@Test(priority=0)
	public void ex1() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		//driver.get("http://the-internet.herokuapp.com/");
		driver.get("https://www.engprod-charter.net/");
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		Runtime.getRuntime().exec("C:\\Users\\10059665\\Desktop\\AutoIT.exe");
		
	}
}
