/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindMissingExtraArrayElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int b[] = {2,4,6,10,14,16};
		int[] a = {2,4,5,6,10,14,16};
      
  	  int pos = findPos(a,b);
  	  System.out.println(pos);

      
	}
    private static int findPos(int[] x, int[] y){
    	if(x.length == y.length){
    		System.out.println(" arrays are equal");
    		return -1;
    	}else{
    		int[] a = x.length > y.length ? x : y;
    		int[] b = x.length < y.length ? x :y;
    		int start = 0;
    		int end = a.length-1;
    		while(end > start){
    			int mid = (start+end)/2;
    			if(a[mid] == b[mid]){
    				start = mid+1;
    			}else{
    				end = mid;
    			}
    		}
    		return start;
    		
     	}   	
    	
    }
	
}
