package org.asm.n2w;

public class Converter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Converter c = new Converter();
		try {		     
			int i = getNumber(args);
			System.out.println(c.convert(i));
		} catch (NumberFormatException nfe) {
			printUsage(nfe.getMessage());
		}
	}

	private static int getNumber(String[] args) {
		if (args.length < 1 || args[0] == null) {
			throw new NumberFormatException("null is not an integer");
		}
		return Integer.parseInt(args[0]);
	}

	private static void printUsage(String message) {
		System.out.println("Usage: " + Converter.class.getSimpleName() + " i");
		System.out.println("       where i is an integer");
		System.out.println(message);		
	}
	
	public String convert(int i) {
		if (i < 0) {
			throw new NumberFormatException("Cannot convert negative numbers");
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
		}
		throw new NumberFormatException("Cannot convert above 99");
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
			
			default: throw new NumberFormatException(i + " is not a digit below twenty");
		}
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
