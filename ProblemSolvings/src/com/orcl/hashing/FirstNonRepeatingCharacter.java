package com.orcl.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {

		String s = "GeeksforGeeks";
		System.out.println(getFirstNonRepeatingCharacter(s));
	}

	private static Character getFirstNonRepeatingCharacter(String s) {
		int n = s.length();
		Map<Character, Integer> countMap = new LinkedHashMap<Character, Integer>();
		for(int i=0; i< n; i++) {
			char c = s.charAt(i);
			if(countMap.containsKey(c)) {
				int count = countMap.get(c) +1;
				countMap.put(c, count);				
			}else {
				countMap.put(c, 1);
			}
		}
		for(Map.Entry<Character, Integer> e : countMap.entrySet()) {
			if(e.getValue() == 1) {
				return e.getKey();
			}
		}
		return null;
	}

}
