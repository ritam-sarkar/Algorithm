package com.orcl.util;

import java.util.LinkedList;

public class ArrayUtil {

	public static void swap(int[] a, int pos1,int pos2){
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] =temp;
	}
	public static void swap(char[] a, int pos1,int pos2){
		char temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] =temp;
	}
	public static void traverse(int a[]){
		if(a != null){
			System.out.println();
			for(int i=0;i<a.length;i++){
				System.out.print(" "+a[i]);
			}
		}
	}
	public static void traverse(char a[]){
		if(a != null){
			System.out.println();
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
		}
	}
	public static void removeDuplicates(int [] a){
		int n = a.length;
		int b[] = new int[n];
		int j =0;
		for(int i=0;i<n;i++) {
			if(i+1 == n) {
				b[j++] = a[i];
			}else if(a[i+1]-a[i] != 0) {
				b[j++] = a[i];
			}
		}
		a=b;

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
