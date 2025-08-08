package com.gs.easy;

public class RunLengthEncoding {
    public static void main(String[] args) {
        System.out.println(encode("a"));       // a1
        System.out.println(encode("aa"));      // a2
        System.out.println(encode("aabbb"));   // a2b3
        System.out.println(encode("aabbaa"));  // a2b2a2
        System.out.println(encode(""));  // ""
    }

    public static String encode(String s) {
        if(s == null || s.isEmpty()){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char x = '\0';
        int count = 0;
        for (int i=0;i<s.length();i++){
            if(x == '\0' || s.charAt(i) == x){
                x = s.charAt(i);
                count++;
            } else {
                sb.append(x).append(count);
                x = s.charAt(i);
                count =1;
            }
        }
        sb.append(x).append(count);
        return sb.toString();
    }
}
