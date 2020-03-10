package com.percyvega.java8.interfaces;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Log4j2
class ComparatorTest {

    private static List<String> stringList = Arrays.asList("She", "It", "I", "He", null, "Abstract", "Internationalization", "Four", "Seven");

    Comparator<String> comparatorComparingLength = Comparator.comparingInt(String::length);
    Comparator<String> comparatorNullsLastComparingLengthComparingHashcode = Comparator.nullsLast(Comparator.comparingInt(String::length).thenComparingInt(String::hashCode));
    Comparator<Student> comparatorComparingGpaComparingGradeReversed = Comparator.comparingDouble(Student::getGpa).thenComparingDouble(Student::getGradeLevel).reversed();

    @Test
    void listSort() {
        stringList.sort(Comparator.nullsFirst(comparatorComparingLength));
        log.info(stringList);

        stringList.sort(Comparator.nullsFirst(comparatorComparingLength.reversed()));
        log.info(stringList);

        stringList.sort(comparatorNullsLastComparingLengthComparingHashcode);
        log.info(stringList);
    }

    @Test
    void comparator_reversed() {
        StudentsListSupplier.get().stream()
                .sorted(comparatorComparingGpaComparingGradeReversed)
                .forEach(student -> log.info(student.getGpa() + ", " + student.getGradeLevel() + ", " + student.getName()));
    }

}