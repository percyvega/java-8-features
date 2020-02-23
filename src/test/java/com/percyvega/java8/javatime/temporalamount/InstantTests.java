package com.percyvega.java8.javatime.temporalamount;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class InstantTests {

    @Test
    void test0() {
        Instant now = Instant.now();
        log.info(now);

        Instant min = Instant.MIN;
        log.info(min);

        Instant max = Instant.MAX;
        log.info(max);
    }

    @Test
    void test1() {
        Instant instant = Instant.parse("1979-08-23T08:37:52.123456789Z");
        assertThat(instant.toString()).isEqualTo("1979-08-23T08:37:52.123456789Z");

        Instant instant1 = Instant.parse("1979-08-23T08:37:52.123456Z");
        assertThat(instant1.toString()).isEqualTo("1979-08-23T08:37:52.123456Z");

        Instant instant2 = Instant.parse("1979-08-23T08:37:52.1234Z");
        assertThat(instant2.toString()).isEqualTo("1979-08-23T08:37:52.123400Z");
    }

    @Test
    void test2() {
        Instant now = Instant.now();
        Instant now1 = Instant.now();

        Duration duration = Duration.between(now, now1);
        log.info(duration.toMillis());
        log.info(duration.toNanos());
    }

}
