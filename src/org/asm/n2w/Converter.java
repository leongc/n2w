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
			default: return "ERROR";
		}
	}

}
