package array.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArrayUtil {
	
	public static void swap(int[] a, int pos1,int pos2){
		int temp = a[pos1];
	    a[pos1] = a[pos2];
	    a[pos2] =temp;
	}
	public static void traverse(int a[]){
		if(a != null){
			for(int i=0;i<a.length;i++){
				System.out.println(a[i]);
			}
		}
	}
	public static int[] removeDuplicates(int [] a){
        
		int b[] = new int[a.length];
		int count =0;
		int j=0;
		for(int i=0;i<a.length-1;i++){
			b[j++]=a[i];
			if(a[i] == a[i+1]){
				i++;
				count++;
			}			
		}
		a = new int[b.length-count];
		int i=0;
		while(b[i] != 0){
			a[i]=b[i];
			i++;
		}
		return a;
		
	}
	public static void traverseList(LinkedList<LinkedList<Integer>> list){
		for(LinkedList<Integer> inner : list){
			if(!inner.isEmpty()){
				System.out.print("( ");
				for(int i : inner){
					System.out.print(i+" ");
				}
				System.out.println(") ");
			}			
		}
	}

}
