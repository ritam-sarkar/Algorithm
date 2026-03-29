package com.orcl.search;

public class BinarySearchSortedMatrix {
    private static int noColumns =0;
    public boolean searchMatrix(int[][] matrix, int target) {
        noColumns = matrix[0].length;
        int noOfElement = matrix.length * matrix[0].length;
        int start = 0;
        int end = noOfElement - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            int midVal = getValByIndex(matrix , mid);
            if(midVal == target){
                return true;
            } else if(target < midVal){
                end = mid -1;
            } else {
                start = mid +1;
            }
        }
        return false;

    }
    private int getValByIndex(int[][] matrix, int index){
        int rowIndex = index / noColumns;
        int columnIndex = 0;
        if(rowIndex == 0){
            columnIndex = index;
        } else {
            columnIndex = index % noColumns;
        }
        return matrix[rowIndex][columnIndex];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new BinarySearchSortedMatrix().searchMatrix(matrix, 3));
        System.out.println(new BinarySearchSortedMatrix().searchMatrix(matrix, 13));
    }
}
