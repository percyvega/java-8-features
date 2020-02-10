package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FindTest {

    @Test
    void findAny() {
        Optional<Student> optionalStudent = StudentService.getAllStudents().stream()
                .filter(student -> student.getNoteBooks() >= 23)
                .findAny();
        assertThat(optionalStudent).isEmpty();
    }

    @Test
    void findFirst() {
        Optional<Student> optionalStudent = StudentService.getAllStudents().stream()
                .filter(student -> student.getGpa() == 4.0)
                .findFirst();
        assertThat(optionalStudent.get().getName()).isEqualTo("Emma Thompson");
    }

}
