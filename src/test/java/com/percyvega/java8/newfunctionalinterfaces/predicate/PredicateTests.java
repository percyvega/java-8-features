package com.percyvega.java8.newfunctionalinterfaces.predicate;

import com.percyvega.java8.Student;
import com.percyvega.java8.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.percyvega.java8.Constants.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class PredicateTests {

    private static final List<Integer> leapYears = Arrays.asList(1596, 1600, 2000, 2400);
    private static final List<Integer> notLeapYears = Arrays.asList(1697, 1698, 1699, 1700, 1800, 1900, 2100, 2200, 2300);

    private static final Predicate<Integer> divisibleBy4Predicate = integer -> integer % 4 == 0;
    private static final Predicate<Integer> divisibleBy100Predicate = integer -> integer % 100 == 0;
    private static final Predicate<Integer> divisibleBy400Predicate = integer -> integer % 400 == 0;

    public static final Predicate<Integer> isLeapYear = divisibleBy4Predicate.and(divisibleBy100Predicate.negate()).or(divisibleBy400Predicate);

    public static final Predicate<Student> gpaGt35MaleStudentPredicate = student -> MALE.equals(student.getGender()) && student.getGpa() >= 3.5;

    private static final List<Student> students = StudentService.getAllStudents();

    @Test
    void divisibleBy4PredicateTest() {
        assertThat(divisibleBy4Predicate.test(4)).isTrue();
        assertThat(divisibleBy4Predicate.test(11)).isFalse();
    }

    @Test
    void divisibleBy100PredicateTest() {
        assertThat(divisibleBy100Predicate.test(100)).isTrue();
        assertThat(divisibleBy100Predicate.test(200)).isTrue();
        assertThat(divisibleBy100Predicate.test(111)).isFalse();
    }

    @Test
    void divisibleBy400PredicateTest() {
        assertThat(divisibleBy400Predicate.test(400)).isTrue();
        assertThat(divisibleBy400Predicate.test(1200)).isTrue();
        assertThat(divisibleBy400Predicate.test(1111)).isFalse();
    }

    @Test
    void isLeapYearTest() {
        leapYears.forEach(integer -> {
            assertThat(isLeapYear.test(integer)).isTrue();
        });
        notLeapYears.forEach(integer -> {
            assertThat(isLeapYear.test(integer)).isFalse();
        });
    }

    @Test
    void gpa4MaleStudentPredicateTest() {
        students.forEach(student -> {
            if (gpaGt35MaleStudentPredicate.test(student)) {
                log.info(student);
            }
        });
    }

}
