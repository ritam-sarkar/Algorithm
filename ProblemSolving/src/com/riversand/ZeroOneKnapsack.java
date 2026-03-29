package com.riversand;

/**
 * https://www.youtube.com/watch?v=sVAB0p58tlg
 */
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        knapsack(wt, val, W, wt.length);
    }
    private static void knapsack(int[] wt, int[] val, int capacity, int n) {
        // row wise 0 to n , n = number of items , total n+1 row
        // column wise 0 to capacity , total capacity+1 column

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            //sow means sum of weight
            for (int sow = 0; sow <= capacity; sow++) {
                // fill first row and first column as 0 for all rows
                if (i == 0 || sow == 0) {
                    dp[i][sow] = 0;
                } else if (wt[i - 1] <= sow) {
                    //dp[i-1] means previous row of the table
                    // val[i-1] and wt[i-1] are the current weights and values
                    //max(currVal + prev row's column number = sow - currWeight , prev row's same column's value)
                    dp[i][sow] = Math.max(
                            val[i - 1] + dp[i - 1][sow - wt[i - 1]],
                            dp[i - 1][sow]
                    );
                } else {
                    dp[i][sow] = dp[i - 1][sow];
                }
            }
        }

        // Maximum value
        System.out.println("Maximum value = " + dp[n][capacity]);

        // 🔍 Backtrack to find selected items
        int w = capacity;
        System.out.println("Selected items (index, weight, value):");

        // Traverse start from right bottom
        for (int i = n; i > 0 && w > 0; i--) {
            // If value comes from including the item
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println(
                        "Item " + (i - 1) +
                                " (wt=" + wt[i - 1] +
                                ", val=" + val[i - 1] + ")"
                );

                // Reduce remaining weight
                w = w - wt[i - 1];
            }
        }
    }
}
