package com.orcl.array;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
 */
import java.util.ArrayList;
import java.util.List;

public class ZigzagSentence {

	public static void main(String[] args) {

		System.out.println(printZigzag("PAYPALISHIRING", 4));
		System.out.println(printZigzag("A", 2));
		System.out.println(printZigzag("AB", 1));
		System.out.println(printZigzag("ABCD", 2));
	}

	public static String printZigzag(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

}
