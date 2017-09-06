/**
 * 
 */
package sort;

/**
 * @author Ritam
 *
 */
public class QuickSort {
	
	public void sort(int[] arr,int start, int end){
		
	if(!(start>=end)){
		int partionIndex = partition(arr,start,end);
		sort(arr,start,(partionIndex-1));
		sort(arr,(partionIndex+1),end);
	}
		
	}
	private int partition(int[] arr, int start, int end){
		
		int pivot = arr[end];
		int partIndex = start;
		for(int i = start ; i< end;i++){
			if(arr[i]<= pivot){
				int temp = arr[i];
				arr[i] = arr[partIndex];
				arr[partIndex] = temp;
				partIndex++;
			}
		}
		int temp = arr[end];
		arr[end] = arr[partIndex];
		arr[partIndex] = temp;
		return partIndex;
	}

}
