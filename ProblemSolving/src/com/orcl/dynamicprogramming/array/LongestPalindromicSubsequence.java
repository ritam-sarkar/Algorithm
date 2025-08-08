package com.orcl.dynamicprogramming.array;


public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequenceLength("BBABCBCAB")); // 7
        System.out.println(longestPalindromicSubsequenceLength("ACBBA")); // 4 ABBA
    }

    public static int longestPalindromicSubsequenceLength(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if(i + 1 <= j - 1){
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}

