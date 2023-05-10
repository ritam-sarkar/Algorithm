package com.orcl.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KMedoidProblem {

    public static void main(String[] args) {
        int arr[] = {11,5,3,12,6,8,1,7,4};
        int n = arr.length;
        Arrays.sort(arr);
        double minMedoid = arr[0];
        double maxMedoid = arr[n-1];
        double midMedoid = arr[n/2];
        Set<Integer> visited = new HashSet<>();
        visited.add(arr[0]);
        visited.add(arr[n-1]);
        visited.add(arr[n/2]);
        int minMax = 0;
        int maxMax = 0;
        int midMax = 0;

        for (int i =1;i<n;i++){
            if(!visited.contains(arr[i])){
                double minDistance = Math.abs(arr[i] - minMedoid);
                double maxDistance = Math.abs(arr[i] - maxMedoid);
                double midDistance = Math.abs(arr[i] - midMedoid);
                if(minDistance < maxDistance && minDistance < midDistance){
                    
                }
            }
        }
    }
}
