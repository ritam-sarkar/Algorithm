package com.gs.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the unique tuples of size k
 * tuple means consecutive not subarray
 *
 */
public class UniqueTuplesK {
    public static Set<String> uniqueTuples(String s, int k) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            result.add(s.substring(i, i + k));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniqueTuples("aaab", 2)); // [aa, ab]
        System.out.println(uniqueTuples("aabbcc", 2)); // [aa, ab, bb, bc, cc]
        System.out.println(uniqueTuples("aabbcc", 3)); // [aab, abb, bbc, bcc]
        System.out.println(uniqueTuples("abcabc", 3)); // [abc, bca, cab]
        System.out.println(uniqueTuples("abcabc", 4)); // [abca, bcab, cabc]
    }
}
