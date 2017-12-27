package com.samples.java8.winterbe;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedStreamsTest {

    public class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    List<Person> persons =
            Arrays.asList(
                    new Person("Max", 18),
                    new Person("Peter", 23),
                    new Person("Pamela", 23),
                    new Person("David", 12));


    @Test
    public void testEx1() {
        List<Person> filtered = persons.stream()
                .filter(p -> p.name.startsWith("P"))
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    @Test
    public void testGroupBy(){
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge.forEach((age, list) -> System.out.format("age %s, %s\n", age, list));
    }

    @Test
    public void testCollectAverage(){
        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);
    }

    @Test
    public void testSummaryStatistics(){
        IntSummaryStatistics ageSummary =
                persons
                .stream()
                .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(ageSummary);
    }

    @Test
    public void testPhraseWithCollect(){
        String phrase =
                persons
                .stream()
                .filter(p -> p.age >= 18)
                .map( p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age"));
        System.out.println(phrase);
    }

    @Test
    public void testToMap(){
        Map<Integer, String> map =
                persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2
                ));
        System.out.println(map);
    }

    @Test
    public void testNewCollectr(){
        Collector<Person, StringJoiner, String> collector =
                Collector.of(
                        () -> new StringJoiner(" | "),
                        (j, p) -> j.add(p.name.toUpperCase()),
                        (j1, j2) -> j1.merge(j2),
                        StringJoiner::toString
                );
        String names  =
                persons
                .stream()
                .collect(collector);
        System.out.println(names);
    }

    @Test
    public void testMapReduce(){
        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);
        //Pamela
    }

    @Test
    public void testMapReduce2(){
        Person result = persons
                .stream()
                .reduce(new Person("",0), (p1, p2) ->{
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });
        System.out.format("name=%s, age=%s",result.name, result.age);
    }

    @Test
    public void reduce3(){
        Integer ageSum = persons
                .stream()
                .reduce(0,
                        (sum, p) ->{
                            System.out.format("accumulator: sum=%s, person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s, sum2=%s", sum1, sum2);
                            return sum1 + sum2;                        }
                        );
        System.out.println(ageSum);
    }

    @Test
    public void reduce4(){
        Integer ageSum = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) ->{
                            System.out.format("accumulator: sum=%s, person=%s [%s]\n", sum, p, Thread.currentThread().getName());
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s, sum2=%s [%s]\n", sum1, sum2,Thread.currentThread().getName());
                            return sum1 + sum2;
                        }
                );
        System.out.println(ageSum);


    }

    @Test
    public void testParallelism(){
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }




}
