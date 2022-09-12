package com.jio.parkinglot.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {


    public static Date addMinutesInCurrentTime(int ttlMins) {
        LocalDateTime dateTime = LocalDateTime.now().plus(Duration.of(ttlMins, ChronoUnit.MINUTES));
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
