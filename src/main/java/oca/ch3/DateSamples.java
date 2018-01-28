package oca.ch3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateSamples {
    public static void main(String[] args) {
//        LocalDate localDate = new LocalDate(); //DOES NOT COMPILE
//        LocalDate.of(2018, 88, 1);//DateTimeException
        LocalDate localDate =LocalDate.of(2018,2,2);
        localDate.plusDays(2);
        System.out.println(localDate);

        Period wrong = Period.ofWeeks(2).ofDays(1);
        System.out.println(wrong);

        DateSamples samples = new DateSamples();
        samples.testDateTimeFormater();
        samples.test1();
    }

    private void testDateTimeFormater(){
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(LocalDate.now()));
        System.out.println(shortDateTime.format(LocalDateTime.now()));
//        System.out.println(shortDateTime.format(LocalTime.now())); //UnsupportedTemporalTypeException


        System.out.println(LocalDateTime.now().format(shortDateTime));
        System.out.println(LocalDate.now().format(shortDateTime));
//        System.out.println(LocalTime.now().format(shortDateTime));//UnsupportedTemporalTypeException
    }

    private void test1(){
        System.out.println("==================");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm");
        f.format(LocalTime.now());
        f.format(LocalDateTime.now());
//        f.format(LocalDate.now());//UnsupportedTemporalTypeException
    }
}
