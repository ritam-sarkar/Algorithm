import sort.BubbleSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.SelectionSort;
import util.Utility;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class ExecuteSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = 0L;
		long estimatedTime = 0L;
		/**
		 * Merge sort
		 */
		int mergearr[] = Utility.sortableArray("bubworse");
		//int mergearr[] = new int[]{4,2,2,6,7,9,8,3};
		System.out.println("Before merge sort");
		display(mergearr);
		startTime = System.nanoTime();		
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(mergearr);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("estimated time for merge sort "+estimatedTime);
		System.out.println("After merge sort");
		display(mergearr);
		
		/**
		 * Bubble sort
		 */
		
		int bubArr[] = Utility.sortableArray("bubworse");
		//int bubArr[] = new int[]{4,2,2,6,7,9,8,3};
		System.out.println("Before bubble sort");
		display(bubArr);
		startTime = System.nanoTime();	
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(bubArr);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("estimated time for bubble sort "+estimatedTime);
		System.out.println("After bubble sort");
		display(bubArr);
		
		/**
		 * Selection sort
		 */
		
		int selArr[] = Utility.sortableArray("bubworse");
		//int selArr[] = new int[]{4,2,2,6,7,9,8,3};
		System.out.println("Before selection sort");
		display(selArr);
		startTime = System.nanoTime();	
		SelectionSort selectSort = new SelectionSort();
		selectSort.sort(selArr);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("estimated time for selection sort "+estimatedTime);
		
		System.out.println("After selection sort");
		display(selArr);
		
		
		/**
		 * Quick sort
		 */
		
		int quickArr[] = new int[]{7,2,1,6,8,5,3,4};
		//int selArr[] = new int[]{4,2,2,6,7,9,8,3};
		System.out.println("Before quick sort");
		display(quickArr);
		startTime = System.nanoTime();	
		QuickSort quickSort = new QuickSort();
		
		quickSort.sort(quickArr,0,quickArr.length-1);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("estimated time for quick sort "+estimatedTime);		
		System.out.println("After quick sort");
		display(quickArr);
		
		
	}

	private static void display(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
	}

}


