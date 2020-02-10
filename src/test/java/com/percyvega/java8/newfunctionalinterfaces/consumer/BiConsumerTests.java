package com.percyvega.java8.newfunctionalinterfaces.consumer;

import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
class BiConsumerTests {

    private static final BiConsumer<Integer, Integer> logBothIntegers = (a, b) -> log.info(a + ", " + b);
    private static final BiConsumer<String, List<String>> logStudentNameAndActivities = (a, b) -> log.info(a + ", " + b);
    private static final BiConsumer<Integer, Integer> logIntegerMultiplication = (a, b) -> log.info(a * b);

    @Test
    void logBothElements() {
        logBothIntegers.accept(3, 2);
    }

    @Test
    void logMultiplication() {
        logIntegerMultiplication.accept(3, 2);
    }

    @Test
    void logBothElementsAndTheirMultiplication() {
        logBothIntegers.andThen(logIntegerMultiplication).accept(3, 2);
    }

    @Test
    void logStudentNameAndActivities() {
        StudentService.getAllStudents().forEach(student -> logStudentNameAndActivities.accept(student.getName(), student.getActivities()));
    }

}
