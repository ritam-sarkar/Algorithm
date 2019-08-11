package com.orcl.array;

public class OpenTextQuestion {

	public static void main(String[] args) {

		String s = "opentext";
		System.out.println(solution(s,'t'));
	}

	private static String solution(String s, char x) {

		int n = s.length();
		char[] arr = s.toCharArray();
		int count = 0;
		for(int i=0;i<n;i++) {
			if(arr[i] == x) {
				count++;
				//arr[i] = Character.forDigit(count, 10);
				arr[i] = (char)(count+'0');
			}
		}
		return String.valueOf(arr);
		
	}

}
