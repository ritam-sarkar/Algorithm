package com.orcl.miscelineous;

import java.util.*;
public class SpiralMatrix {
    public static void main(String[] args) {

       print(spiralOrder(new int [][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        }));
        print(spiralOrder(new int [][] {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9,10}
        }));

        print(spiralOrder(new int [][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        }));
    }
    public  static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        int startRow =0;
        int endRow = mat.length-1;
        int startColumn = 0;
        int endColumn = mat[0].length-1;
        while(startRow<=endRow && startColumn <= endColumn){

            //Top row
            for(int i=startColumn; i<=endColumn;i++){
                result.add(mat[startRow][i]);
            }
            // right edge
            for(int i=startRow+1;i<=endRow;i++){
                result.add(mat[i][endColumn]);
            }
            // bottom edge
            if(startRow != endRow){
                for(int i=endColumn-1;i>=startColumn;i--){
                    result.add(mat[endRow][i]);
                }
            }
            // left edge
            if(startColumn != endColumn){
                for(int i=endRow-1;i>startRow;i--){
                    result.add(mat[i][startColumn]);
                }
            }
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }
        return result;
    }

    private static void print(List<Integer> list){
        list.forEach(e -> System.out.print(e+" "));
        System.out.println();
    }

}
