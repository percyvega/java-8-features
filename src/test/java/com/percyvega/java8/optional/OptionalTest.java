package com.percyvega.java8.optional;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.OptionalStudentSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@Log4j2
public class OptionalTest {

    @Test
    void test() {
        Optional<String> optional1 = Optional.of("Percy");
        assertThat(optional1.isPresent()).isTrue();
        assertThat(optional1.get()).isEqualTo("Percy");
        assertThat(optional1.orElse("fallback")).isEqualTo("Percy");
        optional1.ifPresent(s -> assertThat(s).isEqualTo("Percy"));

        Optional<Object> optional2 = Optional.empty();
        assertThat(optional2.isPresent()).isFalse();
//        assertThat(optional2.get()).isNull(); java.util.NoSuchElementException: No value present
        assertThat(optional2.orElse("fallback")).isEqualTo("fallback");
        optional2.ifPresent(s -> fail("Not reached"));

//        Optional<Object> optional3 = Optional.of(null); java.lang.NullPointerException

        Optional<Object> optional4 = Optional.ofNullable(null);
        assertThat(optional4.isPresent()).isFalse();
//        assertThat(optional4.get()).isNull(); java.util.NoSuchElementException: No value present
        assertThat(optional4.orElse("fallback")).isEqualTo("fallback");
        optional4.ifPresent(s -> fail("Not reached"));
    }

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
    void optionalMapOrElse() {
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
                log.info(e.getMessage() + " " + o);
                assertThat(o).isEmpty();
            }
        }
    }

    @Test
    void ifPresent() {
        for (int i = 0; i < 20; i++) {
            Optional<Student> o = OptionalStudentSupplier.get();
            o.ifPresent(log::info);

            if (!o.isPresent()) {
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
