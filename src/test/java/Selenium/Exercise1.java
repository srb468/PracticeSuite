package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise1 {
	WebDriver driver = null;

	// @Test(priority=0)
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");

		driver.findElement(By.xpath("//*[@id=\"button1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();

		Set<String> a = driver.getWindowHandles();
		for (String win : a) {
			if (!(win.equalsIgnoreCase(driver.getWindowHandle()))) {
				driver.switchTo().window(win);
				System.out.println(driver.getCurrentUrl());
				driver.quit();
			}
		}
	}

	@Test(priority = 0)
	public void newUI() throws AWTException, InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		//driver.get("http://the-internet.herokuapp.com/");
		driver.get("http://ToolsQA:TestPassword@www.restapi.demoqa.com/authentication/CheckForAuthentication");
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		
		/*
		 * driver.findElement(By.xpath("//*[text()='Checkboxes']")).click(); WebElement
		 * box2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")); if
		 * (box2.isSelected()) { System.out.println("Box is selected"); // box2.click();
		 * } else { box2.click(); } driver.navigate().back();
		 * 
		 * driver.findElement(By.xpath(".//*[text()='Dropdown']")).click(); Select sel =
		 * new Select(driver.findElement(By.xpath("//*[@id=\"dropdown\"]")));
		 * sel.selectByVisibleText("Option 1"); driver.navigate().back();
		 * driver.findElement(By.xpath(".//*[text()='Dropdown']")).click();
		 * List<WebElement> l1 =
		 * driver.findElements(By.xpath("//*[@id=\"dropdown\"]/option")); for
		 * (WebElement a : l1) { if (a.getText().equalsIgnoreCase("Option 2")) {
		 * a.click(); } } driver.navigate().back();
		 
		driver.findElement(By.xpath("//*[text()='Hovers']")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).build().perform();
		String userName = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
		if (userName.equalsIgnoreCase("name: user1")) {
			System.out.println("User exists");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
		}
		*/
		
		//Runtime.getRuntime().exec("C:\\Users\\10059665\\Desktop\\autoIT.exe");
		
	}
}