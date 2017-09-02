/**
 * 
 * Input  : 1 5 7 2 9 14
Output : 13
The groups of two that can be 
formed are:
(1, 5)
(5, 7)
(1, 2)
(2, 7)
(1, 14)
(7, 14)
The groups of three are:
(1, 5, 9)
(5, 7, 9)
(1, 2, 9)
(2, 7, 9)
(2, 5, 14)
(1, 9, 14)
(7, 9, 14)

Input  : 3 6 9 12
Output : 10
All groups of 2 and 3 are valid.
 * 
 */

/**
 * @author Ritam
 *
 */
public class GroupDivisibility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] a = {1,3,5,0,8,4,6};
      noOfCombination(a);
	}
	/**
	 * c[0] divisible by 3
	 * c[1] reminder 1 after %3
	 * c[2] reminder 2 after %3
	 * @param arr
	 */
	private static void  noOfCombination(int[] arr){
		int c [] = new int[3];
		for(int i=0;i<arr.length;i++){
			++c[arr[i]%3];
		}
		System.out.println(c[0] +" "+c[1]+" "+c[2]);
		int groupof2 = c[1] * c[2] + c[0] * (c[0] - 1) / 2;
		int groupof3 = c[0]*(c[0]-1)*(c[0]-2)/6 + c[1]*(c[1]-1)*(c[1]-2)/6 + c[2]*(c[2]-1)*(c[2]-2)/6 + c[0]*c[1]*c[2];
		
		System.out.println(" group of 2 "+groupof2);
		System.out.println(" group of 3 "+groupof3);
	}

}
