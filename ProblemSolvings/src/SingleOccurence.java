/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class SingleOccurence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 1, 2, 2, 3, 3, 4,50,50, 65,65};
		int i=0;
		while(i<arr.length){
			if(i+1 < arr.length && arr[i] != arr[i+1]){
				System.out.println(arr[i]);
				i++;
			}else{
				i+= 2;
			}
		}		
	}

}
