package com.easylearnz.streams;

class Student {
    private String name;
    private int age;
    private String gender;
    private String department;

    public Student(String name, int age, String gender, String department) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
