package com.percyvega.java8.newfunctionalinterfaces;

import com.percyvega.java8.Student;
import com.percyvega.java8.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.percyvega.java8.Constants.FEMALE;
import static com.percyvega.java8.Constants.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class PredicateAndConsumerTests {

    private static final Consumer<Student> logStudentNameConsumer = student -> log.info(student::getName);
    private static final Consumer<Student> logStudentGpaConsumer = student -> log.info(student::getGpa);

    public static final Predicate<Student> gpaGt35MaleStudentPredicate = student -> MALE.equals(student.getGender()) && student.getGpa() > 3.5;
    public static final Predicate<Student> gpaLt35FemaleStudentPredicate = student -> FEMALE.equals(student.getGender()) && student.getGpa() < 3.5;

    public static final Consumer<Student> compositeConsumer = student -> {
        if(gpaGt35MaleStudentPredicate.or(gpaLt35FemaleStudentPredicate).test(student)) {
            logStudentNameConsumer.andThen(logStudentGpaConsumer).accept(student);
        }
    };

    private static final List<Student> students = StudentService.getAllStudents();

    @Test
    void test1() {
        students.forEach(compositeConsumer);
    }

    @Test
    void test2() {
        students.stream()
                .filter(gpaGt35MaleStudentPredicate.or(gpaLt35FemaleStudentPredicate))
                .forEach(logStudentNameConsumer.andThen(logStudentGpaConsumer));
    }

}