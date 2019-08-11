package com.orcl.array;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/subset-no-pair-sum-divisible-k/
 * @author ritsarka
 *
 */
public class NonDevisibleSubset {

	public static void main(String[] args) {

		int[] S = {19,10,12,14,24,25,22};
		int k = 4;
		int f[] = new int[k];
		for(int i=0;i<S.length;i++) {
		  f[S[i] % k]++;
		}
		// if K is even, then update f[K/2] 
		if (k % 2 == 0) 
            f[k/2] = Math.min(f[k/2], 1); 
      
        // Initialize result by minimum of 1 or 
        // count of numbers giving remainder 0 
		// because there can be no element which has reminder 0, in that case start result count from 0
        int res = Math.min(f[0], 1); 
      
        // Choose maximum of count of numbers 
        // giving remainder i or K-i 
        for (int i = 1; i <= k/2; i++) 
            res += Math.max(f[i], f[k-i]); 
        System.out.println(res);
      
		
	}

}
