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
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        currentTime = formatter.format(date);
        return currentTime;
    }

}
