package com.gs.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMaxIpAddressOccurance {
    public static void main(String[] args) {
        String[] lines = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        System.out.println(findMaxOccuranceIp(lines));

    }
    private static String findMaxOccuranceIp(String[] lines){
        Map<String, Long> countMap = Arrays.stream(lines)
                .map(line -> line.split(" ")[0])
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        AtomicLong max = new AtomicLong(0L);
        AtomicReference<String> ip = new AtomicReference<>();
        countMap.forEach((k,v)->{
            if(v > max.get()){
                max.set(v);
                ip.set(k);
            }
        });
        return ip.get();
    }
}
