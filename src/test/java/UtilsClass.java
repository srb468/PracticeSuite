import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.internal.BaseTestMethod;

public class UtilsClass {

	public String addDate(long daysAfter) throws ParseException {

		LocalDate date = LocalDate.now();
		System.out.println("Current date: " + date);

		// Adding number of Days to the current date
		LocalDate date2 = date.plusDays(daysAfter);

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = date2.format(format);
		System.out.println("Adding days to the current date: " + formattedString);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date datein = formatter.parse(formattedString);
		formatter = new SimpleDateFormat("E MMM dd YYYY");
		return formatter.format(datein);

	}
	
	
}
