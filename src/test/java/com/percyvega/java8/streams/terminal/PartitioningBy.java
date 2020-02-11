package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
public class PartitioningBy {

    @Test
    void partitioningBy1() {
        Map<Boolean, List<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa() >= 3.60));

        for (Map.Entry<Boolean, List<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            entry.getValue().forEach(log::info);
            System.out.println();
        }
    }

    @Test
    void partitioningBy2() {
        Map<Boolean, Set<Student>> collect = StudentsListSupplier.get()
                .stream()
                .collect(Collectors.partitioningBy(
                        student -> student.getGpa() >= 3.60,
                        Collectors.toSet()));

        for (Map.Entry<Boolean, Set<Student>> entry : collect.entrySet()) {
            log.info(entry.getKey());
            entry.getValue().forEach(log::info);
            System.out.println();
        }
    }

}
