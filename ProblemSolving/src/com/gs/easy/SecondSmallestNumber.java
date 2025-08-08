package com.gs.easy;

public class SecondSmallestNumber {
    public static void main(String[] args) {

        System.out.println(secondSmallest(new int[] {5,2,3,1,6,7,9}));
        System.out.println(secondSmallest(new int[] {2,2}));
        System.out.println(secondSmallest(new int[] {0,1}));
    }
    private static int secondSmallest(int[] arr){
        int min = arr[0];
        int secondMin = Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++){
            if(arr[i] < min){
                secondMin = min;
                min = arr[i];
            } else {
                secondMin = Math.min(arr[i],secondMin);
            }
        }
        return secondMin;
    }


}
