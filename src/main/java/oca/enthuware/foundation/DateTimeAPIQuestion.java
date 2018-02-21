package oca.enthuware.foundation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeAPIQuestion {
    public static void main(String[] args) {
        exampleOfUsage();
    }

    private static void exampleOfUsage() {
        LocalDate d1 = LocalDate.of(2018, Month.APRIL, 1);
        LocalDateTime d2 = LocalDateTime.of(2018, Month.AUGUST, 11, 10, 00);
        LocalDateTime d3 = LocalDateTime.parse("2018-01-01T17:20:00");
        LocalDate d4 = LocalDate.parse("2017-04-11");
        LocalTime d5 = LocalTime.parse("17:22:11");
    }
}
