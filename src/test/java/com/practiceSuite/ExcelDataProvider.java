package com.practiceSuite;

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

public class ExcelDataProvider {
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static String file_location = "C:\\Workspace\\Automation_Keyword\\Files\\TestCase.xlsx";
	static String SheetName = "Sheet1";
	Row row;

	@Test
	public void ReadVariant() throws IOException {

		File file = new File(file_location);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);

		Sheet sheet = wb.getSheet("Sheet2");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			String val = sheet.getRow(i).getCell(0).getStringCellValue();
			if (val.equalsIgnoreCase("Login into application")) {

				for (int a = i + 1; a < rowCount; a++) {
					// String s = sheet.getRow(a).getCell(0).getStringCellValue();
					// if (!(sheet.getRow(a).getCell(0).getStringCellValue().equals(""))) {
					// row = sheet.getRow(a);
					XSSFRow row = (XSSFRow) sheet.getRow(a);
					if (!(row.getCell(0).getCellType() == XSSFCell.CELL_TYPE_BLANK)) {
						int r = rowCount - 1;
						int c = row.getLastCellNum();

						Object Data[][] = new Object[r][c];
						for (int b = 0; b < row.getLastCellNum(); b++) {
							if ((row.getCell(0).getCellType() == XSSFCell.CELL_TYPE_BLANK)) {
								break;
							} else {
								String value = sheet.getRow(a).getCell(b).getStringCellValue();
								Data[a][b] = value;
								System.out.print(value+"|");
							}
						}
					}
					else {
						break;
					}
					System.out.println();
				}
			}
		}
	}
}
