package org.asm.n2w;

public class Converter {

	public String convert(String s) {
		s = s.trim();
		if (s.charAt(0) == '-') {
			return "negative " + convert(s.substring(1));
		}
		String result = convertTriplets(s, 0, "");
		return result.isEmpty() ? "zero" : result;
	}

	private String convertTriplets(String prefixDigits, int tripletsConverted,
			String suffixWords) {
		String prefixWords;
		String tripletWords = getTripletWords(tripletsConverted);
		if (prefixDigits.length() < 4) {
			prefixWords = convertUpToThreeDigits(prefixDigits);
			return assembleTriplet(prefixWords, tripletWords, suffixWords);
		} 
		int lastTripletIndex = prefixDigits.length()-3;
		prefixWords = convertUpToThreeDigits(prefixDigits.substring(lastTripletIndex));
		return convertTriplets(prefixDigits.substring(0, lastTripletIndex)
			, tripletsConverted + 1
			, assembleTriplet(prefixWords, tripletWords, suffixWords));
	}

	private String assembleTriplet(String prefixWords, String tripletWords,
			String suffixWords) {
		if (prefixWords.isEmpty()) {
			return suffixWords; 
		}
		StringBuilder sb = new StringBuilder(prefixWords);
		if (!tripletWords.isEmpty()) {
			sb.append(' ').append(tripletWords); 
		}
		if (!suffixWords.isEmpty()) {
			sb.append(' ').append(suffixWords);
		}
		return sb.toString();
	}

	private String getTripletWords(int tripletsConverted) {
		switch (tripletsConverted) {
		case 0 : return "";
		case 1 : return "thousand";
		case 2 : return "million";
		case 3 : return "billion";
		case 4 : return "trillion";
		case 5 : return "quadrillion";
		case 6 : return "quintillion";
		case 7 : return "sextillion";
		case 8 : return "septillion";
		case 9 : return "octillion";
		case 10 : return "nonillion";
		case 11 : return "decillion";
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
