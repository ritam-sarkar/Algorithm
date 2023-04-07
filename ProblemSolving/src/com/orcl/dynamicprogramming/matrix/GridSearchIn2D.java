package com.orcl.dynamicprogramming.matrix;

/**
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 * @author ritsarka
 *
 */
public class GridSearchIn2D {

	public static void main(String[] args) {

		int G[][] =    {{1,2,3,4,5,6,7,8,9,0},  
				        {0,9,8,7,6,5,4,3,2,1},  
				        {1,1,1,1,1,1,1,1,1,1},  
				        {1,1,1,1,1,1,1,1,1,1},  
				        {2,2,2,2,2,2,2,2,2,2}
				       };
		/*int P[][] =    {
			           {8,7,6,5,4,3},  
			           {1,1,1,1,1,1},  
			           {1,1,1,1,1,1}				
		               };*/
		int P[][] = {
				     {2,3,4},
				     {9,8,7}
		            };
		
		System.out.println(gridSearch(G, P));		
		
	}
	private static String gridSearch(int[][] G, int[][] P) {
		for(int i = 0; i<G.length - P.length; i++) {
			for(int j=0;j<G[0].length - P[0].length; j++) {
				boolean flag = true;
				for(int k = 0;k<P.length; k++) {
					for(int l =0;l<P[0].length; l++) {
						if(G[i+k][j+l] != P[k][l]) {
							flag = false;
						}
					}
					if(!flag) {
						break;
					}
				}
				if(flag) {
					return "POSSIBLE";
				}
			}
		}
		return "IMPOSSIBLE";
	}

}
