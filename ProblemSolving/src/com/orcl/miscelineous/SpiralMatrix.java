package com.orcl.miscelineous;

import java.util.*;
public class SpiralMatrix {
    public static void main(String[] args) {

        print(spiralOrder(new int [][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        }));
    }
    public  static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) return result;
        int rs = 0; //row start
        int re = mat.length-1; // row end
        int cs = 0; // column start
        int ce = mat[0].length -1; // column end
        while(rs <= re && cs <= ce){
            // Top row
            for(int i=cs; i<=ce; i++){
                result.add(mat[rs][i]);
            }
            rs++;

            // Right edge
            for (int i=rs; i<=re;i++){
                result.add(mat[i][ce]);
            }
            ce--;

            // Bottom row
            // when no of col  > no of row has to put the checking to avoid recounting internal cell
            if(rs <= re){
                for (int i=ce; i>=cs; i--){
                    result.add(mat[re][i]);
                }
                re--;
            }
            // Left edge
            // when no of row  > no of col has to put the check to avoid recounting internal cell
            if(cs <= ce){
                for(int i=re; i>=rs;i--){
                    result.add(mat[i][cs]);
                }
                cs++;
            }

        }
        return result;
    }

    private static void print(List<Integer> list){
        list.forEach(e -> System.out.println(e+" "));
    }

}
