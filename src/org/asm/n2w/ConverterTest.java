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
		Assert.assertEquals("zero", c.convert(0));
		Assert.assertEquals("one", c.convert(1));
		Assert.assertEquals("two", c.convert(2));
		Assert.assertEquals("three", c.convert(3));
		Assert.assertEquals("four", c.convert(4));
		Assert.assertEquals("five", c.convert(5));
		Assert.assertEquals("six", c.convert(6));
		Assert.assertEquals("seven", c.convert(7));
		Assert.assertEquals("eight", c.convert(8));
		Assert.assertEquals("nine", c.convert(9));
		Assert.assertEquals("ten", c.convert(10));
		Assert.assertEquals("eleven", c.convert(11));
		Assert.assertEquals("twelve", c.convert(12));
		Assert.assertEquals("thirteen", c.convert(13));
		Assert.assertEquals("fifteen", c.convert(15));
		Assert.assertEquals("eighteen", c.convert(18));
	}
	@Test
	public void teens() {
		Assert.assertEquals("fourteen", c.convert(14));
		Assert.assertEquals("sixteen", c.convert(16));
		Assert.assertEquals("seventeen", c.convert(17));
		Assert.assertEquals("nineteen", c.convert(19));
	}
	@Test
	public void tens() {
		Assert.assertEquals("ten", c.convert(10));
		Assert.assertEquals("twenty", c.convert(20));
		Assert.assertEquals("thirty", c.convert(30));
		Assert.assertEquals("forty", c.convert(40));
		Assert.assertEquals("fifty", c.convert(50));
		Assert.assertEquals("sixty", c.convert(60));
		Assert.assertEquals("seventy", c.convert(70));
		Assert.assertEquals("eighty", c.convert(80));
		Assert.assertEquals("ninety", c.convert(90));
	}
	@Test
	public void doubleDigits() {
		Assert.assertEquals("fifty-five", c.convert(55));
		Assert.assertEquals("ninety-nine", c.convert(99));
	}
	
}
