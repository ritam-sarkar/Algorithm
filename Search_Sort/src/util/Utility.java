/**
 * 
 */
package util;

/**
 * @author Ritam
 *
 */
public class Utility {
	
	
	public static void  swap(int a, int b){
		int temp = a;
		a=b;
		b=temp;
	}
	public static int[] sortableArray(String sort){
		
		int [] arr = null;
		
		switch(sort){
		   case "bubav": 
			   arr = new int[]{4,2,6,7,3,11,10,9,13,14,5,18};
			   break;
		   case "bubworse":
			   arr = new int[]{12,11,10,9,8,7,6,5,4,3,2,1};
			   break;
		   case "bubbest":
			   arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
			   break;
		   case "mergeav": 
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;
		   case "mergeworse":
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;
		   case "mergebest":
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;	
		   case "selgeav": 
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;
		   case "selworse":
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;
		   case "selbest":
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;	
		   default:
			   arr = new int[]{8,7,6,5,4,3,2,1};
			   break;
		   	   
			   
		}
		
		return arr;
	}
	

}
