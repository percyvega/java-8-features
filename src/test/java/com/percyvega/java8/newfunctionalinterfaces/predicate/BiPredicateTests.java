package com.percyvega.java8.newfunctionalinterfaces.predicate;

import com.percyvega.java8.Student;
import com.percyvega.java8.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;

import static com.percyvega.java8.Constants.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class BiPredicateTests {

    public static final BiPredicate<String, Double> gpaGt35MaleStudentBiPredicate = (gender, gpa) -> MALE.equals(gender) && gpa >= 3.5;

    private static final List<Student> students = StudentService.getAllStudents();

    @Test
    void gpa4MaleStudentPredicateTest() {
        students.forEach(student -> {
            if (gpaGt35MaleStudentBiPredicate.test(student.getGender(), student.getGpa())) {
                log.info(student);
            }
        });
    }

}
