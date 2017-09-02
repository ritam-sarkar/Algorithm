/**
 *  Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5
 */

/**
 * @author Ritam
 *
 */
public class ContiguousSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a1[] = {14, 12, 11, 20};
		int a2[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		System.out.println("find max length of contiguous subarray of a1 "+findMaxLength(a1));
		System.out.println("find max length of contiguous subarray of a2 "+findMaxLength(a2));
	}
	
	private static int findMaxLength(int a[]){
		int maxLen =0;
		for(int i=0;i<a.length;i++){
			int mx = a[i];
			int mn = a[i];
			
			for(int j = i+1;j<a.length;j++){
				mx = NumberUtil.max(mx, a[j]);
				mn = NumberUtil.min(mn, a[j]);
				if((mx-mn)== (j-i)){
					maxLen = NumberUtil.max(maxLen,(mx-mn+1));
				}
			}
		}
		return maxLen;
	}

}
