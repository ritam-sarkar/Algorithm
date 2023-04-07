/**
 * 
 */
package com.orcl.dynamicprogramming.tree;

/**
 * @author ritsarka
 *
 */
/**
 * The number of BSTs with n nodes different key is called Catalan
Number and is denoted by Cn. For example, there are 2 BSTs with 2 nodes (2 choices for the
root) and 5 BSTs with 3 nodes.

Cn = summation(i=1 to n) [C(i-1) + C(n-i)]
C0 = C1 =1
 *
 */
public class CatalanNumberOfBST {

	static int[] catalan = new int[1024];
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		catalan[0] = 1;
		System.out.println(" Catalan of Binary tree "+catalanBT(n));
	}
	
	static int catalanBT(int n) {
		if(catalan[n] != 0) {
			return catalan[n];
		}
		for(int i=1; i<=n;i++) {
			catalan[n] += catalanBT(i-1) * catalanBT(n-i);
		}
		return catalan[n];		
	}	

}
