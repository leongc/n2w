package org.asm.n2w;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class ConverterTest {
	private Converter c;
	
	@Before
	public void setUp() {
		c = new Converter();
	}
	@Test
	public void uniques() {
		assertConvert("zero", "0");
		assertConvert("one", "1");
		assertConvert("two", "2");
		assertConvert("three", "3");
		assertConvert("four", "4");
		assertConvert("five", "5");
		assertConvert("six", "6");
		assertConvert("seven", "7");
		assertConvert("eight", "8");
		assertConvert("nine", "9");
		assertConvert("ten", "10");
		assertConvert("eleven", "11");
		assertConvert("twelve", "12");
		assertConvert("thirteen", "13");
		assertConvert("fifteen", "15");
		assertConvert("eighteen", "18");
	}
	@Test
	public void teens() {
		assertConvert("fourteen", "14");
		assertConvert("sixteen", "16");
		assertConvert("seventeen", "17");
		assertConvert("nineteen", "19");
	}
	@Test
	public void tens() {
		assertConvert("ten", "10");
		assertConvert("twenty", "20");
		assertConvert("thirty", "30");
		assertConvert("forty", "40");
		assertConvert("fifty", "50");
		assertConvert("sixty", "60");
		assertConvert("seventy", "70");
		assertConvert("eighty", "80");
		assertConvert("ninety", "90");
	}
	@Test
	public void doubleDigits() {
		assertConvert("fifty-five", "55");
		assertConvert("ninety-nine", "99");
	}
	@Test
	public void tripleDigits() {
		assertConvert("one hundred", "100");
		assertConvert("five hundred one", "501");
		assertConvert("nine hundred eighty-seven", "987");
	}
	@Test
	public void thousands() {
		assertConvert("one thousand", "1000");
		assertConvert("two thousand one", "2001");
		assertConvert("sixty-four thousand", "64000");
		assertConvert("nine hundred eighty-seven thousand six hundred fifty-four", "987654");
	}
	@Test
	public void negatives() {
		assertConvert("negative sixty-nine", "-69");
	}
	@Test
	public void largeNumbers() {
		assertConvert("four trillion one", "4000000000001");
		assertConvert("nine billion eight hundred seventy-six million " +
				"five hundred forty-three thousand two hundred ten"
				, "9876543210");
		assertConvert("nine nonillion eight octillion seven septillion six sextillion " +
				"five quintillion four quadrillion three trillion two billion one million"
				, "9008007006005004003002001000000");
		assertConvert("one decillion fifty-five million", "1000000000000000000000000055000000");
	}
	
	private void assertConvert(String expected, String s) {
		Assert.assertEquals(expected, c.convert(s));
	}
}
