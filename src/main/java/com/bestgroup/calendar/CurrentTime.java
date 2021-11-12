package com.bestgroup.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



/**
 * This class helps to display time in program
 * @version 1.0
 * @author eviv2206
 */

public class CurrentTime {

    private static final String TIME_FORMAT = "dd-MM-yyyy hh:mm:ss a";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String YEAR_FORMAT = "yyyy";
    private static final String MONTH_FORMAT = "MM";
    private static final String DAY_FORMAT = "dd";
    private static String date;

    public static void setYear(){
        DateFormat dateFormat = new SimpleDateFormat(YEAR_FORMAT);
        Date dt = new Date();
        String year = dateFormat.format(dt);
        AppHelper.setYear(Integer.parseInt(year));
    }

    public static void setMonthAndDay(){
        DateFormat dateFormat = new SimpleDateFormat(MONTH_FORMAT);
        Date dt = new Date();
        String monthNumber = dateFormat.format(dt);
        DateFormat dF = new SimpleDateFormat(DAY_FORMAT);
        String day = dF.format(dt);
        AppHelper.setDate(day);
        AppHelper.setMonthNumber(Integer.parseInt(monthNumber));
        String month = AppHelper.getMonthName();
        AppHelper.setMonthAndDay(day, month);
    }

    public static void setCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date dt = new Date();
        date = dateFormat.format(dt);
    }

    public static void resetDate(){
        date = null;
        AppHelper.setDate(date);
    }

    public static String getCurrentDate(){
        return date;
    }
    public static String getCurrentTime(String str){
        DateTimeFormatter format = DateTimeFormatter.ofPattern(TIME_FORMAT);
        Instant nowUtc = Instant.now();
        ZoneId zone = ZoneId.of(str);
        ZonedDateTime timeNow = ZonedDateTime.ofInstant(nowUtc, zone);
        return format.format(timeNow);
    }

}
