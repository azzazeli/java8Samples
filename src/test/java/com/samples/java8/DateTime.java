package com.samples.java8;

import org.junit.Ignore;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.*;
import static junit.framework.TestCase.assertFalse;

public class DateTime {

    @Test
    public void example1() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's local date:" + today);
        System.out.printf("Year:%d Month:%d day:%d5%n", today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        LocalDate date1 = LocalDate.of(2016, 01, 12);
        System.out.printf("Particular date:%s\n", date1);

        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.printf("Day after one week %s%n", nextWeek);

        LocalDate previousYear = today.minus(1, YEARS);
        System.out.printf("Date before 1 year:%s %n", previousYear);

        LocalDate nextYear = today.plus(1, YEARS);
        System.out.printf("Date after 1 year %s %n", nextYear);

        LocalDate tomorrow = LocalDate.of(2017, 8, 22);
        if(tomorrow.isAfter(today)){
            System.out.println("Tomorrow comes after today");
        }

        LocalDate yesterday = today.minus(1, DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("Yesterday is the day before today");
        }

    }

    @Test
    public void equals(){
        LocalDate date1 = LocalDate.of(2017, 8, 21);
        LocalDate now = LocalDate.now();
        if(now.equals(date1)){
            System.out.printf("Today:%s and date1:%s are the same %n", now, date1);
        }
    }

    @Test
    public void recurringEvents(){
        LocalDate dateOfBirth = LocalDate.of(1983, 4,11);
        MonthDay birthDay = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if(birthDay.equals(currentMonthDay)){
            System.out.printf("Many many happy returns of the day!!");
        }
        else{
            System.out.printf("Sorry, today is not your birthday");
        }

    }

    @Test
    public void testTime(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime newTime = now.plusHours(2);
        System.out.println(newTime);
    }

    @Test
    public void testClock(){
        Clock clock = Clock.systemUTC();
        System.out.printf("Clock : %s%n", clock.toString());

        Clock defaultClock = Clock.systemDefaultZone();
        System.out.printf("Clock : %s%n", defaultClock);
    }

    @Test
    public void testTimeZones(){
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime dateTimeInNewYork = ZonedDateTime.of(localDateTime, america);
        System.out.println("Current date time in particular timezone : "  + dateTimeInNewYork);
    }

    @Test
    public void yearMonth(){
        YearMonth yearMonth  = YearMonth.now();
        System.out.printf("Days in current year %s: %d %n", yearMonth.getYear(), yearMonth.lengthOfYear());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.APRIL);
        System.out.printf("Your credit card expires on: %s %n", creditCardExpiry);
    }

    @Test
    public void leapYear(){
        if(LocalDate.now().isLeapYear()){
            System.out.println("This year is a leap year");
        }
        else {
            System.out.println("Not a leap year");
        }
    }

    @Test
    public void testPeriod(){
        LocalDate java8DateRelease = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease = Period.between(LocalDate.now(), java8DateRelease);
        System.out.printf("Months left between today and java 8 release: %s", periodToNextJavaRelease.getMonths());
    }

    @Test
    public void testTimeZoneOffset(){
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        System.out.printf("Date and time with offset : %s", offsetDateTime);
    }

    @Test
    public void testInstant(){
        Instant timestamp = Instant.now();
        System.out.printf("What is value for the instant : %s", timestamp);
    }

    @Test
    public void testFormatting(){
        String day = "20150117";
        LocalDate formatted = LocalDate.parse(day, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from string: %s %s%n", day, formatted);

        String friday = "Apr 18 2015";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyy");
        LocalDate holiday = LocalDate.parse(friday, formatter);
        System.out.printf("Successfully parsed string %s, date is %s", friday, holiday);

    }

    @Test
    @Ignore
    public void testGC(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = now.plus(10, MINUTES);
        while(LocalDateTime.now().isBefore(end)){
             new String("sdasd"+LocalDateTime.now());
        }

    }

    @Test
    public void testZone(){
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zoneId1 = ZoneId.of("Europe/Berlin");
        ZoneId zoneId2 = ZoneId.of("Brazil/East");

        System.out.println(zoneId1.getRules());
        System.out.println(zoneId2.getRules());


        LocalTime now1 = LocalTime.now(zoneId1);
        LocalTime now2 = LocalTime.now(zoneId2);

        assertFalse(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

//        assertEquals(-4, hoursBetween);
//        assertEquals(-299, minutesBetween);

        Thread.yield();


    }



}
