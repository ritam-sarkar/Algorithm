package com.orcl.slidingWindow;

/**
 *  In "aaabbccddd", the substring "aaa" is a uniform substring of 'a', and "ddd" is a uniform substring of 'd'.
 *
 * The problem is to find the length and possibly the substring itself of the longest uniform substring in a given string.
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

public class LongestUnifomSubstring {
    public static void main(String[] args) {
        System.out.println(test("abbbccda"));
        System.out.println(test("aaabbccddd"));
        System.out.println(test("aaabbccddde"));
        System.out.println(test("abc"));
        System.out.println(test("a"));
        System.out.println(test(""));
    }
    private static String longestUniformSubstring(String s){
        if (s == null || s.isEmpty()) {
            System.out.println("String is empty");
            return null;
        }

        char maxChar = s.charAt(0);
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxChar = s.charAt(i - 1);
                }
                currentLength = 1;
            }
        }

        // Check at the end in case the longest is at the end
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxChar = s.charAt(s.length() - 1);
        }
        System.out.println("Length: " + maxLength);
        return String.valueOf(maxChar).repeat(maxLength);
    }
    private static int test(String s){
        int start = 0;
        int end = 0;
        int currSum = 0;
        int maxSum = 0;

        for (int i=0;i<s.length();i++){
            if(s.charAt(start) == s.charAt(end)){
                end++;
                currSum = end-start;
            } else {
               currSum = end-start;
               maxSum = Math.max(maxSum,currSum);
               start = i;
               end = i;
            }
        }
        return Math.max(currSum,maxSum);

    }
}
