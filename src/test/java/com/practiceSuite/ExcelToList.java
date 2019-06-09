package com.practiceSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToList {

	public static void main(String args[]) throws IOException {

		File file = new File("C:\\Users\\10059665\\Desktop\\TestCases_Namespace.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);

		Sheet sheet = wb.getSheet("Sheet2");

		List<List> allRows = new ArrayList<List>();
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount+1; i++) {
			Row row = sheet.getRow(i);
			List<String> arrName = new ArrayList<String>();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (!(row.getCell(1).getStringCellValue().isEmpty())) {
					if (row.getCell(6).getStringCellValue().equalsIgnoreCase("Y")) {
						arrName.add(row.getCell(j).getStringCellValue());
					}
				}
			}
			allRows.add(arrName);
		}

		allRows.removeIf(p -> p.isEmpty());
		//System.out.println(allRows.size());
		//System.out.println(allRows);
		for (int i=0; i<allRows.size();i++) {
		String locatorType = allRows.get(i).get(3).toString() ;
		String locatorVal =allRows.get(i).get(4).toString();
		String testData = allRows.get(i).get(5).toString();
		System.out.print(locatorType +" " +locatorVal+" "+testData);
		System.out.println();
		}
	}
}
