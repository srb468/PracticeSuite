package ExcelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataprovider {
	WebDriver driver = null;

	@DataProvider
	public Object[][] read() throws IOException {

		File file = new File("C:\\Workspace\\com.practiceSuite\\Temp\\MapData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet("Sheet2");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object Data[][] = new Object[rowCount][colCount];
		System.out.println(colCount + " - " + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				Data[i-1][j] = value;
			}
		}
		return Data;
	}
	@Test(priority = 0)
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com");
	}
	@Test(priority = 1, dataProvider = "read")
	public void loginInto(String uName, String Pwd) {
		System.out.println("Username: " + uName + "|  Password: " + Pwd);

		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).sendKeys(uName);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[2]")).clear();
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[2]")).sendKeys(Pwd);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();

	}
}
