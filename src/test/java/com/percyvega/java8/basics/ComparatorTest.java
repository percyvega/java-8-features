package com.percyvega.java8.basics;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Log4j2
class ComparatorTest {

    private static List<String> stringList;

    @BeforeAll
    static void beforeAll() {
        stringList = Arrays.asList("Abstract", "I", "He", "She", "It", null, "Internationalization", "You", "One", "Three", "Four", "Five", "Six", "Seven");
    }

    @Test
    void nonFunctional() {
        java.util.Comparator<String> comparator = new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        }.reversed();

        stringList.sort(java.util.Comparator.nullsLast(comparator));

        log.info(stringList);
    }

    @Test
    void lambda_1() {
        java.util.Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        stringList.sort(java.util.Comparator.nullsFirst(comparator.reversed()));

        log.info(stringList);
    }

    @Test
    void lambda_2() {
        java.util.Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        stringList.sort(java.util.Comparator.nullsFirst(comparator));

        log.info(stringList);
    }

    @Test
    void methodReference() {
        java.util.Comparator<String> comparator = java.util.Comparator.nullsLast(java.util.Comparator.comparingInt(String::length).thenComparingInt(String::hashCode));

        stringList.sort(comparator);

        log.info(stringList);
    }

    @Test
    void comparator_reversed() {
        java.util.Comparator<Student> studentComparator = java.util.Comparator.comparingDouble(Student::getGpa).thenComparingDouble(Student::getGradeLevel).reversed();

        StudentService.getAllStudents().stream()
                .sorted(studentComparator)
                .forEach(student -> log.info(student.getGpa() + ", " + student.getGradeLevel() + ", " + student.getName()));
    }

}