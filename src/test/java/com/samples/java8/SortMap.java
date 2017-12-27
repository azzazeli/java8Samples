package com.samples.java8;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class SortMap {

    private static Map<String, Integer> budget = new HashMap<>();

    @BeforeClass
    public static void setUp(){
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);
    }

    @Test
    public void wrong(){
        System.out.println("---------------wrong----------------");
        System.out.println("before sorting");
        System.out.println(budget);
        Map sorted = budget
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2));
        System.out.println("after sorting");
        System.out.println(sorted);

   }

   @Test
    public void good(){
       System.out.println("---------------good----------------");
       System.out.println("before sorting");
       System.out.println(budget);
       Map sorted = budget
               .entrySet()
               .stream()
               .sorted(comparingByKey())
               .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
       System.out.println("after sorting");
       System.out.println(sorted);
   }


}
