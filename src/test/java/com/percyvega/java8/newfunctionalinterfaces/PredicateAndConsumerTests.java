package com.percyvega.java8.newfunctionalinterfaces;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.percyvega.java8.student.Constants.FEMALE;
import static com.percyvega.java8.student.Constants.MALE;

@Log4j2
class PredicateAndConsumerTests {

    private static final Consumer<Student> logStudentNameConsumer = student -> log.info(student::getName);
    private static final Consumer<Student> logStudentGpaConsumer = student -> log.info(student::getGpa);

    public static final Predicate<Student> gpaGt35MaleStudentPredicate = student -> MALE.equals(student.getGender()) && student.getGpa() > 3.5;
    public static final Predicate<Student> gpaLt35FemaleStudentPredicate = student -> FEMALE.equals(student.getGender()) && student.getGpa() < 3.5;

    public static final Consumer<Student> compositeConsumer = student -> {
        if (gpaGt35MaleStudentPredicate.or(gpaLt35FemaleStudentPredicate).test(student)) {
            logStudentNameConsumer.andThen(logStudentGpaConsumer).accept(student);
        }
    };

    @Test
    void test1() {
        StudentsListSupplier.get().forEach(compositeConsumer);
    }

    @Test
    void test2() {
        StudentsListSupplier.get().stream()
                .filter(gpaGt35MaleStudentPredicate.or(gpaLt35FemaleStudentPredicate))
                .forEach(logStudentNameConsumer.andThen(logStudentGpaConsumer));
    }

}
