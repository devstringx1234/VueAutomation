package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GenericMethods {
	
	public String getCurrentDate(RemoteWebDriver driver) {
		DateFormat dateformat=new SimpleDateFormat("yyyy-MMM-d");
		Date date=new Date();
		return dateformat.format(date).toUpperCase();
	}
	
	public String getCurrentDateWithFormat(RemoteWebDriver driver) {
		DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		return dateformat.format(date);
	}
	
	public String getEndDate(RemoteWebDriver driver, int difference) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-d");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, difference); // Adding 3 days
		String output = sdf.format(c.getTime());
		return output.toUpperCase();
	}
	
	public String getEndDateWithFormat(RemoteWebDriver driver) {
		DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 3); // Adding 3 days
		String output = dateformat.format(c.getTime());
		return output.toUpperCase();
	}
	
	public String getCurrentTime(RemoteWebDriver driver) {
		DateFormat timeFormat=new SimpleDateFormat("HH:mm");
		Date date=new Date();
		return timeFormat.format(date);
	}
}
