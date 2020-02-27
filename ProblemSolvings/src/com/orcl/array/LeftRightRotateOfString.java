package com.orcl.array;

public class LeftRightRotateOfString {

	public static void main(String[] args) {

		
		System.out.println(leftRotate("geeks", 2));
		System.out.println(rightRotate("tab", 5));
		
	}
	static String leftRotate(String str, int d) {
		int n = str.length();
		if(d > n) {
			d = d %n;
		}
		return str.substring(d, str.length()) + str.substring(0,d);
	}
	static String rightRotate(String str, int d) {
		
		int n = str.length();
		if(d > n) {
			d = d %n;
		}
		return str.substring(n-d,n) + str.substring(0,(n-d));
	}
	

}
