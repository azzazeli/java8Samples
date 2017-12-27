package com.samples.java8.javarevisited;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExamplesTest {
    List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

    @Test
    public void testExample1(){
        Thread thread = new Thread(() -> System.out.println("Lambda expressions rocks"));
        thread.start();
    }

    @Test
    public void testExample4(){

        System.out.println("Languages which starts with J");
        filter(languages, s -> s.startsWith("J"));
        System.out.println("Languages which ends with a");
        filter(languages, s -> s.endsWith("a"));
        System.out.println("Print all languages");
        filter(languages, s -> true);
        System.out.println("Print no languages ");
        filter(languages,s -> false);
        System.out.println("Print all languages whose length is greater than 4");
        filter(languages, s -> s.length()>4);
    }


    @Test
    public void testExample5(){
        Predicate<String> startsWithJ = (String n) -> n.startsWith("J");
        Predicate<String> _4LetterLong = (String n) -> n.length() == 4;
        languages
                .stream()
                .filter(startsWithJ.and(_4LetterLong))
                .forEach(s -> System.out.println("starts with J and length ==4 :" + s ));
    }

    @Test
    public void testExample6(){
//        Map reduce
        List<Integer> costBeforeTax = Arrays.asList(100,200, 300, 400, 500);
        costBeforeTax
                .stream()
                .map(integer -> integer + integer*0.12)
                .forEach(System.out::println);

        double bill = costBeforeTax
                .stream()
                .map(integer -> integer + integer*0.12)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println(String.format("Total bill:%s", bill));
    }


    @Test
    public void testExample7(){
        List<String> strList = Arrays.asList("abc","bcd", "defg", "jk");
        List<String> filtered = strList
                .stream()
                .filter(s -> s.length()>2)
                .collect(Collectors.toList());
        System.out.println(String.format("Original list:%s , filtered:%s", strList, filtered));

    }

    @Test
    public void testExample8(){
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K", "Canada");
        String G7Countries = G7
                .stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    @Test
    public void testExample9(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers
                .stream()
                .map(i->i*i)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(String.format("original list: %s, square without duplicates: %s", numbers,distinct));
    }

    @Test
    public void testExample10(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes
                .stream()
                .mapToInt(value -> value)
                .summaryStatistics();
        System.out.println("Highest prime number is: " + stats.getMax());
        System.out.println("Lowest prime number is: " + stats.getMin());
        System.out.println("Sum of all prime numbers is: " + stats.getSum());
        System.out.println("Average of all prime numbers is: " + stats.getAverage());
    }


    public static void filter(List<String> names, Predicate<String> condition){
        names.stream().filter(condition).forEach(System.out::println);
    }

    public static void filter2(List<String> names, Predicate<String> condition){
        for (String name :names) {
            if(condition.test(name)){
                System.out.println(name + " ");
            }
        }
    }

}
