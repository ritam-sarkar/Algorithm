package com.riversand;

import java.util.List;
import java.util.Stack;

public class LeetCodeCalculator {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int curr = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            else if (c == '+') {
                res += curr * sign; // this is always prev sign
                sign = 1;
                curr = 0;
            }
            else if (c == '-') {
                res += curr * sign; // this is always prev sign
                sign = -1;
                curr = 0;
            }
            else if (c == '(') {
                stack.push(res);
                stack.push(sign); // this is always prev sign
                // initialize to default values again as I pushed the context
                res = 0;
                sign = 1;
                curr = 0;
            }
            else if (c == ')') {
                res += curr * sign; // this is always prev sign
                curr = 0;
                res *= stack.pop(); // sign
                res += stack.pop(); // prev result
            }
        }

        res += curr * sign; // if last character is digit
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeCalculator().calculate("1 -(-2)"));
        System.out.println(new LeetCodeCalculator().calculate("123456"));
        System.out.println(new LeetCodeCalculator().calculate("1 +1"));
    }
}
