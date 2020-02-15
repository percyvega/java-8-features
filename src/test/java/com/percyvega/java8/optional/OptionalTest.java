package com.percyvega.java8.optional;

import com.percyvega.java8.student.OptionalStudentSupplier;
import com.percyvega.java8.student.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class OptionalTest {

    @Test
    void optional() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();

            if (o.isPresent()) {
                log.info(o.get());
                assertThat(o.get()).isNotNull();
                assertThat(o).isNotEmpty();
            } else {
                log.info(o);
                assertThat(o).isEmpty();
            }
        }
    }

    @Test
    void orElse() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();
            log.info(o.map(Student::getName).orElse("-"));
        }
    }

    @Test
    void orElseGet() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();

            String s = o.map(Student::getName).orElseGet(String::new);
            log.info(s);
        }
    }

    @Test
    void orElseThrow() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();

            try {
                String s = o.map(Student::getName).orElseThrow(() -> new RuntimeException("Student not found!"));
                log.info(s);
                assertThat(o).isPresent();
            } catch (RuntimeException e) {
                log.info(o);
                assertThat(o).isEmpty();
            }
        }
    }

    @Test
    void ifPresent() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();
            o.ifPresent(log::info);

            if(!o.isPresent()) {
                log.info("-");
            }
        }
    }

    @Test
    void filter() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();

            o
                    .filter(student -> student.getGpa() > 3.4)
                    .ifPresent(log::info);
        }
    }

    @Test
    void flatMap() {
        for (int i = 0; i < 50; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();

            o
                    .filter(student -> student.getGpa() > 3.6)
                    .flatMap(Student::getSpouse)
                    .map(Student::getGpa)
                    .ifPresent(log::info);
        }
    }

}
