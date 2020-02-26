package com.percyvega.java8.javatime;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
@Log4j2
public class TimezonesTest {

    @Test
    void timezonesTest() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String localDateTimeString = zonedDateTime.toLocalDateTime().toString();
        String offsetString = zonedDateTime.getOffset().toString();
        String zoneString = zonedDateTime.getZone().toString();
        assertThat(localDateTimeString + offsetString + "[" + zoneString + "]");

        assertThat(zonedDateTime.getChronology().toString()).isEqualTo("ISO");
    }

    @Test
    void zoneIdTest() {
        assertThat(ZoneId.systemDefault().toString()).isEqualTo("America/New_York");

        assertThat(ZoneId.getAvailableZoneIds().size()).isEqualTo(600);
    }

    @Test
    void zoneOffsetTest() {
        assertThat(ZoneOffset.systemDefault().toString()).isEqualTo("America/New_York");

        assertThat(ZoneOffset.getAvailableZoneIds().size()).isEqualTo(600);
    }


}
