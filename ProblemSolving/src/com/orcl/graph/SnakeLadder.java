package com.orcl.graph;

import java.util.HashSet;
import java.util.Set;

public class SnakeLadder {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Step 1: Flatten board (1-based index)
        int[] arr = new int[n * n + 1];
        int idx = 1;
        boolean leftToRight = true;

        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    arr[idx++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    arr[idx++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }

        // Step 2: BFS using array queue (faster than LinkedList)
        Set<Integer> visited = new HashSet<>();
        int[] queue = new int[n * n + 1];

        int front = 0, rear = 0;
        queue[rear++] = 1;
        visited.add(1);

        int moves = 0;

        while (front < rear) {
            int size = rear - front;

            for (int i = 0; i < size; i++) {
                int curr = queue[front++];

                if (curr == n * n) return moves;

                for (int d = 1; d <= 6 && curr + d <= n * n; d++) {
                    int next = curr + d;

                    // Jump if snake/ladder exists
                    if (arr[next] != -1) {
                        next = arr[next];
                    }

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue[rear++] = next;
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board));
    }
}
