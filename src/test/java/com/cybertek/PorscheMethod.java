package com.cybertek;

public class PorscheMethod {
	
	public static String add(String num1, String num2) {
		return makeNum(num1) + makeNum(num2) + "";
	}

	public static double makeNum(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if ((Character.isDigit(str.charAt(i))) || (str.charAt(i) == '.')) {
				s = s + str.charAt(i);
			}
		}
		return Double.parseDouble(s);
	}

	public static void comparePrices(String s1, String s2) {
		if (makeNum(s1) == makeNum(s2)) {
			System.out.println("verified");
		} else {
			System.out.println("failed");
		}
	}

}
