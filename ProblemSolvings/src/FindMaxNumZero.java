/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindMaxNumZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {100,120,101,211,90008,65410005,400050710};
		System.out.println("the number is "+findNumber(arr));
	}

	private static int findNumber(int[] arr) {
		int maxIndex = -1;
		int max =0;
		for(int i=0;i<arr.length;i++){
			int count = findZeroCount(arr[i]);	
			if(count > max){
				max = count;
				maxIndex =i;
			}
		}		
		return arr[maxIndex];
	}
	private static int findZeroCount(int n){
		int count =0;
		while(n>0){
			if(n%10 == 0){
				count++;
			}
			n =n/10;
		}
		return count;
	}
	
}
