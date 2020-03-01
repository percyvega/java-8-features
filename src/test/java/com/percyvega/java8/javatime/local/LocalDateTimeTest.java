package com.percyvega.java8.javatime.local;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

@Log4j2
class LocalDateTimeTest {

    @Test
    void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime);
    }

    @Test
    void test2() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 8, 23, 8, 0, 0, 123);
        log.info(localDateTime);
        log.info(localDateTime.getDayOfWeek());
    }

    @Test
    void test3() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(1979, 8, 23), LocalTime.of(8, 15));
        log.info(localDateTime);
    }

    @Test
    void test4() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime.getDayOfWeek());
        log.info(localDateTime.getDayOfMonth());
        log.info(localDateTime.getDayOfYear());
        log.info(localDateTime.getChronology());
        log.info(localDateTime.getMonth());
        log.info(localDateTime.get(ChronoField.HOUR_OF_AMPM));
    }

    @Test
    void test5() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime.get(ChronoField.AMPM_OF_DAY));
        log.info(localDateTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        log.info(localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
        log.info(localDateTime.get(ChronoField.ERA));
        log.info(localDateTime.getLong(ChronoField.EPOCH_DAY));
    }

    @Test
    void test6() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime);
        log.info(localDateTime.plusDays(2));
        log.info(localDateTime.plusHours(2));
        log.info(localDateTime.plusMinutes(2));
        log.info(localDateTime.plusSeconds(2));
        log.info(localDateTime.plusNanos(2));
    }

    @Test
    void test7() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime);
        log.info(localDateTime.withYear(1979));
    }

}
