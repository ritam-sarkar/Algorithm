/**
 * 
 */
package search;

/**
 * @author Ritam
 *
 */
public class BinarySearch {

	int arr[];
	public BinarySearch(int[] a){
		arr = a;
	}
	
	public int anyOccurance(int x){
		int low = 0;
		int high = arr.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(x == arr[mid]){
				return mid;
			}else if(x < arr[mid]){
				high = mid-1;
			}else if( x> arr[mid]){
				low = mid+1;
			}
		}
		return -1;
	}
	public int firstOcc(int x){
		int low =0;
		int high = arr.length-1;
		int result =-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(x == arr[mid]){
				result = mid;
				high = mid-1;
			}else if(x < arr[mid]){
				high = mid-1;
			}else if( x> arr[mid]){
				low = mid+1;
			}
		}
		return result;
	}
	public int lastOcc(int x){
		int low =0;
		int high = arr.length-1;
		int result =-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(x == arr[mid]){
				result = mid;
				low = mid+1;
			}else if(x < arr[mid]){
				high = mid-1;
			}else if( x> arr[mid]){
				low = mid+1;
			}
		}
		return result;
	}
	public int countOcc(int x){
		int firstocc = this.firstOcc(x);
		int lastocc =  this.lastOcc(x);
		return lastocc-firstocc+1;
	}
	
	
}
