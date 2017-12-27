package com.samples.java8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapTest {

    Map<Integer, String> map = new HashMap<>();
    {
        for(int i=0; i< 10; i++){
            map.putIfAbsent(i, "val:" + i);
        }
    }


    @Test
    public  void test1(){
        map.forEach((k, v) -> System.out.println(v));
    }

    @Test
    public void testCompute(){
        map.computeIfPresent(3, (key, value) -> value + key);
        assertEquals("val:33",map.get(3));

        map.computeIfPresent(9, (key, value) -> null);
        assertFalse(map.containsKey(9));

        map.computeIfAbsent(23, integer -> "val:" + integer);
        assertTrue(map.containsKey(23));

        map.computeIfAbsent(3, integer -> "bam");
        assertEquals("val:33", map.get(3));

        assertEquals("default", map.getOrDefault(44,"default"));

        map.remove(3, "val3");
        assertTrue(map.containsKey(3));

        map.remove(3, "val:33");
        assertNull(map.get(3));


        map.merge(9, "val9", (value, newValue) -> {
            return value.concat(newValue);
        });
        assertEquals("val9", map.get(9));

        map.merge(9, "concat", (value, newValue) -> {
            return value.concat(newValue);
        });
        assertEquals("val9concat", map.get(9));

    }

}
