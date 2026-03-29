package com.orcl.array;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnaGram("a","ab"));
        System.out.println(isAnaGram("aa","bb"));
        System.out.println(isAnaGram("anagram","nagaram"));
    }
    private static boolean isAnaGram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

}
