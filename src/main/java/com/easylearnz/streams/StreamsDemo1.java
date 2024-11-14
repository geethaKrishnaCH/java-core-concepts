package com.easylearnz.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsDemo1 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Bob", 18, "male", "Computer"));
        studentList.add(new Student("Ted", 17, "male", "Computer"));
        studentList.add(new Student("Jane", 19, "female", "Economics"));
        studentList.add(new Student("Alan", 19, "male", "Economics"));
        studentList.add(new Student("Nicole", 18, "female", "Computer"));

        // computer department students
        List<Student> computerStudents = studentList.stream()
                .filter(s -> Objects.equals(s.getDepartment(), "Computer"))
                .collect(Collectors.toList());

        Map<String, List<Student>> resultMap = new HashMap<>();
        computerStudents.stream().forEach(s -> {
            List<Student> groupList = resultMap.computeIfAbsent(s.getGender(), st -> new ArrayList<>());
            // List<Student> groupList = resultMap.getOrDefault(s.getGender(), new ArrayList<>());
            groupList.add(s);
            // resultMap.put(s.getGender(), groupList);
        });

        Map<String, List<Student>> resultMap2 = studentList.stream()
                .filter(s -> Objects.equals(s.getDepartment(), "Computer"))
                .collect(Collectors.groupingBy(Student::getGender));


        System.out.println(resultMap);
        System.out.println(resultMap2);
        Map<String, Long> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        System.out.println(collect);
    }
}
