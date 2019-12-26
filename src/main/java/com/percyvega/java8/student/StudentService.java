package com.percyvega.java8.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.percyvega.java8.student.Constants.MALE;
import static com.percyvega.java8.student.Constants.FEMALE;

public class StudentService {

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Matt Damon", 2, 3.6, MALE, 10, Arrays.asList("dancing", "basketball", "volleyball")));
        students.add(new Student("Julia Roberts", 2, 3.5, FEMALE, 11, Arrays.asList("swimming", "gymnastics", "soccer")));
        students.add(new Student("George Clooney", 2, 3.8, MALE, 11, Arrays.asList("aerobics", "gymnastics", "soccer")));
        students.add(new Student("Meryl Streep", 2, 3.3, FEMALE, 10, Arrays.asList("dancing", "basketball", "volleyball")));
        students.add(new Student("Johnny Depp", 2, 3.9, MALE, 11, Arrays.asList("swimming", "gymnastics", "soccer")));

        students.add(new Student("Ben Affleck", 3, 3.0, MALE, 12, Arrays.asList("dancing", "gymnastics", "aerobics")));
        students.add(new Student("Elizabeth Taylor", 3, 3.5, FEMALE, 15, Arrays.asList("swimming", "gymnastics", "soccer")));
        students.add(new Student("Clint Eastwood", 3, 3.7, MALE, 12, Arrays.asList("dancing", "gymnastics", "aerobics")));
        students.add(new Student("Cate Blanchett", 3, 3.9, FEMALE, 15, Arrays.asList("aerobics", "gymnastics", "football")));
        students.add(new Student("Kevin Spacey", 3, 3.3, MALE, 15, Arrays.asList("swimming", "gymnastics", "soccer")));
        students.add(new Student("Emma Thompson", 3, 4.0, FEMALE, 15, Arrays.asList("swimming", "gymnastics", "soccer")));

        students.add(new Student("Robert De Niro", 4, 3.5, MALE, 10, Arrays.asList("aerobics", "dancing", "football")));
        students.add(new Student("Jodie Foster", 4, 3.9, FEMALE, 10, Arrays.asList("swimming", "dancing", "soccer")));
        students.add(new Student("Brad Pitt", 4, 3.5, MALE, 10, Arrays.asList("swimming", "dancing", "football")));
        students.add(new Student("Sigourney Weaver", 4, 3.4, FEMALE, 22, Arrays.asList("aerobics", "basketball", "baseball", "football")));

        return students;
    }

}
