package com.orcl.array;

import java.util.*;

public class LongestSubStringWithRepeatativeCharacter {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abc"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
    private static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] pos = new int[128];
        Arrays.fill(pos,-1);
        int start = 0;
        int i =0;
        for (; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(pos[curr] >= start){
                // duplicate char found, move left pointer
                result = Math.max(result, i - start);
                start = pos[curr] + 1;
            }
            pos[curr] = i;
        }
        result =  Math.max(result, i - start);
        return result;
    }
}
