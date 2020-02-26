package com.percyvega.java8.javatime;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class JavaTimeConversionsTest {

    LocalTime localTime = LocalTime.now();
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    @Test
    void test1() {
        LocalDateTime actual = localDate.atTime(localTime);
        assertThat(actual).isEqualTo(localDateTime);
        log.info(actual);
    }

    @Test
    void test2() {
        LocalDateTime actual = localTime.atDate(localDate);
        assertThat(actual).isEqualTo(localDateTime);
        log.info(actual);
    }

    @Test
    void test3() {
        assertThat(localDateTime.toLocalDate()).isEqualTo(localDate);
        assertThat(localDateTime.toLocalTime()).isEqualTo(localTime);
    }

}
