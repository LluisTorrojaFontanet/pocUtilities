package ad.poc.test;

import java.text.Normalizer;

import org.junit.Test;

import junit.framework.TestCase;

public class TestString extends TestCase {

	/**
	 * Erase non english characters from a string
	 */
	@Test
	public void testNormalize() {

		System.out.println("START (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") method");

		String TEXT_NO_NORMALITZAT = "àçóü ÑÇèéë à l·l";
		System.out.println("Text no normalitzat: [" + TEXT_NO_NORMALITZAT + "]");
		System.out.println("Text si normalitzat: [" + flattenToAscii(TEXT_NO_NORMALITZAT) + "]");		
		System.out.println("FINISH (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") method");

	}

	private String flattenToAscii(String string) {
		StringBuilder sb = new StringBuilder(string.length());
		string = Normalizer.normalize(string, Normalizer.Form.NFD);
		for (char c : string.toCharArray()) {
			if (c <= '\u007F')
				sb.append(c);
		}
		return sb.toString();
	}
}
