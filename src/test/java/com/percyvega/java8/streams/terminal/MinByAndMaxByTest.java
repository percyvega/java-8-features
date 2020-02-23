package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MinByAndMaxByTest {

    @Test
    void min_without_collect() {
        Optional<Double> optionalDouble = StudentsListSupplier.get().stream()
                .map(Student::getGpa)
                .min(Double::compare);

        assertThat(optionalDouble.get()).isEqualTo(3d);
    }

    @Test
    void minBy() {
        Optional<Student> optionalStudent = StudentsListSupplier.get().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

        assertThat(optionalStudent.get().getName()).isEqualTo("Ben Affleck");
    }

    @Test
    void max_without_collect() {
        Optional<Double> optionalDouble = StudentsListSupplier.get().stream()
                .map(Student::getGpa)
                .max(Double::compare);

        assertThat(optionalDouble.get()).isEqualTo(4d);
    }

    @Test
    void maxBy() {
        Optional<Student> optionalStudent = StudentsListSupplier.get().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        assertThat(optionalStudent.get().getName()).isEqualTo("Emma Thompson");
    }

}
