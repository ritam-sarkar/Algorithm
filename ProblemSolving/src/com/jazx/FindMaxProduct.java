package com.jazx;

public class FindMaxProduct {

    public static void main(String[] args) {

        System.out.println(findMaxProduct(new int[] {-10 , -4 , 16 , 2 , 10 , 6}));
        System.out.println(findMaxProduct(new int[] {4 , -4 , 6 , -6 , 1 , -2}));
        System.out.println(findMaxProduct(new int[] {4 , -4 , 3 , -6 , 1 , -2}));
    }

    private static int findMaxProduct(int[] arr){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i : arr){
           if(i >= max1){
               max2 = max1;
               max1 = i;
           } else if(i >= max2){
               max2 = i;
           }
           if(i <= min1){
               min2 = min1;
               min1 = i;
           } else if(i <= min2){
               min2 = i;
           }
        }
        return Math.max((min1 * min2) ,(max1 * max2));
    }

}


