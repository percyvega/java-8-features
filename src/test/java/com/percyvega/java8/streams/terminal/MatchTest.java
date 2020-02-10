package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MatchTest {

    @Test
    void allMatch() {
        boolean allMatch = StudentService.getAllStudents().stream()
                .allMatch(student -> student.getNoteBooks() >= 10);
        assertThat(allMatch).isTrue();
    }

    @Test
    void anyMatch() {
        boolean anyMatch = StudentService.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() == 4.0);
        assertThat(anyMatch).isTrue();
    }

    @Test
    void noneMatch() {
        boolean noneMatch = StudentService.getAllStudents().stream()
                .noneMatch(student -> student.getName().length() < 9);
        assertThat(noneMatch).isTrue();
    }

}
