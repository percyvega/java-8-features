package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SummingIntAndAveragingIntTest {

    @Test
    void sum_without_collect() {
        int sum = StudentService.getAllStudents().stream()
                .mapToInt(Student::getNoteBooks)
                .sum();

        assertThat(sum).isEqualTo(189);
    }

    @Test
    void summingInt() {
        Integer summingInt = StudentService.getAllStudents().stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));

        assertThat(summingInt).isEqualTo(189);
    }

    @Test
    void average_without_collect() {
        OptionalDouble optionalDouble = StudentService.getAllStudents().stream()
                .mapToDouble(Student::getGpa)
                .average();

        assertThat(optionalDouble.getAsDouble()).isEqualTo(3.586, Offset.offset(.001));
    }

    @Test
    void averagingDouble() {
        Double collect = StudentService.getAllStudents().stream()
                .collect(Collectors.averagingDouble(Student::getGpa));

        assertThat(collect).isEqualTo(3.586, Offset.offset(.001));
    }

}
