package com.orcl.miscelineous;

/**
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class HIndex {
    public static void main(String[] args) {
        //System.out.println(hIndex(new int [] {1,3,1}));
        System.out.println(hIndex(new int [] {3,0,6,1,5}));
    }

    private static int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
