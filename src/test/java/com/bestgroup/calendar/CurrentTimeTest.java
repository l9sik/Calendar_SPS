package com.bestgroup.calendar;


import org.junit.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class CurrentTimeTest {

    @Test
    public void testGetCurrentTime() throws IOException {
        // Setup
        String currentTime = "09:47";
        String expectedResult = currentTime;
        CurrentTime ct = new CurrentTime();

        // Run
        String result = ct.receiveCurrentTime(expectedResult);

        // Verify
        assertEquals(result, expectedResult);

    }
}