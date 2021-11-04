package com.bestgroup.calendar;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * This class helps to display time in program
 * @version 1.0
 * @author eviv2206
 */

public class CurrentTime {
    /**
     *
     * @return currentTime as a string without updating
     */
    public static String receiveCurrentTime(String str){
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        Instant nowUtc = Instant.now();
        ZoneId zone = ZoneId.of(str);
        ZonedDateTime timeNow = ZonedDateTime.ofInstant(nowUtc, zone);
        return format.format(timeNow);
    }

    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

}
