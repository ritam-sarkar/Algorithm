/**
 * 
 */
package number.reccursive;

import java.util.Arrays;

/**
 * @author Ritam
 *
 */
public class NextLargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      
		int[] a = {5,3,4,9,7,6};
		a = findNextlargest(a);
		for(int i=0;i<a.length;i++){
			System.out.print(" "+a[i]);
		}
		
	}
	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i]=a[j];
		a[j] = temp;
	}
	static int [] findNextlargest(int [] a){
		int n = a.length;
		int i=0;
		for(i = n-1;i>0;i--){
			if(a[i-1] < a[i]){
				break;
			}
		}
		if(i==0){
			System.out.println("Not possible");
		}
		int d = a[i-1];
		int minIndex = i;
		for(int j = i+1;j<n;j++){
			if(a[j]> d && a[j]<a[minIndex]){
				minIndex = j;
			}
		}
		
	    swap(a,(i-1),minIndex);
	    Arrays.sort(a, i, n);
		
		return a;
	}

}
