package com.samples.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreamsTest {

    private List<String> stringCollection = new ArrayList<>();
    {

        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    @Test
    public void testFilter(){
        stringCollection
                .stream()
                .filter((f) -> f.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void testSorted(){
        stringCollection
                .stream()
                .sorted()
                .forEach(System.out::println );
        System.out.println(stringCollection);
    }

    @Test
    public void testMap(){
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println );
    }

    @Test
    public void testMatch(){
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch(s -> s.startsWith("a"));
        assertTrue(anyStartsWithA);

        boolean allStartsIwthA = stringCollection
                .stream()
                .allMatch(s -> s.startsWith("a"));
        assertFalse(allStartsIwthA);

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch(s -> s.startsWith("z"));
        assertTrue(noneStartsWithZ);

    }

    @Test
    public void testCount() {
        long startsWithB = stringCollection
                .stream()
                .filter(f -> f.startsWith("b"))
                .count();
        assertEquals(3L, startsWithB);
    }


    @Test
    public void testReduce(){
        Optional<String> reduced = stringCollection
                .stream()
                .sorted()
                .reduce((s, s2) -> {
                    return s + "#" + s2;
                });
        reduced.ifPresent(System.out::println);
    }
}
