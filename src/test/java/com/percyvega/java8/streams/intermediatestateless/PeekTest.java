package com.percyvega.java8.streams.intermediatestateless;

import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static com.percyvega.java8.student.Constants.MALE;

@Log4j2
public class PeekTest {

    @Test
    void test_peek() {
        StudentsListSupplier.get().stream()
                .peek(student -> log.info("Peek #1: {}", student.getName()))
                .filter(student -> student.getGradeLevel() >= 3)
                .peek(student -> log.info("Peek #2: {}, Grade Level: {}", student.getName(), student.getGradeLevel()))
                .filter(student -> student.getGpa() >= 3.5)
                .peek(student -> log.info("Peek #3: {}, GPA: {}", student.getName(), student.getGpa()))
                .filter(student -> MALE.equals(student.getGender()))
                .peek(student -> log.info("Peek #4: {}, Gender: {}", student.getName(), student.getGender()))
                .forEach(student -> log.info("Terminal: " + student));
    }

}
