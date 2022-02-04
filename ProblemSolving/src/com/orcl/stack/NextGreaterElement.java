package com.orcl.stack;

/**
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
   https://www.geeksforgeeks.org/next-greater-element/
 */
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int arr[] = { 4, 5, 2, 25 };
        printNGE(arr, arr.length);
	}

	static void printNGE(int arr[], int n) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		for(int i=1; i<n;i++) {
			int next = arr[i];
			// check the next element with each element of the stack if next > top then pop the top and print popped element's NGE is next
			while(!stack.isEmpty() && next > stack.peek()) {
				System.out.println(stack.pop()+" --> "+next);
			}
			// at the end push the next alement as well
			stack.push(next);
		}
		while(!stack.isEmpty()) {
			int noelement = -1;
			System.out.println(stack.pop()+" --> "+noelement);
		}
	}

}
