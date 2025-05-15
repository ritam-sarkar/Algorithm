package com.orcl.array;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("a","ab"));
        System.out.println(isAnagram("aa","bb"));
        System.out.println(isAnagram("anagram","nagaram"));
    }
    private static boolean isAnagram(String s, String t) {
        boolean result = true;
        int[] count = new int[26];
        if(s.length() != t.length()){
            result = false;
        } else {
            for(int i=0; i<s.length();i++){
                char source = s.charAt(i);
                count[source - 'a'] += 1;
            }
            for(int i=0; i<t.length();i++){
                char target = t.charAt(i);
                count[target - 'a'] -= 1;
            }
            for(int i=0; i<26;i++){
                if(count[i] > 0){
                    result = false;
                    break;
                }
            }
        }

        return result;

    }
}
