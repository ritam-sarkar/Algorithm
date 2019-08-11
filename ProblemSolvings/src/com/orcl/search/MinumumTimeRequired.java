package com.orcl.search;
/**
 * https://www.hackerrank.com/challenges/minimum-time-required/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 * https://www.geeksforgeeks.org/minimum-time-required-produce-m-items/
 * @author ritsarka
 *
 */
public class MinumumTimeRequired {

	public static void main(String[] args) {
		long m[] = {4,5,6};
		long x = 12;
        System.out.println(findMinimumTime(m,x));
        long l = 456787909;
        long lArray[] = {212334,63340,54040};
        int ans =0;
        for(int i=0;i<lArray.length;i++) {
        	ans += l/lArray[i];
        }
        System.out.println(ans);
        System.out.println(findItem(lArray, l));
         
	}

	private static long findMinimumTime(long[] m, long x) {
	   	long maxVal = Long.MIN_VALUE;
	   	for(int i=0;i<m.length;i++) {
	   		maxVal = Math.max(maxVal, m[i]);
	   	}
	   	return binarySearch(m, maxVal*x, x);
	   	
	}

	private static long binarySearch(long[] arr, long maxDays, long x) {
		long low =1;
		long high = maxDays;
		while(low < high) {
			long mid = (low+high)/2;
			long totalItem = findItem(arr, mid);			
			if(totalItem < x) {
				low = mid+1;
			}else {
				high = mid;
			}					
		}
		return high;
		
		
	}
	private static long findItem(long[] arr, long totalDays) {
		long totalItem =0;
		for(int i=0;i<arr.length;i++) {
			totalItem += (totalDays/arr[i]);
		}
		return totalItem;
	}

}

