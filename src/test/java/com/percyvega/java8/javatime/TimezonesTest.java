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
    void zonedDateTimeTest() {
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
        assertThat(ZoneId.systemDefault().getRules().getTransitions().size()).isEqualTo(177);

        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        assertThat(zoneId.toString()).isEqualTo("America/Los_Angeles");
        assertThat(zoneId.normalized().toString()).isEqualTo("America/Los_Angeles");
        assertThat(zoneId.getId()).isEqualTo("America/Los_Angeles");

        assertThat(ZoneId.getAvailableZoneIds().size()).isEqualTo(600);

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime la = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        assertThat(ny.getHour()).isEqualTo((la.getHour() + 3) % 24);
        assertThat(ny.getMinute()).isEqualTo(la.getMinute());
        assertThat(ny.getSecond()).isEqualTo(la.getSecond());

        LocalDateTime nyLDT = LocalDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime laLDT = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));

        assertThat(nyLDT.getHour()).isEqualTo((laLDT.getHour() + 3) % 24);
        assertThat(nyLDT.getMinute()).isEqualTo(laLDT.getMinute());
        assertThat(nyLDT.getSecond()).isEqualTo(laLDT.getSecond());
    }

    @Test
    void zoneOffsetTest() {
        assertThat(ZoneOffset.systemDefault().toString()).isEqualTo("America/New_York");

        assertThat(ZoneOffset.getAvailableZoneIds().size()).isEqualTo(600);
    }


}
