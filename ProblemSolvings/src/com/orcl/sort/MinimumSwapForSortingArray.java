package com.orcl.sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumSwapForSortingArray {

	public static void main(String[] args) {

		int arr1[] = {7,1,3,2,4,5,6};
		int arr2[] = {4,3,1,2};
		int arr3[] = {1,3,5,2,4,6,7};
		int arr4[] = {4,2,3,1};
		System.out.println(calculateMinimumSwap(arr1));
		System.out.println(calculateMinimumSwap(arr2));
		System.out.println(calculateMinimumSwap(arr3));
		System.out.println(calculateMinimumSwap(arr4));
	}
	static int calculateMinimumSwap(int[] arr) {
		int swap = 0;
		int n = arr.length;
		Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
		int k =0;
		List<Pair> pairs = new ArrayList<Pair>();
		for(int i =0;i<n;i++) {
			pairs.add(new Pair(arr[i], i));
		}
		Collections.sort(pairs, new PairComparator());
		for(int i=0;i<n;i++) {
			if(pairs.get(i).getPos() != i) {				
				int toIndex = pairs.get(pairs.get(i).getPos()).getPos();
				if(visited.get(toIndex) == null || !visited.get(toIndex)) {
					swap++;
					visited.put(pairs.get(i).getPos(), true);
				}				
			}
		}
		return swap;
	}
	static class Pair{
		private int key;
		private int pos;
		public Pair(int key, int pos) {
			super();
			this.key = key;
			this.pos = pos;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public int getPos() {
			return pos;
		}
		public void setPos(int pos) {
			this.pos = pos;
		}
		
	}
	static class PairComparator implements Comparator<Pair>{

		@Override
		public int compare(Pair o1, Pair o2) {
			Pair p1 = (Pair)o1;
			Pair p2 = (Pair)o2;
			return p1.key - p2.key;
		}
		
	}

}
