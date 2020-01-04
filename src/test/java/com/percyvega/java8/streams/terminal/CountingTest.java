package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CountingTest {

    List<Student> allStudents = StudentService.getAllStudents();

    @Test
    void count() {
        long count = allStudents.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        assertThat(count).isEqualTo(9);
    }

    @Test
    void counting() {
        Long counting = allStudents.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.counting());

        assertThat(counting).isEqualTo(9L);
    }

}
