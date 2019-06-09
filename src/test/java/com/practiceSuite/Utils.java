package com.practiceSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utils {

	public static void main(String[] args) throws IOException {

		// public static String[][] getData() throws IOException {
		File src = new File("C:\\Drive2\\TestData.xlsx");
		FileInputStream fIn = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fIn);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum()-1; j++) {
			Object[][] data = new Object[3][2];
			if (row.getCell(2).getStringCellValue().equalsIgnoreCase("y")) {
				System.out.print(row.getCell(j).getStringCellValue() + " ");
				data[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1] = sheet.getRow(i).getCell(1).getStringCellValue();

				//System.out.println(data.toString());
			}
		}
	}
	}
}
