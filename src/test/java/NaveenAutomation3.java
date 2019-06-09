import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaveenAutomation3 {

	WebDriver driver = null;

	@Test(priority = 0)
	public void open() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://srb468.capsulecrm.com/");

	}

	@Test(priority = 1)
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"login:usernameDecorate:username\"]")).sendKeys("srb");;
		driver.findElement(By.xpath("//*[@id=\"login:passwordDecorate:password\"]")).sendKeys("mail@1990");;
		driver.findElement(By.xpath("//*[@id=\"login:login\"]")).click();

	}

	public void people() {
		driver.findElement(By.xpath("//*[@aria-label=\"People & Organisations\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ember70\"]")).click();
		
		
		
	}
}
