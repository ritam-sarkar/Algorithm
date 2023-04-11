package com.orcl.array;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{2,2,6,7,1,4,5,8,3}));
        //System.out.println(maxArea(new int[]{1,1}));
    }
    private static int maxArea(int[] height) {
        int n = height.length;
        int p = 0;
        int q = n-1;
        int area = 0;
        while(p < q){
            int currentArea = Math.min(height[p],height[q]) * (q-p);
            if(currentArea > area){
                area = currentArea;
            }
            if(height[p] > height[q]){
                q --;
            } else if(height[p] < height[q]){
                p++;
            } else {
                p++;
                q--;
            }
        }
        return area;
    }
}
