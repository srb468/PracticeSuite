package com.practiceSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Alt {

	WebDriver driver = null;

	@Test(priority = 0, dataProvider = "supplyData")
	public void collectInfo(String Username, String Password) {
		System.setProperty("webdriver.chrome.driver", "C:\\D\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://sinqchcl01.test.sentinelcloud.com/ems/login.html");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);

		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

	}

	/*
	 * @Test(priority=1,dataProvider= "supplyData") public void loginInto(String
	 * Username, String Password) {
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(Username);
	 * driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
	 * 
	 * }
	 */
	@DataProvider
	public static Object[][] supplyData() throws IOException {
		File src = new File("C:\\Drive2\\TestData.xlsx");
		FileInputStream fIn = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fIn);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum() - 1; j++) {
				String[][] data = new String[i][j];
				if (row.getCell(2).getStringCellValue().equalsIgnoreCase("y")) {
					System.out.print(row.getCell(j).getStringCellValue() + " ");
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					return data;
				}
			}

		}
		return null;

	}
}
