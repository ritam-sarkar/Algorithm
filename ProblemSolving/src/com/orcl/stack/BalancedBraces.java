package com.orcl.stack;
import java.util.Stack;

public class BalancedBraces {

	public static void main(String[] args) {

		String s1 = "{[(])}";
		String s2 = "{[()]}";
		String s3 = "{{[[(())]]}}";
		System.out.println(isBalanced(s1, new Stack<Character>()));
		System.out.println(isBalanced(s2, new Stack<Character>()));
		System.out.println(isBalanced(s3, new Stack<Character>()));
		
		
	}

	private static String isBalanced(String s, Stack<Character> stack) {
		char[] charArr = s.toCharArray();
		for(char c : charArr) {
			if(stack.isEmpty())
				stack.push(c);
			else {
				if(isComplement(stack.peek(), c)) {
					stack.pop();
				}else {
					stack.push(c);
				}
			}
		}
		if(stack.isEmpty()) {
			return "YES";
		}
		return "NO";
	}
	static boolean  isComplement(char c1, char c2){
		if(c1 == '{' && c2 == '}')
			return true;
		if(c1 == '(' && c2 == ')')
			return true;
		if(c1 == '[' && c2 == ']')
			return true;
		else
			return false;
		
	}

}
