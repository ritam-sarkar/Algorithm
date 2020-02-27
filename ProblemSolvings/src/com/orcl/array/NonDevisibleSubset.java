package com.orcl.array;

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
		// Find number of element each reminder has
		for(int i=0;i<S.length;i++) {
		  f[S[i] % k]++;
		}
		/**
		 * Now f[0] = 2 , f[1] = 1 , f[2] = 3 , f[3] = 1
		 * f[1] and f[3]  && f[3] and f[1] cannot be pair
		 * f[2] and f[2] cannot be pair 
		 * f[0] and f[0] cannot be pair 
		 * 
		 */
		// if K is even, then update f[K/2] 
		if (k % 2 == 0) 
            f[k/2] = Math.min(f[k/2], 1);       
       
		// Sometimes f[0] =0 then start counting from 0
        int res = Math.min(f[0], 1); 
      
	     /**
	      * for f[1] start comparing with f[4-1] = f[3]
	      * If k =5 then f[2] compared with f[5-2]= f[3]
	      * We need to find the max as they cannot be paired
	      * 
	      * 
	      */
        for (int i = 1; i <= k/2; i++) 
            res += Math.max(f[i], f[k-i]); 
        System.out.println(res);
      
		
	}

}
