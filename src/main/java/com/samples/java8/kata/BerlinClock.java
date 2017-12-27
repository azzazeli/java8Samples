package com.samples.java8.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.samples.java8.kata.BerlinClock.LAMP_COLOR.*;

public class BerlinClock {

    private final int hourRowLength = 4;
    private final int minuteTopRowLength = 11;
    private final int minuteBottomRowLength = 4;

    public BerlinClock() {
    }

    public String getTopHours(int i) {
        return getHours(i, i / 5);
    }

    public String getBottomHours(int i) {
        return getHours(i, i % 5);
    }

    private String getHours(int i, int nrOfLamps ){
        List<LAMP_COLOR> lamps = new ArrayList<>(Collections.nCopies(hourRowLength, OFF));
        populateLamps(lamps, nrOfLamps,  RED, nr -> nr);
        return lampsToString(lamps);
    }

    public String getTopMinutes(int i){
        List<LAMP_COLOR> lamps = new ArrayList<>(Collections.nCopies(minuteTopRowLength, OFF));
        populateLamps (lamps, i/5, YELLOW, nr -> nr );
        populateLamps (lamps, i/15, RED, nr -> (nr + 1)*3 -1 );
        return lampsToString(lamps);
    }

    private  void populateLamps(List<LAMP_COLOR> lamps, int nr, LAMP_COLOR color, Function<Integer, Integer> function){
        for (int i = 0; i < nr; i++) {
            lamps.set(function.apply(i), color);
        }
    }

    private String lampsToString(List<LAMP_COLOR> firstRow) {
        return firstRow
                .stream()
                .map(lamp_color -> lamp_color.code)
                .collect(Collectors.joining());
    }

    public String getBottomMinutes(int i) {
        List<LAMP_COLOR> lamps = new ArrayList<>(Collections.nCopies(minuteBottomRowLength, OFF));
        populateLamps (lamps, i% 5, YELLOW, nr -> nr );
        return lampsToString(lamps);
    }

    public String[] convertToBerlinTime(String s) {
        int[] parts = Stream.of(s.split(":")).mapToInt(Integer::parseInt).toArray();
        return new String[]{
                getSeconds(parts[2]),
                getTopHours(parts[0]),
                getBottomHours(parts[0]),
                getTopMinutes(parts[1]),
                getBottomMinutes(parts[1])
        };
    }


    public enum LAMP_COLOR {
        YELLOW("Y"), RED("R"), OFF("O");
        private final String code;

        LAMP_COLOR(String s) {
            this.code = s;
        }

        public String getCode() {
            return code;
        }
    }

    public String getSeconds(int i) {
        return ( i % 2 == 0 ) ? YELLOW.code : OFF.code;
    }
}
