/**
 * Sample Input 1
*
*   55 3 45 33 25
*   Sample Output 1
*
*   55+3-45*33-25  is devisible by 101
*   output =1
*   
*   
*   All operators have same precedence order and left associativity,
*   
 */


package number.reccursive;

import java.util.Stack;

public class ExpressionCombination {

	public static void main(String[] args) {
		int arr[] = {55,3,45,33,25};
		System.out.println(checkReccursively(arr,0,0));
		
	}
	public static int checkReccursively(int[] arr,int pos,int currentSum){
		int result =0;
		if(pos == arr.length-1){
			if((currentSum+arr[pos])%101 == 0){				
				result ++;
				
			}
			if((currentSum-arr[pos])%101 == 0){
				result ++;
			}
			if((currentSum*arr[pos])%101 == 0){
				result ++;
			}
		}else{
			result += checkReccursively(arr,pos+1,currentSum+arr[pos]);
			if(pos > 0){
				result += checkReccursively(arr,pos+1,currentSum-arr[pos]);
				result += checkReccursively(arr,pos+1,currentSum*arr[pos]);
			}			
		}		
		return result;
		
	}
}
