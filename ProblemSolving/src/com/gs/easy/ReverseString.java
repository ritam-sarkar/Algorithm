package com.gs.easy;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
        System.out.println(reverse("ab cd"));
        System.out.println(reverse("a"));
        System.out.println(reverse(""));

    }
    private static String reverse(String s){
        if(s.length() == 0 || s.length() ==1){
            return s;
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i=0; i< n/2; i++){
            char temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        return String.valueOf(arr);
    }
    private static String reverse2( String str ){
        //your code goes here
        StringBuilder sb = new StringBuilder();
        sb.reverse();
        for(int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    };

}
