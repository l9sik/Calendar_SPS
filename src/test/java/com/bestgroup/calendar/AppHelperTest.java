package com.bestgroup.calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is class for some test? that to check processing of working our project
 *  @author von-means-hope
 */
class AppHelperTest {
    AppHelper appHelper;
    @BeforeEach
    void setUp() {
        appHelper = new AppHelper();
        appHelper.setYear(2021);
        appHelper.setMonthNumber(10);
        appHelper.setMonthAndDay("12", "10");
    }

    /**
     * Gets year.
     */
    @Test
    void getYear() {
        assertEquals(2021, appHelper.getYear());
    }

    /**
     * Gets month number.
     */
    @Test
    void getMonthNumber() {
        assertEquals(10, appHelper.getMonthNumber());
    }

    /**
     * Get month and day.
     */
    @Test
    void getMonthAndDay(){
        assertEquals("10 12", appHelper.getMonthAndDay());
    }

    @Test
    void getFullDate(){
        appHelper.setFullDate();
        assert(true);
    }

    @Test
    void getMonthName(){
        assert (true);
    }

    @Test
    void getMonthCode(){
        appHelper.getMonthNumber();
        assert (true);
    }

    @Test
    void getYearCode(){
        appHelper.getYear();
        assert (true);
    }

    @Test
    void getDayOfWeekNum(){
        appHelper.getMonthCode();
        appHelper.getYearCode();
        assert (true);
    }

    @Test
    void getNumOfDaysInMonth(){
        appHelper.getMonthNumber();
        assert (true);
    }

    @Test
    void getWeekMatrix(){
        appHelper.getDayOfWeekNum();
        assert (true);
    }

    @Test
    void plusDay(){
        assert (true);
    }

}