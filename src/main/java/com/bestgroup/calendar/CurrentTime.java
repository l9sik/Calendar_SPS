package com.bestgroup.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This class helps to display time in program
 * @version 1.0
 * @author eviv2206
 */

public class CurrentTime {
    public static String currentTime;

    /**
     *
     * @return currentTime as a string without updating
     */
    public String getCurrentTime(){
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String currentTime = formatterTime.format(date);
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = formatterDate.format(date);
        currentTime += "\n" + currentDate;
        return currentTime;
    }

}
