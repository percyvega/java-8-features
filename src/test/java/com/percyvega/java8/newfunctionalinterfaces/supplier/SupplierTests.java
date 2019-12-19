package com.percyvega.java8.newfunctionalinterfaces.supplier;

import com.percyvega.java8.Student;
import com.percyvega.java8.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Log4j2
public class SupplierTests {

    private static final List<Student> students = StudentService.getAllStudents();

    public static final Supplier<Student> randomStudentSupplier = () -> students.get(Math.abs(new Random().nextInt()) % students.size());

    @Test
    void test_supplier() {
        for (int i = 0; i < 20; i++) {
            log.info(randomStudentSupplier.get());
        }
    }
}
