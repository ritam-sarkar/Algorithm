package com.gs.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Return the fraction output in the following way Examples: If after decimal,
 * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
 * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
 * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
 * fractionRepresentation(6,11)=0.(54)
 */

public class DecimalConversion {
    public static void main(String[] args) {

        /*System.out.println(fractionRepresentation(6,11));
        System.out.println(fractionRepresentation(22,7));
        System.out.println(fractionRepresentation(1,3));
        System.out.println(fractionRepresentation(5,11));*/
        System.out.println(fractionRepresentation(60,32));
        System.out.println(fractionRepresentation(5,12));
    }
    private static String fractionRepresentation(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();

        // Handle the sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to absolute values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        // Decimal part
        result.append(".");
        Map<Long, Integer> remainderPositions = new HashMap<>();
        StringBuilder fractionPart = new StringBuilder();
        int position = 0;
        while (remainder != 0) {
            if (remainderPositions.containsKey(remainder)) {
                int start = remainderPositions.get(remainder);
                String nonRepeating = fractionPart.substring(0, start);
                String repeating = fractionPart.substring(start);
                result.append(nonRepeating).append("(").append(repeating).append(")");
                return result.toString();
            }
            remainderPositions.put(remainder, position);
            remainder *= 10;
            fractionPart.append(remainder / den);
            remainder = remainder % den;
            position++;
        }
        result.append(fractionPart);
        return result.toString();
    }
}
