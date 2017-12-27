package com.samples.java8.winterbe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapTest {

    class Foo{
        String name;
        List<Bar> bars = new ArrayList<>();

        public Foo(String name) {
            this.name = name;
        }
    }

    class Bar{
        String name;

        public Bar(String name) {
            this.name = name;
        }
    }

    List<Foo> foos = new ArrayList<>();

    @Before
    public void setup() {
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));
        foos
                .forEach(f ->
                        IntStream.range(1, 4)
                                .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
    }

    @Test
    public void testFlatMap(){
        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }
}
