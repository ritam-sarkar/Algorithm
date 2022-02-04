package com.orcl.stack;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//https://www.hackerrank.com/challenges/reduced-string/problem
public class SuperReduceString {

	public static void main(String[] args) {

		System.out.println(superReducedString("aaabcdd"));
	}
	static String superReducedString(String s) {

	    Stack<Character> stack = new Stack<Character>();
	    ArrayDeque<Character> queue = new ArrayDeque<Character>();
	    
	    
	    for(int i=0;i<s.length();i++){
	        if(stack.isEmpty()){
	           stack.push(s.charAt(i)); 
	        }else{
	            if(stack.peek() == s.charAt(i)){
	                stack.pop();
	            }else{
	                stack.push(s.charAt(i));
	            }
	        }
	    }
	    char[] result = new char[stack.size()];
	    int k =stack.size()-1;

	    while(!stack.isEmpty()){
	        result[k] = stack.pop();
	        k--;
	    }
	      
	    return result.length == 0 ? "Empty String" : String.valueOf(result); 
	    }

}
