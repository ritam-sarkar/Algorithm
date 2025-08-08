package com.gs.easy;

public class DotProduct {
    public static void main(String[] args) {
        System.out.println(dotProduct(new int[] {1,2}, new int[] {2,3}));
        System.out.println(dotProduct(new int[] {1,2, 4}, new int[] {2,3,4}));
        System.out.println(dotProduct(new int[] {}, new int[] {}));
        System.out.println(dotProduct(new int[] {1, 3}, new int[] {1}));
        System.out.println("--------------matrix multiplication -----------------");
        int[][] arr1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arr2 = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(matrixMultiply(arr1,arr2));
    }
    private static int dotProduct(int[] arr1 , int[] arr2){
        int sum = 0;
        if(arr1.length != arr2.length){
            return -1;
        } else {
            int n = arr1.length;
            for (int i=0;i<n;i++){
                sum = sum + arr1[i]* arr2[i];
            }
        }
        return sum;
    }

    /**
     * formulae is (i,j) = (i,k) * (k,j)
     * i = 0 to r1-1 , j = 0 to c2-1 and k = 0 to cross -1
     */
    private static int[][] matrixMultiply(int[][] mat1 , int[][] mat2) {
        if(mat1[0].length != mat2.length){
            throw  new IllegalArgumentException("Invalid size of array");
        }
        int row = mat1.length;
        int col = mat2[0].length;
        int cross = mat1[0].length;
        int result[][] = new int[row][col];

        for (int i=0; i<row;i++){
            for (int j =0; j < col; j++){
               for(int k = j; k < cross ; k++){
                   result[i][j] = result[i][j] + mat1[i][k] * mat2[k][j];
               }
            }
        }
        return result;
    }
}
