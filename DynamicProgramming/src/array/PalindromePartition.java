package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

First array number of split 1
second array number of split 2
Minimum number of split = 1

For liril means complete palindrome minimum number of split = 0 
 * @author ritsarka
 *
 */
public class PalindromePartition {

	public static void main(String[] args) {
     
		 String s = "alirilb";
		 boolean[][] dp = palindrom(s);
		 List<List<String>> res = new ArrayList<>();
		 // Find all possible palindromes
		 find(dp,0,s,new ArrayList(),res);
		 System.out.println(res);
		 
		 // Find minimum number of cuts required
		 
		 int[][] result = findMinimumCuts(dp,s);
		 System.out.println("Minimum no of cuts "+result[0][s.length()-1]);
		 
	}
	private static int[][] findMinimumCuts(boolean[][] dp, String s) {
		int n = s.length();
		int[][] result = new int[n][n];
		for(int len =2; len<=n; len++) {
        	for(int row =0;row<n;row++) {
        		int col = row+len-1;
        		if(col <n) {
        			if(dp[row][col]) {
        				result[row][col] =0;
        			} else {
        				int k =row;
        				int min = Integer.MAX_VALUE;
        				while(k < col) {
        					min = Math.min(min, result[row][k] + result[k+1][col]);
        					k++;
        				}
        				result[row][col] = 1+min;
        			}        			
        		}        		
        	}
		}	
		return result;
	}
	public static boolean[][] palindrom(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int len =1; len<=n; len++) {
        	for(int row =0;row<n;row++) {
        		int col = row+len-1;
        		if(col <n) {
        			if(len ==1) {
            			dp[row][col] = true;
            		}else if(len==2){
            			dp[row][col] = s.charAt(row) == s.charAt(col);
            		} else {
            			dp[row][col] = s.charAt(row) == s.charAt(col) ? dp[row+1][col-1] : false;
            		}
        		}        		
        	}
        }
        return dp;
    }
    private static void find(boolean[][] dp, int st, String s, List<String> cres, List<List<String>> res){
        if(st==s.length()){
            res.add(new ArrayList(cres));
            return;
        }
        for(int e=st; e<s.length(); e++){
            if(dp[st][e]){
                cres.add(s.substring(st, e+1));
                find(dp, e+1, s, cres, res);
                cres.remove(cres.size()-1);
            }
        }
    }

}
