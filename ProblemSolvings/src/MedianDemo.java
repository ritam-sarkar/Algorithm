/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class MedianDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {2,5,8,9,11,23,24,27};
		int [] arr1 = {12,15,18};
		int [] arr2 = {2,14,19}; 
		System.out.println("median is "+medianOfOneSortedArray(arr1));
		System.out.println(" median is for two sorted array "+medianOfTwoSortedArray1(arr1,arr2,arr1.length));
	}

	static int medianOfOneSortedArray(int [] arr){
		int n = arr.length;
		if(n%2 != 0){
			return arr[(n-1)/2];
		}else{
			int firstMedian = arr[(n-1)/2];
			int secondMedian = arr[n/2];
			return (firstMedian+secondMedian)/2;
		}
	}
	/**
	 * When both arrays are sorted and of same size
	 * @param arr1
	 * @param arr2
	 * @param n length
	 * @return
	 */
	static int medianOfTwoSortedArray1(int[] arr1, int[] arr2,int n){
		
		int i=0;
		int j=0;
		int m1=-1;
		int m2= -1;
		for(int count=0;count<=n;count++){
			/**
			 * If all elements of arr1 is smaller than the
			 *  smallest element of arr2
			 */
			if(i==n){
				m1 = m2;
				m1 = arr2[0];
				break;
			}
			/**
			 * If all elements of arr2 is smaller than
			 *  the smallest element of arr1
			 */
			if(j == n){
				m1 = m2;
				m1 = arr1[0];
				break;
			}			
			if(arr1[i]<arr2[j]){
				m1=m2;
				m2 = arr1[i];
				i++;
			}else{
				m1=m2;
				m2 = arr2[j];
				j++;
			}
		}
		return (m1+m2)/2;
		
	}
}


