package com.orcl.array;
/**
 * Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 * @author ritsarka
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
      String[] strs = {"flower","flow","flight"};
      String[] strs2 = {"a"};
	  System.out.println(longestCommonPrefix(strs2));	
	}
     public static String longestCommonPrefix(String[] strs) {
        
    	 StringBuilder sb = new StringBuilder();
    	 int n = strs.length;
    	 if(n == 0) {
    		 return "";
    	 }
    	 int pos =0;
    	 while(true) {
    		 if(strs[0].isEmpty()) {
    			 return sb.toString();
    		 }
    		 if(pos >= strs[0].length()) {
    			 return sb.toString();
    		 }
    		 char c = strs[0].charAt(pos);
    		 for(int i=1;i<n;i++) {
    			 if(strs[i].isEmpty() || pos >= strs[i].length()) {
        			 return sb.toString();
        		 }
    			 if(c != strs[i].charAt(pos)) {
    				 return sb.toString();
    			 }
    		 }
    		 sb.append(c);
    		 pos++;
    	 }
    }

}
