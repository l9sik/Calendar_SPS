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

}