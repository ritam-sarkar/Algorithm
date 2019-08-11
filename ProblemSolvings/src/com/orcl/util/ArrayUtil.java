package com.orcl.util;

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
	

}
