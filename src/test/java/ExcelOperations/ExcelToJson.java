package ExcelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExcelToJson {

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

	public static void getdata() throws IOException {
		if (sheet == null) {
			loadexcel();
		}
		// Map<String, Map<String, String>> supermap = new HashMap<String, Map<String,
		// String>>();
		// Map<String, String> mymap = new HashMap<String, String>();
		JSONArray jarray = new JSONArray();
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();

		JSONObject fin = new JSONObject();

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			// jarray.add(row);
			int colnum = row.getLastCellNum();
			for (int j = 0; j < colnum; j++) {
				String keycell = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = row.getCell(j).getStringCellValue();
				obj1.put(keycell, value);

				 //jarray.add(value);
			}
			String r = "row"+i;
			obj2.put(r, obj1);
			
			//obj2.put(r, obj1);
			fin.put("data", obj2);
			
		}

		// return fin;
		//fin.put("data", obj2);
		System.out.println(fin);

	}

	public static void getvalue(String key) throws IOException {

	}

	public static void main(String args[]) throws IOException {
		getdata();

	}

}
