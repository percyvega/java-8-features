package com.percyvega.java8.streams.terminal;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.PropertySource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ReduceTest {

    List<Integer> integers = Arrays.asList(1, 3, 5, 7);
    List<Integer> integersWithNull = Arrays.asList(1, 3, null, 5, 7);

    @Test
    void multiply() {
        Optional<Integer> resultOptional = integers.stream()
                .reduce((x, y) -> x * y);
        assertThat(resultOptional.get()).isEqualTo(105);
    }

    @Test
    void multiply_with_identity() {
        Integer result = integers.stream()
                .reduce(10, (x, y) -> x * y);
        assertThat(result).isEqualTo(1050);
    }

    @Test
    void multiply_throws_exception() {
        Assertions.assertThrows(NullPointerException.class, () -> integersWithNull.stream()
                .reduce((x, y) -> x * y));
    }

    @Test
    void reduce_to_get_highest_value() {
        Optional<Integer> resultOptional = integers.stream()
                .reduce(Integer::max);
        assertThat(resultOptional.get()).isEqualTo(7);
    }

    @Test
    void map_reduce() {
        Optional<Integer> resultOptional = StudentsListSupplier.get().stream()
                .map(Student::getNoteBooks)
                .reduce(Integer::sum);
        assertThat(resultOptional.get()).isEqualTo(189);
    }

}
