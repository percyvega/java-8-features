package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class JoiningTest {

    @Test
    void joining() {
        String joined = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        log.info(joined);
    }

    @Test
    void joining_with_a_delimeter() {
        String joined = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        log.info(joined);
    }

    @Test
    void joining_with_delimeters() {
        String joined = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", ", "All activities: ", "."));

        log.info(joined);
    }

}
