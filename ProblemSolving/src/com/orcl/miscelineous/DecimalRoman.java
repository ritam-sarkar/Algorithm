package com.orcl.miscelineous;

import java.util.HashMap;
import java.util.Map;

public class DecimalRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String units[]={"","I","II","III","IV","V","VI","VII","VIII","IX"}; 
	     String tens[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	     String hundreds[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	     
	     
	     Map<Character, Integer> romanToDecimalMap = new HashMap<Character, Integer>();
	     romanToDecimalMap.put('I', 1);	    
	     romanToDecimalMap.put('V', 5);	   
	     romanToDecimalMap.put('X', 10);
	     romanToDecimalMap.put('L', 50);	
	     romanToDecimalMap.put('C', 100);	     
	     romanToDecimalMap.put('D', 500);	    
	     romanToDecimalMap.put('M', 1000);	
	    
	    	  
	     System.out.println(" Roman to decinal MMDCCXC  is "+romanToDecimal("MMDCCXC", romanToDecimalMap));
	     System.out.println(" Decimal to roman 2790  is "+decimalToRoman(2790, units, tens, hundreds));

	     
	}

	private static String decimalToRoman(int n, String[] units, String[] tens, String[] hundreds) {
		int m = n / 1000;
		StringBuilder result = new StringBuilder();
		while(m >0) {
			result.append("M");
			m--;
		}
		result.append(hundreds[(n%1000)/100]);
		result.append(tens[(n%100)/10]);
		result.append(units[(n%10)]);		
		return result.toString();
	}

	private static int romanToDecimal(String roman, Map<Character, Integer> romanToDecimalMap) {
		int n = roman.length();
		int result = 0;
		for(int i =0; i<n; i++) {
			int val = romanToDecimalMap.get(roman.charAt(i));
			if(i > 0 && val > romanToDecimalMap.get(roman.charAt(i-1))) {
				result += val - 2*(romanToDecimalMap.get(roman.charAt(i-1)));
			} else {
				result += val;
			}
		}
		return result;
	}

}
