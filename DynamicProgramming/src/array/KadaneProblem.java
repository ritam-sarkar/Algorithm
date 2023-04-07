package array;

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

public class KadaneProblem {

	public static void main(String[] args) {

		int arr[] = {-2, 11, -4, 13, -5, 2};
		int arr2[] = {4, -1, -2, 1 ,5};
		
		System.out.println(" Without dynamic programing max sum is "+findMaxSumWithoutDP(arr2));
	}

/**
 * Kadane's algorithm
 * @param arr
 * @return
 */
	private static int findMaxSumWithoutDP(int[] arr) {
		int max =0;
		int maxIndex = 0;
		int sum=0;
		int n = arr.length;
		int sumArr[] = new int[n];
		int solution[] = new int[n];	
		int prevIndex = -1;		
		for(int i =0; i<n; i++) {
			sum += arr[i];
			sumArr[i] = sum;
			solution[i] = prevIndex;
			if(max < sum) {
				max = sum;
				maxIndex = i;
			}
			if(sum < 0) {
				prevIndex = -1; 
				sum =0;
			}else {
				prevIndex =i;
			}
		}
		int len =0;
		int[] ans = new int[maxIndex+1];
		int index = maxIndex;
		while(index != -1) {
			ans[len++] = arr[index];
			index = solution[index];
		}
		System.out.println("Solution is ");
		while(len > 0) {
			System.out.print(ans[--len]+" ");
		}		
		return max;
	}

}
