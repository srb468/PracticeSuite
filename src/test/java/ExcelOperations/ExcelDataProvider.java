package ExcelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static String file_location = "C:\\Workspace\\com.practiceSuite\\Temp\\TestCase.xlsx";
	static String SheetName = "Sheet1";
	Row row;
	int rInit;
	int rowCount = 0;

	public int rowCalculator() throws IOException {

		File file = new File(file_location);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb1 = new XSSFWorkbook(inputStream);

		Sheet sheet1 = wb1.getSheet("Sheet2");

		int rowCount = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		for (int s = 1; s < rowCount + 1; s++) {
			String a = sheet1.getRow(s).getCell(0).getStringCellValue();
			if (a.equalsIgnoreCase("Company creation") || a.equalsIgnoreCase("Company creation_TCEND")) {

				if (a.equalsIgnoreCase("Company creation")) {
					rInit = s;
				}
				if (a.equalsIgnoreCase("Company creation_TCEND")) {
					int rFinal = s;
					rowCount = rFinal - rInit;
					System.out.println("---ROW---" + rowCount);
				}
			}
		}
		return rowCount;
	}

	@DataProvider
	public Object[][] ReadVariant() throws IOException {

		File file = new File(file_location);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);

		Sheet sheet = wb.getSheet("Sheet2");
		int presentRows = rowCalculator();
		int c = sheet.getRow(0).getLastCellNum();
		Object Data[][] = new Object[presentRows - 1][c];
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			String val = sheet.getRow(i).getCell(0).getStringCellValue();

			if (val.equalsIgnoreCase("Company creation")
					&& !(val.equalsIgnoreCase("Company creation_TCEND"))) {
				for (int a = i + 1; a < sheet.getLastRowNum(); a++) {
					Row row = sheet.getRow(a);
					if (!(row.getCell(0).getStringCellValue().equalsIgnoreCase("Company creation_TCEND"))) {
						for (int b = 0; b < row.getLastCellNum(); b++) {
							if ((row.getCell(0).getStringCellValue()
									.equalsIgnoreCase("Company creation_TCEND"))) {
								break;
							} else {
								String value = sheet.getRow(a).getCell(b).getStringCellValue();
								Data[rowCount][b] = value;
							}
						}
					} else {
						break;
					}
					rowCount++;
				}
			} else if (val.equalsIgnoreCase("Company creation_TCEND")) {
				break;
			}
		}
		return Data;

	}

	@Test(dataProvider = "ReadVariant")
	public void runner(String a,String b,String c,String d, String e) throws IOException {
		// ReadVariant();
		//System.out.println(Data);
		System.out.println(a + b + c + d + e);
	}
}
