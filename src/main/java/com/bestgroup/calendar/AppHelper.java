package com.bestgroup.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

/**
 * This class contains methods for some mathematical problems in the program.
 *
 * @author l9sik
 */
public class AppHelper {

    private static  int year = 0;
    private static  int monthNumber = 0;
    private static String fullDate = null;
    private static String date = null;
    private static String monthAndDay;

    /**
     * Setter for year-variable
     * @param yr number of year that should be set
     */
    public static void setYear(int yr) {
        year = yr;
    }
    /**
     * Setter for date-variable
     * @param dt line of date that should be set
     */
    public static void setDate(String dt) {
        date = dt;
    }
    /**
     * Setter for year-variable
     * @param dy day in string format
     * @param mnth month in string format
     */
    public static void setMonthAndDay(String dy, String mnth) {
        monthAndDay = mnth + " " + dy;
    }

    /**
     * Setter for month-variable
     * @param mnthNum month number
     */
    public static void setMonthNumber(int mnthNum) {
        monthNumber = mnthNum;
    }

    /**
     * Sets fulldate-variable if "yyyy-MM-dd"-format
     */
    public static void setFullDate() {
        try {
            if (monthNumber < 10 && Integer.parseInt(date) < 10) {
                fullDate = getYear() + "-" + "0" + getMonthNumber() + "-" + "0" + date;
            } else if (Integer.parseInt(date) < 10) {
                fullDate = year + "-" + monthNumber + "-" + "0" + date;
            } else if (monthNumber < 10) {
                fullDate = year + "-" + "0" + monthNumber + "-" + date;
            } else {
                fullDate = year + "-" + monthNumber + "-" + date;
            }
        }catch (NumberFormatException e){
            CurrentTime.setCurrentDate();
            fullDate = CurrentTime.getCurrentDate();
        }
    }

    /**
     * getter for monthAndDay-variable
     * @return monthAndDay string
     */
    public static String getMonthAndDay() {
        return monthAndDay;
    }

    /**
     * getter for fullDate-variable
     * @return fullDate
     */
    public static String getFullDate() {
        setFullDate();
        return fullDate;
    }

    /**
     * getter for monthNumber-variable
     * @return monthNumber
     */
    public static int getMonthNumber() {
        return monthNumber;
    }

    /**
     * getter for year-variable
     * @return year
     */
    public static int getYear() {
        return year;
    }

    /**
     * Returns the name of Month
     * @return month name
     */
    public static String getMonthName() {
        Month month = Month.of(monthNumber);
        Locale loc = Locale.forLanguageTag("ru");
        String monthName = month.getDisplayName(TextStyle.FULL_STANDALONE, loc);
        String removedStr = monthName.substring(1);
        String firstLetter = monthName.substring(0, 1).toUpperCase();
        monthName = firstLetter + removedStr;
        return monthName;
    }

    public static int getMonthCode() {
        int index = getMonthNumber();
        if ((index == 1) || (index == 10))
            index = 1;
        else if (index == 5)
            index = 2;
        else if (index == 8)
            index = 3;
        else if ((index == 2) || (index == 3) || (index == 11))
            index = 4;
        else if (index == 6)
            index = 5;
        else if ((index == 9) || (index == 12))
            index = 6;
        else if ((index == 4) || (index == 7))
            index = 0;
        return index;
    }

    public static int getYearCode() {
        int yr = getYear();
        int lastTwoDigits = Integer.parseInt(Integer.toString(yr).substring(2));
        return (6 + lastTwoDigits + lastTwoDigits / 4) % 7;
    }

    /**
     * Finds day of week (Sunday - 0, Friday - 7)
     * @return The number of day in week
     */
    public static int getDayOfWeekNum() {
        int dayCode = 0;
        int monthCode = getMonthCode();
        int yearCode = getYearCode();
        int dayOfWeekNum = (dayCode + monthCode + yearCode) % 7;
        if ((getYear() % 4 == 0) && (getMonthNumber() > 2))
            dayOfWeekNum++;
        return dayOfWeekNum;
    }

    /**
     * @return Number of days in month
     */
    public static int getNumOfDaysInMonth() {
        int monthNumber = getMonthNumber();
        if (monthNumber == 2) {
            if ((getYear() % 4) == 0)
                monthNumber = 29;
            else monthNumber = 28;
        } else if ((monthNumber == 4) || (monthNumber == 6) || (monthNumber == 9) || (monthNumber == 11))
            monthNumber = 30;
        else monthNumber = 31;
        return monthNumber;
    }

    /**
     * Gets 7 x 6 table of week
     * @return 7 x 6 matrix in integer
     */
    public static int[][] getWeekMatrix() {
        int dayOfWeek = getDayOfWeekNum();
        int numOfDaysInMonth = getNumOfDaysInMonth();
        int[][] weekMatrix = new int[7][6];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (i <= dayOfWeek)
                weekMatrix[i][0] = -1;
            else weekMatrix[i][0] = ++count;
        }
        for (int j = 1; j < 6; j++) {
            for (int i = 0; i < 7; i++) {
                weekMatrix[i][j] = ++count;
                if (count > numOfDaysInMonth) {
                    weekMatrix[i][j] = -1;
                }
            }
        }
        return weekMatrix;
    }

    /**
     * Adds a numOfDays days to choice date
     * @param date String in format "yyyy-MM-dd"
     * @param numOfDays number of days to add
     * @return String in format "yyyy-MM-dd"
     */
    public static String plusDay(String date, int numOfDays){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try{
            if (date == null) {
                CurrentTime.setCurrentDate();
                date = CurrentTime.getCurrentDate();
            }
            calendar.setTime(sdf.parse(date));
        }catch(ParseException e){
            e.printStackTrace();
        }
        calendar.add(Calendar.DAY_OF_MONTH, numOfDays);
        return sdf.format(calendar.getTime());
    }
}
