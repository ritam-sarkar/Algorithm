package com.gs.hard;

/**
 * 1)You can only travel either north (up) or east (right).
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement optimalPath() correctly.
 * 4) Here is an example:
 *                                                            ^
 * **                 {{0,0,0,0,5}, New_York (finish)           N
 * **                  {0,1,1,1,0},                         < W   E >
 * **   So_Cal (start) {2,0,0,0,0}}                             S
 * **                                                           v
 * **   The total for this example would be 10 (2+0+1+1+1+0+5).
 * ** our main motive is not find the shortest path , the cost of the path should be large  so that more points can be collected
 *
 */
public class OptimalPath {

    public static void main(String[] args) {

        int[][] grid1 = {
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}
        };
        int[][] grid2 = {
                {0,1,1,0,5},
                {0,0,0,1,0},
                {2,0,0,6,0}
        };

        System.out.println(optimalPath(grid1)); // 10
        System.out.println(optimalPath(grid2)); // 10

    }

    private static int optimalPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        // Start at 6 (bottom-left)
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                int fromBelow = (r + 1 < rows) ? dp[r + 1][c] : 0;
                int fromLeft = (c - 1 >= 0) ? dp[r][c - 1] : 0;
                dp[r][c] = grid[r][c] + Math.max(fromBelow, fromLeft);
            }
        }

        // Return max rocks collected at New_York (top-right)
        return dp[0][cols - 1];
    }

}
