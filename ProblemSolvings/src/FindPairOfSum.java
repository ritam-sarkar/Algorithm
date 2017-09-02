import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindPairOfSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a [] = {1,4,5,2,10};
		int [] b = {14,3,9,5,1};
		int c[] = {3,4,10,9,4,1};
		findPair(c,8);
	}

	private static void findPair(int[] a,int sum) {
		List<Integer> complements = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			if(!complements.contains((sum - a[i]))){
				complements.add(a[i]);
			}else{
				System.out.println(" numbers are "+a[i]+" , "+(sum-a[i]));
			}
		}
		
	}

}
