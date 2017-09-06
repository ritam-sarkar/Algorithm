/**
 * 
 */
package sort;

import util.Utility;

/**
 * @author Ritam
 *
 */
public class BubbleSort {
	
	public void sort(int[] arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			for(int j =0;j<n-i-1;j++){
				if(arr[j+1]< arr[j]){
					int temp = arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

}
