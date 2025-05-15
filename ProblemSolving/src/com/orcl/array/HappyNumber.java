package com.orcl.array;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int actualNumber = 2;
        /*int n = actualNumber;
        Set<Integer> set = new HashSet<>();
        while(n != 1){
           int digitSum =  findDigitSum(n);
           n = digitSum;
           if(set.contains(n)){
               break;
           } else {
               set.add(digitSum);
           }
           System.out.println(digitSum);
        }
        System.out.println("n is happy "+(n==1));*/
        int slow= actualNumber , fast=actualNumber;
        while(true){
            slow=findDigitSum(slow);
            fast=findDigitSum(findDigitSum(fast));
            System.out.println("slow "+slow+" fast "+fast);
            if(slow == fast)
                break;
        }
        System.out.println((slow ==1));

    }
    private static int findDigitSum(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum+=(rem*rem);
            n/=10;
        }
        return sum;
    }
}
