package com.percyvega.java8.streams.parallel;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ParallelStreamTest {

    private static final int BIG_NUMBER = 65000;

    public static int sequentialSum() {
        return IntStream
                .rangeClosed(1, BIG_NUMBER)
                .sum();
    }

    public static int parallelSum() {
        return IntStream
                .rangeClosed(1, BIG_NUMBER)
                .parallel()
                .sum();
    }

    @Test
    void run_sequential() {
        runManyTimes(ParallelStreamTest::sequentialSum, 20);
    }

    @Test
    void run_parallel() {
        runManyTimes(ParallelStreamTest::parallelSum, 20);
    }

    private void runManyTimes(Supplier<Integer> supplier, int times) {
        for (int i = 0; i < times; i++) {
            supplier.get();
        }
    }

}
