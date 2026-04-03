package com.orcl.graph;

/**
 * https://leetcode.com/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class Boundary {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark boundary-connected 'O' as 'T'
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);       // left boundary
            dfs(board, i, n - 1);   // right boundary
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);       // top boundary
            dfs(board, m - 1, j);   // bottom boundary
        }

        // Step 2 & 3: Flip and restore
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // captured
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // restore
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }

        // Mark as safe
        board[i][j] = 'T';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        new Boundary().solve(board);
        System.out.println(board);

    }
}
