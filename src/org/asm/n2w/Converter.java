package org.asm.n2w;

public class Converter {

	public String convert(int i) {
		if (i < 0) {
			return "negative " + convert(-i);
		} else if (i < 20) {
			return convertOneToTwenty(i);
		} else if (i < 100) {
			int t = i / 10; // integer division gets tens digit
			String tens = convertTens(t);
			int u = i % 10; // modulus gets units digit
			if (u == 0) {
				return tens;
			}
			return tens + '-' + convertOneToTwenty(u);
		} else if (i < 1000) {
			int h = i / 100; // integer division gets hundreds digit
			String hundreds = convertOneToTwenty(h) + " hundred";
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

	private String convertOneToTwenty(int i) {
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
			case 19 : return convertOneToTwenty(i-10)+"teen";
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

	public String convert(String s) {
		s = s.trim();
		if (s.charAt(0) == '-') {
			return "negative " + convert(s.substring(1));
		}
		if (s.length() < 4) {
			String result = convertUpToThreeDigits(s);
			return result.isEmpty() ? "zero" : result;
		}
		int lastTripletIndex = s.length()-3;
		return convertTriplets(s.substring(0, lastTripletIndex)
			, 0
			, convertUpToThreeDigits(s.substring(lastTripletIndex)));
	}


	private String convertTriplets(String prefixDigits, int tripletsConverted,
			String suffixWords) {
		if (prefixDigits.length() < 4) {
			String prefixWords = convertUpToThreeDigits(prefixDigits);
			return prefixWords.isEmpty() ? suffixWords : 
				prefixWords + ' ' + getTripletWords(tripletsConverted) + 
				(suffixWords.isEmpty() ? suffixWords : ' ' + suffixWords);
		} 
		int lastTripletIndex = prefixDigits.length()-3;
		String prefixWords = convertUpToThreeDigits(prefixDigits.substring(lastTripletIndex));
		return convertTriplets(prefixDigits.substring(0, lastTripletIndex)
			, tripletsConverted + 1
			, prefixWords.isEmpty() ? suffixWords :
				prefixWords + ' ' + getTripletWords(tripletsConverted) +
				(suffixWords.isEmpty() ? suffixWords : ' ' + suffixWords));
	}

	private String getTripletWords(int tripletsConverted) {
		switch (tripletsConverted) {
			case 0 : return "thousand";
			case 1 : return "million";
			case 2 : return "billion";
			case 3 : return "trillion";
			case 4 : return "quadrillion";
			case 5 : return "quintillion";
			case 6 : return "sextillion";
			case 7 : return "septillion";
			case 8 : return "octillion";
			case 9 : return "nonillion";
			case 10 : return "decillion";
		}
		throw new NumberFormatException(tripletsConverted + " triplets is beyond the converter's vocabulary");
	}

	private String convertUpToThreeDigits(String s) {
		if (s.length() == 1) {
			return convertOneDigit(s.charAt(0));
		} else if (s.length() == 2) {
			return convertTwoDigits(s);
		} else if (s.length() == 3) {
			return convertThreeDigits(s);
		}
		throw new NumberFormatException(s + " is beyond the converter's abilities");
	}

	private String convertThreeDigits(String s) {
		String tensAndUnits = convertTwoDigits(s.substring(1));
		if (s.charAt(0) == '0') {
			return tensAndUnits;
		}
		String hundreds = convertOneDigit(s.charAt(0)) + " hundred";
		return tensAndUnits.isEmpty() ? hundreds : hundreds + ' ' + tensAndUnits;
	}

	private String convertTwoDigits(String s) {
		String units = convertOneDigit(s.charAt(1));
		if (s.charAt(0) == '0') {
			return units;
		}
		if (s.charAt(0) == '1') {
			return convertTeens(s.charAt(1));
		}
		String tens = convertTens(s.charAt(0));
		return units.isEmpty() ? tens : tens + '-' + units;
	}


	private String convertTens(char tensDigit) {
		switch (tensDigit) {
		case '0': return "";
		case '1': return "ten";
		case '2': return "twenty";
		case '3': return "thirty";
		case '4': return "forty";
		case '5': return "fifty";
		case '6': return "sixty";
		case '7': return "seventy";
		case '8': return "eighty";
		case '9': return "ninety";
		}
		throw new NumberFormatException(tensDigit + " is not a digit");
	}

	private String convertTeens(char unitsDigit) {
		switch (unitsDigit) {
		case '0': return "ten";
		case '1': return "eleven";
		case '2': return "twelve";
		case '3': return "thirteen";
		case '4': return "fourteen";
		case '5': return "fifteen";
		case '6': return "sixteen";
		case '7': return "seventeen";
		case '8': return "eighteen";
		case '9': return "nineteen";
		}
		throw new NumberFormatException(unitsDigit + " is not a digit");
	}

	private String convertOneDigit(char digit) {
		switch (digit) {
		case '0': return "";
		case '1': return "one";
		case '2': return "two";
		case '3': return "three";
		case '4': return "four";
		case '5': return "five";
		case '6': return "six";
		case '7': return "seven";
		case '8': return "eight";
		case '9': return "nine";
		}
		throw new NumberFormatException(digit + " is not a digit");
	}
	
}
