package com.gs.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Question:
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode

*/
public class MagicPotionEncoder {
    private static int minEncodedLength(List<String> input) {
        int n = input.size();
        int i = 0, encodedLength = 0;

        while (i < n) {
            int maxLen = 0;

            // Try to find the longest previous prefix that matches current position
            for (int len = 1; len <= i && i + len <= n; len++) {
                boolean match = true;
                for (int j = 0; j < len; j++) {
                    if (!input.get(j).equals(input.get(i + j))) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    maxLen = len;
                }
            }
            if (maxLen > 0) {
                i += maxLen;
            } else {
                i++;
            }
            encodedLength++;
        }

        return encodedLength;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "B", "A", "B", "C", "A", "B", "A", "B", "C", "E");
        System.out.println("Minimum encoded length: " + minEncodedLength(input)); // Output: 6
    }
}
