package array;

import array.util.ArrayUtil;

/**
 * Example :
 * Input -2,11,-4,13,-5,2
 * Output : 20 of (11,-4,13)
 * 
 * 11+13 = 24 is giving maximum value but they are not contiguous,
 * You cannot change the sequence of the array by sorting
 * 
 * 
 * @author ritsarka
 *
 */

public class MaximumOfContiguousSubSequence {

	public static void main(String[] args) {

		int arr[] = {-2, 11, -4, 13, -5, 2};
		int arr2[] = {4, -1, -2, 1 ,5};
		int s[] = findSolutionArray(arr);
		//ArrayUtil.traverse(s);
		int[] ans = findMaximumSubSequence(s,arr);
		ArrayUtil.traverse(ans);
		System.out.println(" Without dynamic programing max sum is "+findMaxSumWithoutDP(arr2));
	}

	private static int[] findMaximumSubSequence(int[] s, int[] arr) {
		int end = -1;
		int start = 0;
		int max = -1;
		for(int i = s.length-1; i >= 0; i--) {
			if(s[i] > max) {
				max = s[i];
				end = i;
			}else if(s[i] == 0) {
				start = i+1;
			}
		}
		System.out.println(" Maximum sum "+max);
		int ans[] = new int[end-start+1];
		for(int i= start,j=0; i<=end  && j<ans.length; i++,j++) {
			ans[j] = arr[i];
		}
		return ans;
	}

	/**	
	 * s(i) = max(s(i-1)+a(i) , 0 )
	 * For first element i-1 will be negetive, so 0th element can be calculated in hard coding manner
	 * like if a(0) is -ve then s(0) = 0
	 * @param arr
	 * @return
	 */
	private static int[] findSolutionArray(int[] arr) {
		int s[] = new int[arr.length];
		s[0] = arr[0] > 0 ? arr[0] : 0; 
		for(int i=1;i<arr.length;i++) {
			s[i] = Math.max(s[i-1]+arr[i], 0);
		}
		return s;
	}
	private static int findMaxSumWithoutDP(int[] arr) {
		int max =0;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			if(sum < 0) {
				sum = 0;
			}
			if(max<sum) {
				max = sum;
			}
		}
		return max;
	}

}
