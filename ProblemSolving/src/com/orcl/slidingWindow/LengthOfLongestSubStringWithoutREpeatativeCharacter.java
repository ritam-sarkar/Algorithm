package com.orcl.slidingWindow;

/**
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
import java.util.*;

public class LengthOfLongestSubStringWithoutREpeatativeCharacter {

	public static void main(String[] args) {
       System.out.println(lengthOfLongestSubstring("pwwkew"));
       System.out.println(lengthOfLongestSubstring("bbbbb"));
       System.out.println(lengthOfLongestSubstring("abcabcab"));
	}
	public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] pos = new int[128];
        Arrays.fill(pos,-1);
        int start = 0;
        int i =0;
        for (; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(pos[curr] >= start){
                result = Math.max(result, i - start);
                start = pos[curr] + 1;
            }
            pos[curr] = i;
        }
        // for the last element len not calculated
        result =  Math.max(result, i - start);
        return result;
    }

}
