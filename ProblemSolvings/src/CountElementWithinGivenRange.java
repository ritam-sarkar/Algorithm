/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class CountElementWithinGivenRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      int[] arr = {2,6,4,9,10,15,11,5};
      findElements(sort(arr),6,11);
      
	}

	private static void findElements(int[] sort, int i, int j) {
		int lowerIndex = findLowerIndex(sort,i);
		int upperIndex = findUpperIndex(sort,j);
		System.out.println("no of elents "+(upperIndex-lowerIndex+1));
		
	}
    private static int findUpperIndex(int[] sort, int j) {
    	
		return findPos(sort, j, 0, sort.length-1);
	}

	private static int findLowerIndex(int[] sort, int i) {
		return findPos(sort, i, 0, sort.length-1);
	}

	//bubble sort
	private static int[] sort(int[] a) {
		int n = a.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<(n-i-1);j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] =a[j+1];
					a[j+1]=temp;
				}
			}
		}
		return a;
	}
	//binary search
	private static int findPos(int arr[],int x,int start,int end){
		
		while(start != end){
			int mid = (start+end)/2;
			if(arr[mid] == x){
				return mid;
			}else if(x < arr[mid]){
				end = mid-1;
			}else if (x > arr[mid]){
				start = mid+1;
			}
		}
		return -1;
		
	}
	

}
