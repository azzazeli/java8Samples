package oca.enthuware.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author AlexM
 **/
public class Q43 {
    public static boolean checkList(List list, Predicate<List> p){
        return p.test(list);
    }
    public static void main(String[] args) {
        boolean b = checkList(new ArrayList<>(), a1 -> a1.add("Hello"));
        System.out.println(b);

        "ssss".substring(-1);
        "ssss".intern();
    }
}
