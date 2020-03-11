package com.percyvega.java8.methodreference;

import com.percyvega.java8.student.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@Log4j2
public class MethodAndConstructorReferenceTest {

    @Test
    void function_as_a_parameter() {
        Function<String, Integer> valueOf = Integer::valueOf;
        log.info(functionApplyToString(valueOf, "23") + 4);
    }

    private Integer functionApplyToString(Function<String, Integer> function, String s) {
        return function.apply(s);
    }

    @Test
    void supplier_as_a_parameter() {
        Random random = new Random();
        Supplier<Integer> nextInt = random::nextInt;
        for (int i = 0; i < 10; i++) {
            log.info(supplierGet(nextInt) + 4);
        }
    }

    private Integer supplierGet(Supplier<Integer> supplier) {
        return supplier.get();
    }

    @Test
    void no_arguments_constructor_reference_test() {
        Supplier<Student> studentSupplier = Student::new;
        log.info(studentSupplier.get());
    }

    @Test
    void one_arguments_constructor_reference_test() {
        Function<String, Student> studentFunction = Student::new;

        log.info(studentFunction.apply("Percy"));
    }
}
