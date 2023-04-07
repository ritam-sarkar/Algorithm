package com.orcl.array;

public class SecondSmallestOfRotatedArray {
    public static void main(String[] args) {
        int [] arr = {6,7,1,2,3,4,5};
        int s = 0;
        int e = arr.length-1;
        int mid = (s+e)/2;

        while (s < e){
            if(mid != arr.length-1){
                if(arr[mid] > arr[mid-1] || arr[mid] > arr[mid+1]){
                    if(arr[mid-1] < arr[mid+1]){
                       e = mid-1;
                    } else {
                        s = mid + 1;
                    }
                    mid = (s + e)/2;
                } else {

                }
            }
        }

    }
    private static int  findPrev(int arr[], int i){
       if(i != 0){
           return arr[i-1];
       } else {
           return arr[arr.length-1];
       }
    }
    private static int findNext(int arr[], int i){
        if(i != arr.length-1){
            return arr[i+1];
        } else {
            return arr[0];
        }
    }
}
