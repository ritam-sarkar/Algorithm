package com.gs.medium;

/**
 * Find string to Integer
 */
public class Atoi {
    public static void main(String[] args) {
        System.out.println(atoi("4351"));
        System.out.println(atoi("1"));
        System.out.println(atoi("200"));
    }
    public static int atoi(String str)
    {
        int result = 0;
        int strLength = str.length();

        for(int i = 0; i < strLength; i++)
        {
            char ch = str.charAt(i);
            int digit = ch - '0';
            result = result*10 + digit;
        }

        return result;
    }


}
