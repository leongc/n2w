package org.asm.n2w;

public class Converter {

	public String convert(int i) {
		if (i < 0) {
			return "negative " + convert(-i);
		} else if (i < 20) {
			return convertZeroToTwenty(i);
		} else if (i < 100) {
			int t = i / 10; // integer division gets tens digit
			String tens = convertTens(t);
			int u = i % 10; // modulus gets units digit
			if (u == 0) {
				return tens;
			}
			return tens + '-' + convertZeroToTwenty(u);
		} else if (i < 1000) {
			int h = i / 100; // integer division gets hundreds digit
			String hundreds = convertZeroToTwenty(h) + " hundred";
			int r = i % 100; // modulus gets tens and units
			if (r == 0) {
				return hundreds;
			}
			return hundreds + ' ' + convert(r);
		} else if (i < 1000000) {
			int th = i / 1000; // integer division gets thousands
			String thousands = convert(th) + " thousand";
			int r = i % 1000; // modulus gets hundreds, tens, and units
			if (r == 0) {
				return thousands;
			}
			return thousands + ' ' + convert(r);
		}
		throw new NumberFormatException("Cannot convert above 999,999");
	}

	private String convertZeroToTwenty(int i) {
		switch (i) {
			case 0 : return "zero";
			case 1 : return "one";
			case 2 : return "two";
			case 3 : return "three";
			case 4 : return "four";
			case 5 : return "five";
			case 6 : return "six";
			case 7 : return "seven";
			case 8 : return "eight";
			case 9 : return "nine";
			case 10 : return "ten";
			case 11 : return "eleven";
			case 12 : return "twelve";
			case 13 : return "thirteen";
			case 15 : return "fifteen"; 
			case 18 : return "eighteen";
			
			case 14 : 
			case 16 :
			case 17 :
			case 19 : return convertZeroToTwenty(i-10)+"teen";
		}
		throw new NumberFormatException(i + " is not a digit below twenty");
	}
	
	private String convertTens(int i) {
		switch (i) {
			case 2 : return "twenty";
			case 3 : return "thirty";
			case 4 : return "forty";
			case 5 : return "fifty";
			case 6 : return "sixty";
			case 7 : return "seventy";
			case 8 : return "eighty";
			case 9 : return "ninety";
		}
		throw new NumberFormatException("Unable to convert tens");
	}
	
}
