package com.orcl.slidingWindow;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class StockBuySell {

    public static void main(String[] args) {
        int arr1[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr1));

        int arr2[] = {2,1};
        System.out.println(maxProfit(arr2));

        int arr3[] = {1};
        System.out.println(maxProfit(arr3));

        int arr4[] = {12, 13, 15, 7, 11};
        System.out.println(maxProfit(arr4));

    }

    private static int maxProfit(int[] arr) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int currentProfit = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            currentProfit = arr[i] - min;
            if(profit < currentProfit){
                profit = currentProfit;
            }
        }
        return profit;
    }
}
