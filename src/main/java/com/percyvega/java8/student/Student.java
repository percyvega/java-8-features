package com.percyvega.java8.student;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private int noteBooks;
    private List<String> activities;
    private Optional<Student> spouse;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

}
