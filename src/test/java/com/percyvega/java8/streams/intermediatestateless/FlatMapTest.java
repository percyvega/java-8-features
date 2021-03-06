package com.percyvega.java8.streams.intermediatestateless;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class FlatMapTest {

    @Test
    void test_map_flatMap_toList() {
        List<String> activities = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        activities.forEach(log::info);
    }

    @Test
    void test_map_flatMap_distinct_toList() {
        List<String> activities = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        activities.forEach(log::info);
    }

    @Test
    void test_map_flatMap_distinct_sorted_toList() {
        List<String> activities = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        activities.forEach(log::info);
    }

    @Test
    void test_map_mapToLong_sum_distinct_count() {
        long beforeDistinctCount = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .mapToLong(List::size)
                .sum();

        long afterDistinctCount = StudentsListSupplier.get().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        log.info("Before distinct: {}", beforeDistinctCount);
        log.info("After distinct: {}", afterDistinctCount);
    }

}
