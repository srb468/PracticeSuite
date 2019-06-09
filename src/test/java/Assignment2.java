import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	WebDriver driver = null;
	Robot robot = null;

	@Test(priority = 0)
	public void open() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		
		
	}

	@Test(priority = 1)
	public void searchflight() throws AWTException, InterruptedException {

		
		
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/nav/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/ul/li[2]/span")).click();
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

	}
}
