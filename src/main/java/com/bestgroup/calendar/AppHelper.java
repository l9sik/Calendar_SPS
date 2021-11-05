package com.bestgroup.calendar;

import java.text.DateFormatSymbols;

/**
 * This class contains methods for some mathematical problems in the program.
 * @author l9sik
 */
public class AppHelper {
    /**
     * This 3 numbers are used to show correct data about date that user chose.
     */
    static private int year = 2021;
    static private int month = 4;
    static private int date = 0;

    public static void setDate(int dt){
        date = dt;
    }
    public static void setMonth(int mnth){
        month = mnth;
    }
    public static int getMonthNumber(){
        return month;
    }
    public static int getYear(){
        return year;
    }
    public static void setYear(int yr){
        year = yr;
    }

    public static String getMonthName(){
        int m = getMonthNumber();
        return new DateFormatSymbols().getMonths()[m-1];
    }
    public static int getMonthCode(){
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
    public static int getYearCode(){
        int yr = getYear();
        int lastTwoDigits = Integer.parseInt(Integer.toString(yr).substring(2));
        int index = (6 + lastTwoDigits + lastTwoDigits / 4) % 7;
        return index;
    }
    public static int getDayOfWeekNum() {
        int dayCode = 0;
        int monthCode = getMonthCode();
        int yearCode = getYearCode();
        int dayOfWeekNum = (dayCode + monthCode + yearCode) % 7;
        if ((getYear() % 4 == 0) && (getMonthNumber() > 2))
            dayOfWeekNum++;
        return dayOfWeekNum;
    }
    public static int getNumOfDaysInMonth(){
        int monthNumber = getMonthNumber();
        if (monthNumber == 2){
            if ((getYear() % 4) == 0)
                monthNumber = 29;
            else monthNumber = 28;
        }
        else if ((monthNumber == 4) || (monthNumber == 6) || (monthNumber == 9) || (monthNumber == 11))
            monthNumber = 30;
        else monthNumber = 31;
        return monthNumber;
    }
    public static int[][] getWeekMatrix(){
        int dayOfWeek = getDayOfWeekNum();
        int NumOfDaysInMonth = getNumOfDaysInMonth();
        int[][] weekMatrix = new int[7][5];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (i <= dayOfWeek)
            weekMatrix[i][0] = -1;
            else weekMatrix[i][0] = ++count;
        }
        for (int j = 1; j < 5; j++) {
            for (int i = 0; i < 7; i++){
                weekMatrix[i][j] = ++count;
                if (count > NumOfDaysInMonth){
                    weekMatrix[i][j] = -1;
                }
            }
        }
        return weekMatrix;
    }
}
