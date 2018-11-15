package kr.or.ddit.locales;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Test;

public class LocalesTest {

	@Test
	public void localesTest() {
		/***Given***/

		/***When***/
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales)
			System.out.println(locale);

		/***Then***/
		

	}

}
