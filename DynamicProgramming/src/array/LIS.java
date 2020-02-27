package array;

import java.util.Arrays;

import array.util.ArrayUtil;

public class LIS {

	public static void main(String[] args) {
		int A[] = {50, 3, 10, 7, 40, 80}; 
		//int A[] = {10, -22, 9, 33, 21, 50, 41, 60};
		int A2 [] = {0,4,12,2,10,6,9,13,11,7,15};
        //LongestIncreasingSubsequenceLength(A);
        //LongestIncreasingSubsequenceLength(A2);
        System.out.println(lengthOfLISWithBinarySearch(A));


	}
	
    static void LongestIncreasingSubsequenceLength(int A[]) 
    { 
        int n = A.length;
    	int lis[] = new int[n];
    	int len[] = new int[n];
    	for(int i=0;i<n;i++) {
    		len[i] = 1;
    		lis[i] = Integer.MAX_VALUE;
    	}
    	int max = Integer.MIN_VALUE;
    	int maxIndex = -1;
    	for(int i=1;i<n;i++) {
    		for(int j =0;j<i;j++) {
    			if(A[j] < A[i] && len[j]+1 >= len[i]) {    				
					len[i] = len[j]+1;
					lis[i] = j;  
					max = Math.max(max, len[i]);
					maxIndex = i;
    			}
    		}
    	}    	
    	System.out.println("Longest increasing subsequence length "+max);
    	int result[] = new int[max];
        int k = max-1;
        int index = maxIndex;
        while(k >= 0) {
        	result[k--] = A[index];
        	index = lis[index];
        }
    	ArrayUtil.traverse(result);    	
    } 
    private static int findFloorIndex(int arr[], int l, int len, int k) {
    	int r = len-1;
    	while(l<=r) {
    		int mid = (l+r)/2;
    		if(arr[mid] == k) {
    			return mid;
    		} else if(arr[mid] < k) {
    			l = mid+1;
    		} else {
    			r = mid-1;
    		}
    	}
    	return l;
    }
    public static int lengthOfLISWithBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {           
        	int i = findFloorIndex(dp, 0, len, num);
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        System.out.println("Lis is ");
        Arrays.stream(dp).forEach(System.out::print);
        System.out.println();
        return len;
    }

}
