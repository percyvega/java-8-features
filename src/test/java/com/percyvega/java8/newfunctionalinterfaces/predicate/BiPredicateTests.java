package com.percyvega.java8.newfunctionalinterfaces.predicate;

import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static com.percyvega.java8.student.Constants.MALE;

@Log4j2
class BiPredicateTests {

    public static final BiPredicate<String, Double> gpaGt35MaleStudentBiPredicate = (gender, gpa) -> MALE.equals(gender) && gpa >= 3.5;

    @Test
    void gpa4MaleStudentPredicateTest() {
        StudentsListSupplier.get().forEach(student -> {
            if (gpaGt35MaleStudentBiPredicate.test(student.getGender(), student.getGpa())) {
                log.info(student);
            }
        });
    }

}
