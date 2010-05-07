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
	public void digits() {
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
	}
	
}
