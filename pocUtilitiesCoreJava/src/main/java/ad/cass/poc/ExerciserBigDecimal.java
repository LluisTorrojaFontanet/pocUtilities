package ad.cass.poc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ExerciserBigDecimal {

	/**
	 * Pint separado de milers i coma separador de decimals
	 */
	public static void main(String[] args) {

		System.out.println("Processant...");
		BigDecimal currency = new BigDecimal("12341.005");
		System.out.println("Import: [" + currency + "]");		
		System.out.println("Import formatejat: [" + format(currency) + "]");		
		System.out.println("Ok...");

	}

	private static String format(BigDecimal currency) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator('.');
		DecimalFormat formatter = new DecimalFormat("##,##0.00", symbols);
		//DecimalFormat formatter = new DecimalFormat("##,##0.000");
		
		return formatter.format(currency);
	}
	
}
