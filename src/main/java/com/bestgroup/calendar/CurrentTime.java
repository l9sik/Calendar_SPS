package com.bestgroup.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;


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
    public static String receiveCurrentTime(){
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String actualTime = formatterTime.format(date);
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd.MM.yyyy");
        String actualDate = formatterDate.format(date);
        actualTime += "\n" + actualDate;
        return actualTime;
    }



}
