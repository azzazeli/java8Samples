package com.samples.java8.winterbe;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {


    @Test
    public void testEx1(){
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        //C1, C2
    }

    @Test
    public void testFindFirst(){
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
        //a1
    }

    @Test
    public void testReplaceForEach(){
        IntStream.range(1, 4)
                .forEach(System.out::println);
        //1 2 3
    }

    @Test
    public void testAverage(){
        Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n +1)
                .average()
                .ifPresent(System.out::println);
        //5.0
    }

    @Test
    public void testMapTo(){
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
        //3

        IntStream.range(1, 4)
                .mapToObj(value -> "a" + value)
                .forEach(System.out::println);
        //a1 a2 a3
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        //a1 a2 a3
    }

    @Test
    public void testProcessingOrder(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return true;
                });
        // nou output
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach:" + s));
    }

    @Test
    public void testProcessingOrder2(){
        Stream.of("d1", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .anyMatch( s-> {
                    System.out.println("anyMatch:" + s);
                    return  s.startsWith("A");
                });
    }

    @Test
    public void testProcessingOrder3(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach:" + s));
        //forEach:A2
    }

    @Test
    public void testSwitchOperationOrder(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach:" + s));
        //map:a2
    }

    @Test
    public void testStatefullOperation(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s \n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach:" + s));
        // sort is executed on the entire input collection
    }

    @Test(expected = IllegalStateException.class)
    public void testStreamReUsage(){
        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true);
        stream.noneMatch(s -> true);
    }

    @Test
    public void testStreamReUsage2(){
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));
        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);
    }

}
