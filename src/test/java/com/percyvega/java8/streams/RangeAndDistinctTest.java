package com.percyvega.java8.streams;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class RangeAndDistinctTest {

    @Test
    void range() {
        assertThat(IntStream.range(1, 10).count()).isEqualTo(9);

        assertThat(IntStream.range(10, 10).max()).isEmpty();

        assertThat(IntStream.range(10, 20).max().getAsInt()).isEqualTo(19);
    }

    @Test
    void rangeClosed() {
        assertThat(IntStream.rangeClosed(1, 10).count()).isEqualTo(10);

        assertThat(IntStream.rangeClosed(10, 10).max().getAsInt()).isEqualTo(10);

        assertThat(IntStream.rangeClosed(10, 20).max().getAsInt()).isEqualTo(20);
    }

    @Test
    void distinct() {
        List<Integer> integerList = Stream.of(2, 8, 8, 4, 4, 6, 7, 8, 8, 9, 9, 9)
                .distinct()
                .collect(Collectors.toList());

        assertThat(integerList).containsExactlyInAnyOrder(2, 8, 4, 6, 7, 9);
    }

}
