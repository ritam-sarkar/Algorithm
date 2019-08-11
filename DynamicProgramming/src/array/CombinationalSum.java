/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import array.util.ArrayUtil;

/**
 * @author Ritam
 *
 */
public class CombinationalSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] a = {8,2,6,4,6,8};
      Arrays.sort(a); 
      ArrayUtil.removeDuplicates(a);
      LinkedList<Integer> stack = new LinkedList();
      LinkedList<LinkedList<Integer>> list = new LinkedList();
      combination(a,8,list,stack,0);
      
      ArrayUtil.traverseList(list);      
      
	}

	private static void combination(int[] a, int sum,LinkedList<LinkedList<Integer>> list, LinkedList<Integer> stack, int i) {
		if(sum<0){
			return;
		}else if(sum == 0){
			list.add(stack);
			return;
		}
		while(i<a.length && (sum-a[i])>=0){
			stack.add(a[i]);
			combination(a,sum-a[i],list,new LinkedList(stack),i);
			i++;
			stack.removeLast();
		}		
	}
	

}
