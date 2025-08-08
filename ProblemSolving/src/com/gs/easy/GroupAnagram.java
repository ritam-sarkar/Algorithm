package com.gs.easy;

import java.util.*;

/**
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other
 * https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GroupAnagram {
    public static void main(String[] args) {

        //System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        //System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{""}));
    }
    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] arr = new int[26];
            for(int i = 0; i<str.length(); i++){
                int index = str.charAt(i)-'a';
                arr[index]++;
            }
            int hash = Arrays.hashCode(arr);
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
