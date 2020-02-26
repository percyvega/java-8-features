package com.percyvega.java8.constructorreference;

import com.percyvega.java8.student.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

@Log4j2
public class ConstructorReferenceTest {

    @Test
    void test_supplier() {
        Supplier<Student> studentSupplier = Student::new;
        log.info(studentSupplier.get());
    }

    @Test
    void test_function() {
        Function<String, Student> studentFunction = Student::new;

        log.info(studentFunction.apply("Percy"));
    }
}
