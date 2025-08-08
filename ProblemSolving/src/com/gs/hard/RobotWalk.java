package com.gs.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RobotWalk {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(walk("ULDR")));
        System.out.println(Arrays.toString(walk("UUU")));
        System.out.println(Arrays.toString(walk("UXSLD")));
        System.out.println(Arrays.toString(walk("DXLU")));
    }
    static int[] walk(String path){

        int[] cord = {0,0};
        Map<Character, Consumer<int[]>> direction = new HashMap<>();
        direction.put('U',(arr)-> arr[1] = arr[1]+1);
        direction.put('D',(arr)-> arr[1] = arr[1]-1);
        direction.put('L',(arr)-> arr[0] = arr[0]-1);
        direction.put('R',(arr)-> arr[0] = arr[0]+1);
        for (int i=0;i<path.length();i++){
            char ch = path.charAt(i);
            if(direction.containsKey(ch)){
                direction.get(ch).accept(cord);
            }
        }
        return cord;
    }
}
