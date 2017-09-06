import search.BinarySearch;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class ExecuteSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = new int[]{1,2,3,4,5,5,5,7,9,10};		
		BinarySearch binSearch = new BinarySearch(a);
		System.out.println(" any occurance index "+binSearch.anyOccurance(5));
		System.out.println(" first occurance index "+binSearch.firstOcc(5));
		System.out.println(" last occurance index "+binSearch.lastOcc(5));
		System.out.println(" total occurance "+binSearch.countOcc(5));
	}

}
