package com.percyvega.java8.streams;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
public class MapTest {

    @Test
    void test_map_toList() {
        List<String> namesList = StudentService.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        namesList.forEach(log::info);
    }

    @Test
    void test_mapToDouble_toSet() {
        Set<Double> namesSet = StudentService.getAllStudents().stream()
                .mapToDouble(Student::getGpa)
                .boxed()
                .collect(Collectors.toSet());

        namesSet.forEach(log::info);
    }

    @Test
    void test_mapToInt_sum() {
        int noteBooksCount = StudentService.getAllStudents().stream()
                .mapToInt(Student::getNoteBooks)
                .sum();

        log.info(noteBooksCount);
    }

    @Test
    void test_mapToInt_average() {
        OptionalDouble average = StudentService.getAllStudents().stream()
                .mapToInt(Student::getGradeLevel)
                .average();

        average.ifPresent(log::info);
    }

}
