package com.percyvega.java8.streams;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class NumericStreamsTest {

    @Test
    void intStream() {
        assertThat(IntStream.range(10, 13)
                .sum()).isEqualTo(10 + 11 + 12);

        assertThat(IntStream.rangeClosed(10, 13)
                .sum()).isEqualTo(10 + 11 + 12 + 13);

        assertThat(IntStream.generate(new Random()::nextInt)
                .limit(3)
                .count()).isEqualTo(3);

        assertThat(IntStream.iterate(1, (x) -> x + 1)
                .limit(3)
                .sum()).isEqualTo(6);

        assertThat(IntStream.of(4)
                .toArray()).isEqualTo(new int[]{4});

        assertThat(IntStream.of(8, 23, 1979)
                .sum()).isEqualTo(8 + 23 + 1979);

        assertThat(IntStream.of(8, 23, 1979)
                .boxed()
                .collect(Collectors.toList())).isEqualTo(Arrays.asList(8, 23, 1979));

        Stream<Integer> integerStream = Stream.of(8, 23, 1979);
        IntStream intStream = integerStream.mapToInt(Integer::intValue);
        intStream.forEach(value -> log.info("Unboxed (from Integer to int): " + value));
    }

    @Test
    void longStream() {
        assertThat(LongStream.range(10, 13)
                .sum()).isEqualTo(10 + 11 + 12);

        assertThat(LongStream.rangeClosed(10, 13)
                .sum()).isEqualTo(10 + 11 + 12 + 13);

        assertThat(LongStream.generate(new Random()::nextInt)
                .limit(3)
                .count()).isEqualTo(3);

        assertThat(LongStream.iterate(1, (x) -> x + 1)
                .limit(3)
                .sum()).isEqualTo(6);

        assertThat(LongStream.of(4)
                .toArray()).isEqualTo(new long[]{4});

        assertThat(LongStream.of(8, 23, 1979)
                .sum()).isEqualTo(8L + 23L + 1979L);

        assertThat(LongStream.of(8, 23, 1979)
                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
                .boxed()
                .collect(Collectors.toList())).isEqualTo(Arrays.asList(8, 23, 1979));

        Stream<Long> stream = Stream.of(8L, 23L, 1979L);
        IntStream intStream = stream.mapToInt(value -> Integer.parseInt(String.valueOf(value)));
        intStream.forEach(log::info);
    }

    @Test
    void doubleStream() {
        assertThat(DoubleStream.generate(new Random()::nextDouble)
                .limit(3)
                .count()).isEqualTo(3);

        assertThat(DoubleStream.iterate(1.5, (x) -> x + 1)
                .limit(3)
                .sum()).isEqualTo(7.5);

        assertThat(DoubleStream.of(4.5)
                .toArray()).isEqualTo(new double[]{4.5});

        assertThat(DoubleStream.of(8.5, 23.5, 1979.5)
                .sum()).isEqualTo(8.5 + 23.5 + 1979.5);

        assertThat(DoubleStream.of(8.5, 23.5, 1979.5)
                .mapToInt(value -> (int) value)
                .boxed()
                .collect(Collectors.toList())).isEqualTo(Arrays.asList(8, 23, 1979));

        Stream<Double> stream = Stream.of(8.5, 23.5, 1979.5);
        IntStream intStream = stream.mapToInt(value -> (int) Math.floor(value));
        intStream.forEach(log::info);
    }

}
