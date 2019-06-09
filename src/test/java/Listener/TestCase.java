package Listener;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listener.TestNGListeners.class)
public class TestCase {
	WebDriver driver = null;

	@Test(priority = 0)
	public void launch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("http://the-internet.herokuapp.com/");
		Thread.sleep(7000);
		// driver.get("https://www.engprod-charter.net/");
		Assert.assertEquals("a", "a");
	}

	@Test(priority = 1)
	public void tc2() {

		Assert.assertEquals("a", "b");

	}

	@Test(priority = 2)
	public void tc3() {

		Assert.assertEquals("a", "b");

	}

	public void takeScreenshot() throws IOException {
		File sourFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(sourFile, new File("C:\\Workspace\\com.practiceSuite\\src\\main\\java\\test\\fail.jpg"));
	}
}
