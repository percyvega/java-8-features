package com.percyvega.java8.streams.intermediatestateful;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

@Log4j2
class SortedTest {

    @Test
    void sorted() {
        Stream.of("Percy", "Fran", "Nico", "Isabella")
                .sorted()
                .forEach(log::info);
    }

    @Test
    void sorted_comparator() {
        Comparator<Student> studentComparator = Comparator.comparingDouble(Student::getGpa).thenComparingDouble(Student::getGradeLevel).reversed();

        StudentService.getAllStudents().stream()
                .sorted(studentComparator)
                .forEach(student -> log.info(student.getGpa() + ", " + student.getGradeLevel() + ", " + student.getName()));
    }

}