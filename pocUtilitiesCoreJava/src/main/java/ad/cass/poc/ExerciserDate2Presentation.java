package ad.cass.poc;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExerciserDate2Presentation {

	public static void main(String[] args) throws ParseException {

		System.out.println("Processant...");
		ExerciserDate2Presentation string2date = new ExerciserDate2Presentation();
		string2date.doTheJob();
		System.out.println("OK...");
	}

	private void doTheJob() throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("LocalDateTime no formatejat: " + now); 
		System.out.println("LocalDateTime    formatejat: " + dtf.format(now)); 
	}

}
