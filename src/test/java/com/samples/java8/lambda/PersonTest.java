package com.samples.java8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PersonTest {

    private List<Person> persons;

    private static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    private static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    private static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private static void printPersonsWithPredicate(List<Person> persons, Predicate<Person> tester) {
        for (Person person : persons) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }

    private static void processPersons(List<Person> persons, Predicate<Person> tester, Consumer<Person> roster) {
        for (Person person : persons) {
            if (tester.test(person)) {
                roster.accept(person);
            }
        }
    }

    private static void processPersonsWithFunction(List<Person> persons, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block){
        for (Person person : persons) {
            if(tester.test(person)){
                String data = mapper.apply(person);
                block.accept(data);
            }
        }
    }

    private static <X,Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X,Y> mapper, Consumer<Y> block){
        for (X x : source) {
            if(tester.test(x)){
                Y data = mapper.apply(x);
                block.accept(data);
            }
        }
    }


    @Before
    public void setUp() throws Exception {
        persons = Arrays.asList(
                new Person("Misa", 22, LocalDate.of(2000, 11, 20), Person.Sex.MALE, "misa@gmail.com"),
                new Person("Grisa", 22, LocalDate.of(1990, 01, 20), Person.Sex.MALE, "grisa@gmail.com"),
                new Person("Valea", 24, LocalDate.of(2001, 9, 2), Person.Sex.FEMALE, "valea@gmail.com"),
                new Person("Galea", 34, LocalDate.of(1992, 9, 2), Person.Sex.FEMALE, "galea@gmail.com"),
                new Person("Fedea", 29, LocalDate.of(2001, 9, 2), Person.Sex.MALE, "fedea@gmail.com"));
    }

    @Test
    public void printPerson() throws Exception {
        System.out.println("------------Persons older than 24------------");
        printPersonsOlderThan(persons, 24);
        System.out.println("------------Persons within age range 22 and 25------------");
        printPersonsWithinAgeRange(persons, 22, 25);
        System.out.println("------------Print persons eligible for selective service------------");
        printPersons(persons, new CheckPersonEligibleForSelectiveService());
    }

    @Test
    public void testAnonymousClass() {
        System.out.println("------------AnonymousClass implementation------------");
        printPersons(persons, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
    }

    @Test
    public void testLambda() {
        System.out.println("------------lambda expression------------");
        printPersons(persons, p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
    }

    @Test
    public void testPrintPersonsWithPredicate() {
        System.out.println("------------printPersonsWithPredicate------------");
        printPersonsWithPredicate(persons, person -> person.getAge() <= 25);
    }

    @Test
    public void testProcessPersons() {
        System.out.println("------------ProcessPersons------------");
        processPersons(persons,
                person -> person.getAge() >= 18,
                Person::printPerson);
    }

    @Test
    public void testProcessPersonsWithFunction(){
        System.out.println("------------testProcessPersonsWithFunction------------");
        processPersonsWithFunction(persons,
                person -> person.getAge()>=22,
                person -> person.getEmailAddress(),
                email -> System.out.println(email));
    }

    @Test
    public void testProcessElements(){
        System.out.println("------------testProcessElements------------");
        processElements(persons,
                person -> person.getAge()>=18,
                person -> person.getEmailAddress(),
                email -> System.out.println(email));
    }

    @Test
    public void testUseStreams(){
        persons
                .stream()
                .filter(person -> person.getAge()>18)
                .map(person -> person.getEmailAddress())
                .forEach(System.out::println);
    }

}