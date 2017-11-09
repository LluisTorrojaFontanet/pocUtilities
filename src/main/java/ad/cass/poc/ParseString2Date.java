package ad.cass.poc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lowagie.text.DocumentException;

public class ParseString2Date {

	public static void main(String[] args) throws ParseException {

		System.out.println("Processant...");
		ParseString2Date string2date = new ParseString2Date();
		string2date.doTheJob();
		System.out.println("OK...");
	}

	private void doTheJob() throws ParseException {
		Object stringDate = "2017-10-23";

		Calendar calendar = Calendar.getInstance();

		if ((stringDate instanceof Date)) {
			calendar.setTime((Date) stringDate);
		} else {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) stringDate);
			calendar.setTime(date);
		}

		System.out.println(calendar.getTime().toString());
	}

}
