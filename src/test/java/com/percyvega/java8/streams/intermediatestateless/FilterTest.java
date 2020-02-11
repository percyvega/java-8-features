package com.percyvega.java8.streams.intermediatestateless;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.percyvega.java8.student.Constants.MALE;

@Log4j2
public class FilterTest {

    @Test
    void test_filter() {
        Map<String, List<String>> studentNameAndActivities = StudentsListSupplier.get().stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .filter(student -> student.getGpa() >= 3.5)
                .filter(student -> MALE.equals(student.getGender()))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        studentNameAndActivities.forEach((s, activities) -> log.info(s + ": " + activities));
    }

}
