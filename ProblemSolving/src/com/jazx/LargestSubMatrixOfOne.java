package com.jazx;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/1723562510/
 */
public class LargestSubMatrixOfOne {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println("Max Area of Submatrix of 1’s: " + maximalRectangle(matrix)); // Output: 6
        System.out.println("Max are largest historgram "+largestRectangleArea2(new int[] {2,4}));
    }

    private static int maximalRectangle(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int[] row : matrix) {
            // Update heights for histogram
            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == 0 ? 0 : heights[i] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        // stack will contain the array index only and extend will contain the actual array copy
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int currHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
    private static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i <= n ; i++){
            while(!dq.isEmpty() && (i==n || heights[dq.getLast()] >= heights[i])){
                int h = heights[dq.pollLast()];
                int w = dq.isEmpty() ? i : i - dq.getLast()-1;
                maxArea = Math.max(maxArea,h*w);
            }
            dq.addLast(i);
        }
        return maxArea;
    }


}
