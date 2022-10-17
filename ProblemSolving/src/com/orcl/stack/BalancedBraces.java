package com.orcl.stack;
import java.util.Stack;

public class BalancedBraces {

	public static void main(String[] args) {

		String s1 = "{[(])}";
		String s2 = "{[()]}";
		String s3 = "{{[[(())]]}}";
		System.out.println(s1 + isValid(s1));
		System.out.println(s2 + isValid(s2));
		System.out.println(s3 + isValid(s3));

	}

	private static boolean isValid(String s) {
		// It is not parsing the entire string wherever it breaks it returns false
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

}
