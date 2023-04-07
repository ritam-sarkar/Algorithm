package com.orcl.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/josephus-problem/
 */
public class JosephasProblem {
    public static void main(String[] args) {
        System.out.println(josephas(7,3));
    }

    private static int josephas(int n, int k) {

        List<Integer> josepthList = new ArrayList<>();
        for (int i=0;i<n;i++){
           josepthList.add(i+1);
        }
        int start = 0;
        while (josepthList.size() > 1){
            int removeIndex = (start+k-1)%josepthList.size();
            josepthList.remove(removeIndex);
            start = removeIndex;
        }
        return josepthList.get(0);

    }



}
