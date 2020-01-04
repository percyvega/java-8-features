package com.percyvega.java8.streams.intermediatestateful;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SkipTest {

    static List<Integer> integerList;

    @BeforeAll
    static void beforeAll() {
        integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    void testSkip() {
        assertThat(integerList.stream().skip(8).count()).isEqualTo(2);
        assertThat(integerList.stream().skip(8).mapToInt(Integer::intValue).sum()).isEqualTo(19);
    }

}
