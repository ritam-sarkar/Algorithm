/**
 * 
 */
package sort;

/**
 * @author Ritam
 *
 */
public class SelectionSort {
	
	public void sort(int [] arr){
		int n = arr.length;
		for(int i =0;i<n;i++){
			
			for(int j = i+1;j<n;j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
	}

}
