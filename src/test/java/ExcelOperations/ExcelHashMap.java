package ExcelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHashMap {

	// public static final String filepath="./data.xlsx";
	private static FileInputStream fis;
	private static XSSFSheet sheet;
	private static XSSFWorkbook wb;
	private static XSSFRow row;

	public static void loadexcel() throws IOException {
		System.out.println("Loading excel data.....");
		File src = new File("C:\\Workspace\\com.practiceSuite\\Temp\\MapData.xlsx");
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");
		fis.close();
	}

	public static Map<String, Map<String, String>> getdata() throws IOException {
		if (sheet == null) {
			loadexcel();
		}
		Map<String, Map<String, String>> supermap = new HashMap<String, Map<String, String>>();
		Map<String, String> mymap = new HashMap<String, String>();

		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			String keycell = row.getCell(0).getStringCellValue();
			int colnum = row.getLastCellNum();
			for (int j = 1; j < colnum; j++) {
				String value = row.getCell(j).getStringCellValue();
				mymap.put(keycell, value);
			}
			supermap.put("MASTERDATA", mymap);
			System.out.println(supermap); 
			
		}

		return supermap;

	}

	public static String getvalue(String key) throws IOException {
		Map<String, String> myval = getdata().get("MASTERDATA");
		String value = myval.get(key);
		return value;

	}

	public static void main(String args[]) throws IOException {
		System.out.println(getvalue("baseurl"));
	}

}
