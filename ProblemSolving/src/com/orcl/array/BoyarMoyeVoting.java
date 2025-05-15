package com.orcl.array;

/**
 * https://leetcode.com/problems/majority-element/solutions/6702359/easy-boyer-moore-voting-algo-cpp-java-python-optimal-100/?envType=study-plan-v2&envId=top-interview-150
 */
public class BoyarMoyeVoting {

    public static void main(String[] args) {
        System.out.println(findMajority(new int[] {2,3,4,5,2,2,1,2,2}));
        System.out.println(findMajority(new int[] {2,4,2,2,2,2,2,1,3}));
        System.out.println(findMajority(new int[] {1,1,4,5,4,2,4}));
    }

    /**
     * Assumption is the majority element will always be there
     * add up majority element if something else decreament , if count reached to 0 , start counting again
     * majority count always > n/k where k = 2 to n
     * @param nums
     * @return
     */
    private static int findMajority(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        // check if the array is valid
        int freq =0;
        for (int num : nums){
            if(num == candidate){
                freq++;
            }
        }
        return freq > nums.length / 2 ? candidate : -1;
    }
}
