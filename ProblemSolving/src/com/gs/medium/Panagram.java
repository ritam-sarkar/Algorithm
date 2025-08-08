package com.gs.medium;

public class Panagram {
    public static void main(String[] args) {
        System.out.println(panagram("abcdefgh"));
        System.out.println(panagram("The quick brown fox jumps over the lazy dog"));
        System.out.println(panagram("Hello world"));
    }
    private static String panagram(String s){
        s = s.toLowerCase();
        boolean[] map = new boolean[26];
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c != ' '){
                int index = c - 'a';
                map[index] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<26;i++){
            if(!map[i]){
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}
