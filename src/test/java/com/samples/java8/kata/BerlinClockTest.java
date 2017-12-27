package com.samples.java8.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinClockTest {

    BerlinClock berlinClock = new BerlinClock();


    // Yellow lamp should blink on/off every two seconds
    @Test
    public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
        assertEquals("Y", berlinClock.getSeconds(0));
        assertEquals("O", berlinClock.getSeconds(1));
        assertEquals("O", berlinClock.getSeconds(59));
    }

    // Top hours should have 4 lamps
    @Test
    public void testTopHoursShouldHave4Lamps() {
        assertEquals(4, berlinClock.getTopHours(7).length());
    }

    // Top hours should light a red lamp for every 5 hours
    @Test
    public void testTopHoursShouldLightRedLampForEvery5Hours() {
        assertEquals("OOOO", berlinClock.getTopHours(0));
        assertEquals("RROO", berlinClock.getTopHours(13));
        assertEquals("RRRR", berlinClock.getTopHours(23));
        assertEquals("RRRR", berlinClock.getTopHours(24));
    }

    // Bottom hours should have 4 lamps
    @Test
    public void testBottomHoursShouldHave4Lamps() {
        assertEquals(4, berlinClock.getBottomHours(5).length());
    }

    @Test
    public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
        assertEquals("OOOO", berlinClock.getBottomHours(0));
        assertEquals("RRRO", berlinClock.getBottomHours(13));
        assertEquals("RRRO", berlinClock.getBottomHours(23));
        assertEquals("RRRR", berlinClock.getBottomHours(24));
    }

    // Top minutes should have 11 lamps
    @Test
    public void testTopMinutesShouldHave11Lamps() {
        assertEquals(11, berlinClock.getTopMinutes(34).length());
    }

    // Top minutes should have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter
    @Test
    public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
        String minutes32 = berlinClock.getTopMinutes(32);
        assertEquals("R", minutes32.substring(2, 3));
        assertEquals("R", minutes32.substring(5, 6));
        assertEquals("O", minutes32.substring(8, 9));
    }

    // Top minutes should light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter
    @Test
    public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
        assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
        assertEquals("YOOOOOOOOOO", berlinClock.getTopMinutes(7));
        assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(17));
        assertEquals("YYRYYRYYRYY", berlinClock.getTopMinutes(59));
    }

    // Bottom minutes should have 4 lamps
    @Test
    public void testBottomMinutesShouldHave4Lamps() {
        assertEquals(4, berlinClock.getBottomMinutes(0).length());
    }

    // Bottom minutes should light a yellow lamp for every minute left from top minutes
    @Test
    public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
        assertEquals("OOOO", berlinClock.getBottomMinutes(0));
        assertEquals("YYOO", berlinClock.getBottomMinutes(17));
        assertEquals("YYYY", berlinClock.getBottomMinutes(59));
    }


    // Berlin Clock should result in array with 5 elements
    @Test
    public void testBerlinClockShouldResultInArrayWith5Elements()  {
        assertEquals(5, berlinClock.convertToBerlinTime("13:17:01").length);
    }

    // Berlin Clock it should "result in correct seconds, hours and minutes" in {
    @Test
    public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
        String[] berlinTime = berlinClock.convertToBerlinTime("16:37:16");
        String[] expected = new String[] {"Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO"};
        assertEquals(expected.length, berlinTime.length);
        for (int index = 0; index < expected.length; index++) {
            assertEquals(expected[index], berlinTime[index]);
        }
    }


}