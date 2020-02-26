package com.percyvega.java8.javatime.temporalamount;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class DurationTest {

    @Test
    void test0() {
        Duration duration = Duration.of(5, ChronoUnit.DAYS);
        assertThat(duration.toHours()).isEqualTo(5 * 24);

        Duration duration1 = Duration.ofDays(10);
        assertThat(duration1.toHours()).isEqualTo(10 * 24);

        Duration duration2 = Duration.ofHours(10);
        assertThat(duration2.toHours()).isEqualTo(10);

        Duration duration3 = Duration.ofMinutes(10);
        assertThat(duration3.toHours()).isEqualTo(0);
        assertThat(duration3.toMinutes()).isEqualTo(10);
    }

    @Test
    void test1() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.plusMinutes(120);

        Duration duration = Duration.between(localTime, localTime1);

        assertThat(duration.toMinutes()).isEqualTo(2 * 60);
    }

}
