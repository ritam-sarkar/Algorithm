package com.orcl.search;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * @author ritsarka
 *
 */
public class ClimbindLeaderBorad {

	public static void main(String[] args) {

		int[] scores = {100,90,90,80,75,60};
		int[] alice = {50,65,77,90,102};
		int rank[] = new int[scores.length];
	    for(int i =0;i<scores.length;i++) {
	    	if(i == 0)
	    		rank[i] = i+1;
	    	else {
	    		if(scores[i-1] == scores[i]) {
	    			rank[i] = rank[i-1];
	    		}else {
	    			rank[i] = rank[i-1]+1;
	    		}
	    	}
	    }
	    Arrays.stream(rank).forEach(System.out::print);
	    System.out.println();
	    for(int i=0;i<alice.length;i++) {
	    	int r = findRank(alice[i],rank,scores);
	    	System.out.println("rank of "+alice[i]+" = "+r);
	    }
		
		
	}

	private static int findRank(int alice, int[] rank, int[] scores) {
		int start = 0;
		int end = scores.length-1;
		int mid =0;
		while(start <= end) {			
			mid = (start+end)/2;
			if(scores[mid] == alice) {
				return rank[mid];
			}else if(alice < scores[mid]) {
				start = mid+1;				
			}else {
				end = mid-1;
			}
		}
		return alice < scores[mid] ? rank[mid]+1 : rank[mid];
		
	}

}
