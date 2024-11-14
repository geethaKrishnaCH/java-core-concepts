package com.easylearnz.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo1 {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("geetha", 26));
        studentList.add(new Student("jhansi", 18));
        studentList.add(new Student("krishna", 18));

        studentList.stream()
                .filter(s -> s.getAge() == 18)
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
