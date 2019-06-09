package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise3 {

	WebDriver driver = null;

	@Test(enabled=false)
	public void performAction() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		Actions act = new Actions(driver);
		Robot robot = new Robot();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"custom_html-3\"]/div[2]/b[1]/a")));
		List<WebElement> allItems = driver.findElements(By.xpath("//*[@id=\"custom_html-2\"]/div[2]/b/a"));
		for (int i = allItems.size()-1; i > 0; i--) {
			if (i == allItems.size()-1) {
				WebElement last = allItems.get(i);
				System.out.println(last.getText());
				//act.click();
				act.contextClick(last).build().perform();
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_DOWN);

				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				break;		
			}
		}

	}
	
	public void explicitWait() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.accept();
		
		
	}
}
