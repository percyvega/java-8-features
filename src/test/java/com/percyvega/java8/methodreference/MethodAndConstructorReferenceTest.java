package com.percyvega.java8.methodreference;

import com.percyvega.java8.student.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MethodAndConstructorReferenceTest {

    @Test
    void function_as_a_parameter() {
        Function<String, Integer> valueOf = Integer::valueOf;
        assertThat(functionApplyToString(valueOf, "23") + 4).isEqualTo(27);

        assertThat(functionApplyToString(Integer::valueOf, "23") + 4).isEqualTo(27);
    }

    private Integer functionApplyToString(Function<String, Integer> function, String s) {
        return function.apply(s);
    }

    @Test
    void supplier_as_a_parameter() {
        Random random = new Random();
        Supplier<Integer> nextInt = random::nextInt;
        for (int i = 0; i < 10; i++) {
            assertThat(supplierGet(nextInt)).isLessThanOrEqualTo(Integer.MAX_VALUE).isGreaterThanOrEqualTo(Integer.MIN_VALUE);
        }
    }

    private Integer supplierGet(Supplier<Integer> supplier) {
        return supplier.get();
    }

    @Test
    void no_arguments_constructor_reference_test() {
        Supplier<Student> studentSupplier = Student::new;
        assertThat(studentSupplier.get()).isInstanceOf(Student.class);
    }

    @Test
    void one_arguments_constructor_reference_test() {
        Function<String, Student> studentFunction = Student::new;

        assertThat(studentFunction.apply("Percy").getName()).isEqualTo("Percy");
    }

}
