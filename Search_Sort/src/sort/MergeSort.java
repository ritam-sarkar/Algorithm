package sort;
/**
 * 
 */

/**
 * @author Ritam
 *
 */

public class MergeSort {
	
	public void sort(int[] arr){
		
		
		int n = arr.length;
		if(n<2)
			return;
		int mid = n/2;
		int nL = mid;
		int nR = n-mid;
		int left[]= new int[nL];
		int right[] = new int[nR];
		
		
		for(int i = 0;i< nL;i++){
			left[i] = arr[i];
		}
		for(int j = mid;j<n; j++){
			right[j-mid] = arr[j];
		}
		
		sort(left);
		sort(right);
		merge(left,right,arr);
	}

	private void merge(int[] left, int[] right, int[] finalArr) {
		int nL = left.length;
		int nR = right.length;
		int i=0;
		int j =0;
		int k =0;
		
		while(i < nL && j < nR){
			if(left[i] <= right[j]){
				finalArr[k]= left[i]; 
				i++;
			}
			else{
				finalArr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i< nL){
			finalArr[k] = left[i];
			i++;
			k++;
			
		}
		while(j< nR){
			finalArr[k] = right[j];
			j++;
			k++;
			
		}
		
	}
	
	
}
