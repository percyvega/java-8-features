package com.percyvega.java8.javatime.local;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

@Log4j2
class LocalTimeTest {

    @Test
    void test1() {
        LocalTime localTime = LocalTime.now();
        log.info(localTime);

        LocalTime localTime1 = LocalTime.MAX;
        log.info(localTime1);

        LocalTime localTime2 = LocalTime.MIDNIGHT;
        log.info(localTime2);

        LocalTime localTime3 = LocalTime.MIN;
        log.info(localTime3);
    }

    @Test
    void test2() {
        LocalTime localTime1 = LocalTime.of(8, 45);
        log.info(localTime1);

        LocalTime localTime2 = LocalTime.of(8, 45, 23);
        log.info(localTime2);

        LocalTime localTime3 = LocalTime.of(8, 45, 23, 632);
        log.info(localTime3);
    }

    @Test
    void test3() {
        LocalTime localTime = LocalTime.now();
        log.info(localTime);

        log.info(localTime.getHour());
        log.info(localTime.getMinute());
        log.info(localTime.getSecond());
        log.info(localTime.getNano());
    }

    @Test
    void test4() {
        LocalTime localTime = LocalTime.now();
        log.info(localTime);

        log.info(localTime.minusHours(1));
        log.info(localTime.plusMinutes(32));

        log.info(localTime.withMinute(44));

        log.info(localTime.with(ChronoField.HOUR_OF_DAY, 3));
    }
}
