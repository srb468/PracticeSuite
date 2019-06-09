package ExcelOperations;

import java.io.File;
import java.io.FileInputStream;
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

public class ExcelDataProvider2 {
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static String file_location = "C:\\Workspace\\com.practiceSuite\\Temp\\TestCase.xlsx";
	static String SheetName = "Sheet1";
	Row row;

	@Test
	public void ReadVariant() throws IOException {

		File file = new File(file_location);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);

		Sheet sheet = wb.getSheet("Sheet2");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int r = rowCount - 1;
		int c = sheet.getRow(0).getLastCellNum();
		int rInit = 0;
		int rf;
		// Object Data[][] = new Object[r][c];
		for (int s = 1; s < rowCount + 1; s++) {
			String a = sheet.getRow(s).getCell(0).getStringCellValue();
			if (a.equalsIgnoreCase("Login into application") || a.equalsIgnoreCase("Login into application_TCEND")) {
				
				if (a.equalsIgnoreCase("Login into application")) {
					rInit = s;
				}
				if (a.equalsIgnoreCase("Login into application_TCEND")) {
					int rFinal = s;
					rf = rFinal - rInit;
					System.out.println("---ROW---" + rf);
				}
			}
		}
		for (int i = 1; i < rowCount + 1; i++) {
			String val = sheet.getRow(i).getCell(0).getStringCellValue();
			if (val.equalsIgnoreCase("Login into application")
					&& !(val.equalsIgnoreCase("Login into application_TCEND"))) {

				for (int a = i + 1; a < rowCount; a++) {
					Row row = sheet.getRow(a);
					if (!(row.getCell(0).getStringCellValue().equalsIgnoreCase("Login into application_TCEND"))) {

						for (int b = 0; b < row.getLastCellNum(); b++) {
							if ((row.getCell(0).getStringCellValue()
									.equalsIgnoreCase("Login into application_TCEND"))) {
								break;
							} else {
								String value = sheet.getRow(a).getCell(b).getStringCellValue();
								// Data[a][b] = value;
								System.out.print(value + "|");
							}
						}
						System.out.println();
					} else {
						break;
					}
				}
			} else if (val.equalsIgnoreCase("Login into application_TCEND")) {
				break;
			}
		}
	}

	/*
	 * @Test() public void runner(String a, String b, String c, String d, String e)
	 * throws IOException { ReadVariant();
	 * 
	 * }
	 */
}
