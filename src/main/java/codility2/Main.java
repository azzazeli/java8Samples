package codility2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution("10:00", "13:22"));
        System.out.println(solution2("ahelloaaa"));

    }

    //todo: Analise other issues in this code
    static String solution2(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = occurrences[0];

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }


    public static int solution(String E, String L) {
        int result = 2; //initial fee
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startTime = LocalTime.from(dateTimeFormatter.parse(E));
        LocalTime endTime = LocalTime.from(dateTimeFormatter.parse(L));
        Duration duration = Duration.between(startTime, endTime);

        long seconds = duration.getSeconds();
        int hours = (int) Math.ceil((double)seconds/60/60);
        if(hours < 1){
            return result;
        }

        result+=3;
        hours--;

        if(hours > 0){
            result+= hours*4;
        }

        return result;
    }
}

