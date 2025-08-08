package com.gs.easy;

import java.util.LinkedHashSet;
import java.util.Set;

public class FirstNonRepeatatingCharacter {
    public static void main(String[] args) {
        System.out.println(findFirst("apple"));
        System.out.println(findFirst("racecars"));
        System.out.println(findFirst("aabb"));
        System.out.println(findFirst("aabbcxx"));
    }
    private static char findFirst(String input){
        Set<Character> set = new LinkedHashSet<>();
        Character result = null;
        for (int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(set.contains(c)){
                if(c == result){
                    result = null;
                }
                set.remove(c);
            } else {
                set.add(c);
                if(result == null){
                    result = c;
                }
            }
        }
        return result == null ? '\0' : result;
    }
}
