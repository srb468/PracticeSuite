import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.sun.mail.iap.Argument;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaveenAssignment2 {

	WebDriver driver = null;
	Robot robot = null;
	UtilsClass utils = new UtilsClass();

	@Test(priority = 0)
	public void open() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().deleteAllCookies();

		Thread.sleep(15000);

		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		List<WebElement> allImages = driver.findElements(By.xpath("//*[@id=\"second-img\"]"));

		if (allImages.size() > 0) {
			driver.findElement(By.xpath("//*[@class='close']/i[@class='wewidgeticon we_close']")).click();
			// driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
			System.out.println("Pop-up closed");
		} else {
			System.out.println("Images not detected");
		}
	}

	@Test(priority = 1)
	public void searchFlight() throws AWTException, InterruptedException, ParseException {

		robot = new Robot();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Flights' and @class='chNavText darkGreyText']")).click();

		driver.findElement(By.xpath("//*[text()='Round Trip']")).click();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/ul/li[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"fromCity\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"fromCity\"]")).sendKeys("DELHI");
		Thread.sleep(1000);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id=\"toCity\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"toCity\"]")).sendKeys("BANGLORE");

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/label/span")).click();
		String currentDate = driver.findElement(By.xpath("//*[@class=\"DayPicker-Day DayPicker-Day--today\"]"))
				.getText();
		driver.findElement(By.xpath("//*[@class=\"DayPicker-Day DayPicker-Day--today\"]")).click();

		String fromDate = utils.addDate(7);
		System.out.println("From Date: " + fromDate);
		String fromDateXpath = "//*[@aria-label='" + fromDate + "']/div[@class='dateInnerCell']";
		System.out.println(fromDateXpath);
		driver.findElement(By.xpath(fromDateXpath)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Search']")).click();
	}

	@Test(priority = 2)
	public void validation() throws InterruptedException {

		Thread.sleep(5000);
		scrollToInfinity();
		List<WebElement> depCount = driver
				.findElements(By.xpath("//*[@class='splitVw-sctn pull-left']/div[2]/div/label"));
		List<WebElement> returnCount = driver
				.findElements(By.xpath("//*[@class='splitVw-sctn pull-right']/div[2]/div/label"));

		System.out.println("Departure flight count : " + depCount.size());
		System.out.println("Return flight count : " + returnCount.size());

		scrollToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/span/a/img")));
		driver.findElement(By.xpath("//*[@id=\"fli_filter__stops\"]/span[1]/label/span[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"fli_filter__stops\"]/span[2]/label/span[1]/span")).click();

		Thread.sleep(5000);
		scrollToInfinity();
		List<WebElement> depCount1 = driver
				.findElements(By.xpath("//*[@class='splitVw-sctn pull-left']/div[2]/div/label"));
		List<WebElement> returnCount1 = driver
				.findElements(By.xpath("//*[@class='splitVw-sctn pull-right']/div[2]/div/label"));

		System.out.println("Departure flight count : " + depCount1.size());
		System.out.println("Return flight count : " + returnCount1.size());
		
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/span/a/img")));
	}

	
	public void scrollToInfinity() throws InterruptedException {

		Thread.sleep(4000);
		for (int second = 0;; second++) {
			if (second >= 15) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)", "");
			Thread.sleep(2000);
		}
	}

	public void scrollToElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
}
