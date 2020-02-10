package com.percyvega.java8.newfunctionalinterfaces.supplier;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Supplier;

@Log4j2
public class SupplierTests {

    public static final Supplier<Student> randomStudentSupplier = () -> StudentService.getAllStudents().get(Math.abs(new Random().nextInt()) % StudentService.getAllStudents().size());

    @Test
    void test_supplier() {
        for (int i = 0; i < 20; i++) {
            log.info(randomStudentSupplier.get());
        }
    }
}
