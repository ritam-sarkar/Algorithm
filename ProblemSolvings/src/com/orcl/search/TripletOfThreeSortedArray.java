package com.orcl.search;
/**
 *  Given 3 arrays find triplet where p <= q , q>=r where 
 *  p belongs to a array, q belongs to b array, r belongs to c array
 *  (3,5,7) (3,6) (4,6,9)
 * Output : (3,6,4) (3,6,6) (5,6,4) (5,6,6)
 * @author ritsarka
 *
 */
public class TripletOfThreeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1,3,5};
		int b[] = {2,3};
		int c[] = {1,2,3};
		int na= a.length; int nb = b.length; int nc = c.length;
		na = removeDuplicates(a);
		nb = removeDuplicates(b);
		nc = removeDuplicates(c);
		findTriplete(a,b,c);
	}

	private static int removeDuplicates(int[] arr) {
		
		int j=0;int n = arr.length;
		for(int i=0;i<n-1;i++) {
			if(arr[i] != arr[i+1]) {
				arr[j++] = arr[i];
			}
		}
		arr[j++] = arr[n-1];	
		return j;
	}

	private static void findTriplete(int[] a, int[] b, int[] c) {

		int na= a.length; int nb = b.length; int nc = c.length;
		na = removeDuplicates(a);
		nb = removeDuplicates(b);
		nc = removeDuplicates(c);
		int q=0; 
		int count =0;
		
		while(q < nb) {
			int p=0; int r=0;
			
			for(int i=0;i<na;i++) {
				if(a[i] <= b[q]) {
					p++;
				}
			}
			for(int i=0;i<nc;i++) {
				if(c[i] <= b[q]) {
					r++;
				}
			}
			count += (p*r);
			q++;
		}
		System.out.println("Total count " + count);
	}	
	

}
