package com.percyvega.java8.streams;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MatchTest {

    List<Student> allStudents = StudentService.getAllStudents();

    @Test
    void allMatch() {
        boolean allMatch = allStudents.stream()
                .allMatch(student -> student.getNoteBooks() >= 10);
        assertThat(allMatch).isTrue();
    }

    @Test
    void anyMatch() {
        boolean anyMatch = allStudents.stream()
                .anyMatch(student -> student.getGpa() == 4.0);
        assertThat(anyMatch).isTrue();
    }

    @Test
    void noneMatch() {
        boolean noneMatch = allStudents.stream()
                .noneMatch(student -> student.getName().length() < 9);
        assertThat(noneMatch).isTrue();
    }

}
