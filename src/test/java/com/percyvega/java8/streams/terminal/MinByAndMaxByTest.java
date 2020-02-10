package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MinByAndMaxByTest {

    @Test
    void min_without_collect() {
        Optional<Double> optionalDouble = StudentService.getAllStudents().stream()
                .map(Student::getGpa)
                .min(Double::compare);

        assertThat(optionalDouble.get()).isEqualTo(3d);
    }

    @Test
    void minBy() {
        Optional<Student> optionalStudent = StudentService.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

        assertThat(optionalStudent.get().getName()).isEqualTo("Ben Affleck");
    }

    @Test
    void max_without_collect() {
        Optional<Double> optionalDouble = StudentService.getAllStudents().stream()
                .map(Student::getGpa)
                .max(Double::compare);

        assertThat(optionalDouble.get()).isEqualTo(4d);
    }

    @Test
    void maxBy() {
        Optional<Student> optionalStudent = StudentService.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        assertThat(optionalStudent.get().getName()).isEqualTo("Emma Thompson");
    }

}
