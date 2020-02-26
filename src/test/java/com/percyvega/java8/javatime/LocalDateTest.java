package com.percyvega.java8.javatime;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LocalDateTest {

    @Test
    void test1() {
        LocalDate now = LocalDate.now();
        String nowString = now.toString();
        now.plus(2, ChronoUnit.DAYS);
        String nowAfterPlus2DaysString = now.toString();

        assertThat(nowString).isEqualTo(nowAfterPlus2DaysString);
    }

    @Test
    void test2() {
        log.info(LocalDate.now(Clock.systemUTC()));
        log.info(LocalDate.now(Clock.system(ZoneId.of("UTC-12"))));

        log.info(LocalDate.now(ZoneId.of("UTC")));
        log.info(LocalDate.now(ZoneId.of("UTC-12")));
    }

    @Test
    void test3() {
        log.info(LocalDate.of(1979, 8, 23));
        log.info(LocalDate.of(1986, Month.JANUARY, 19));
    }

    @Test
    void test4() {
        LocalDate localDate = LocalDate.ofYearDay(1979, 365);
        log.info(localDate);
        log.info(localDate.getEra());
        log.info(localDate.getChronology());
        log.info(localDate.getDayOfWeek());
        log.info(localDate.get(ChronoField.DAY_OF_WEEK));
    }

    @Test
    void test5() {
        LocalDate localDate = LocalDate.now();
        log.info(localDate);

        log.info(localDate.plusDays(-1));
        log.info(localDate.minusWeeks(1));
        log.info(localDate.minusMonths(1));
        log.info(localDate.plusYears(-1));

        log.info(localDate.withYear(1979));
        log.info(localDate.with(ChronoField.DAY_OF_MONTH, 1));
        log.info(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));

        log.info(localDate.plus(3, ChronoUnit.DAYS));
    }

    @Test
    void test6() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);

        log.info(today);
        log.info(yesterday);

        log.info(today.isEqual(yesterday));
        log.info(today.isBefore(yesterday));
        log.info(today.isAfter(yesterday));
    }

}
