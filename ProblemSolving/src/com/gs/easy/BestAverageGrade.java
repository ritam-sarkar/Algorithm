package com.gs.easy;

import java.util.*;
import java.util.stream.Collectors;

public class BestAverageGrade {

    static class Student {
        String name;
        double av;

        public Student(String name , double score) {
            this.name = name;
            this.av = score;
        }
    }

    public static void main(String[] args) {

        List<Student> studentList = List.of(new Student("Sachin",90),
                                            new Student("Ishan",84) ,
                                            new Student("Sourav",70),
                                            new Student("Sachin",60));
        System.out.println(getBestGrade(studentList).av);
        System.out.println(getBestGrade2(studentList).av);
    }

    private  static  Student getBestGrade(List<Student> studentList){
        Map<String , Double> averageMap =
                studentList.stream()
                        .collect(
                                Collectors.groupingBy(s-> s.name,Collectors.averagingDouble(s-> s.av))
                        );
        // sort by value
        Map<String, Double> sortedMap = averageMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        TreeMap::new
                ));
        Optional<Map.Entry<String,Double>> optional = sortedMap.entrySet().stream().findFirst();
        if(optional.isPresent()){
            Map.Entry<String,Double> entry = optional.get();
            return new Student(entry.getKey(), entry.getValue());
        }
        return null;
    }

    private static Student getBestGrade2(List<Student> studentList){
        Map<String , Double> averageMap =
                studentList.stream()
                        .collect(
                                Collectors.groupingBy(s-> s.name,Collectors.averagingDouble(s-> s.av))
                        );
        String name = null;
        double maxAvg = 0.0;
        for (Map.Entry<String,Double> entry : averageMap.entrySet()){
            if(entry.getValue() > maxAvg){
                maxAvg = entry.getValue();
                name = entry.getKey();
            }
        }
        return new Student(name,maxAvg);
    }


}
