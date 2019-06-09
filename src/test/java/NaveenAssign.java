import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaveenAssign {

	WebDriver driver = null;

	@Test(priority = 0)
	public void open() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.zoopla.co.uk/");

	}

	@Test(priority = 1)
	public void valiatePriceOrder() {
		driver.findElement(By.xpath("//*[@id=\"search-input-location\"]")).sendKeys("London");
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();

		List<WebElement> pricelist = driver.findElements(
				By.xpath("//*[contains(@id,'listing_')]/div/div[2]/a[@class='listing-results-price text-price']"));
		ArrayList<Integer> intList = new ArrayList<Integer>();

		for (int i = 0; i < pricelist.size(); i++) {
			String priceName = pricelist.get(i).getText().substring(1);
			String[] a = priceName.split(" ");

			// System.out.println(a[0].replace(",", ""));

			intList.add(Integer.parseInt(a[0].replace(",", "")));

		}
		System.out.println(intList);
		Collections.sort(intList, Collections.reverseOrder());
		System.out.println(intList);

		// Click 5th
		pricelist.get(4).click();

		if (driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/div/div[1]/a/div[2]/h4")).getText()
				.equalsIgnoreCase("Capital Estate London")) {
			System.out.println("Agent name matched");
		} else {
			System.out.println("Agent name not matched");
		}

	}

}
