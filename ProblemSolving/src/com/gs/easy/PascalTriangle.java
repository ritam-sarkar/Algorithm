package com.gs.easy;

/*Below formation is called Pascals Triangle.
        **
        **  Example:
        **               1
        **              1 1
        **             1 2 1
        **            1 3 3 1
        **           1 4 6 4 1
        **         1 5 10 10 5 1
        **        1 6 15 20 15 6 1
        **
        **  Complete the 'pascal' function below so that given a
        **  col and a row it will return the value in that positon.
        **
        **  Example, pascal(1,2) should return 2
        **
*/
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(pascal(1,2));
        System.out.println(pascal(5,6));
        System.out.println(pascal(4,5));
        System.out.println(pascal(6,6));
        System.out.println(pascal(4,6));
    }

    /**
     * value is row (C) col
     * we can write that by numerator = row (row-1) .....(row-col+1)
     * denominator = 1 * 2 * 3 * .........* col
     */
    private static long pascal(int col , int row){
        if (col < 0 || col > row) {
            throw new IllegalArgumentException("Invalid col: " + col);
        }

        long result = 1;
        // Use the iterative method to compute C(row, col)
        for (int i = 1; i <= col; i++) {
            result = result * (row - i + 1) / i;
        }
        return result;
    }
}
