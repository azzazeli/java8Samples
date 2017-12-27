package com.samples.java8;
import com.samples.java8.lambda.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuiltInFunctionsTest {

//    Predicates are boolean-valued functions of one argument.
    @Test
    public void testPredicate(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        assertTrue(predicate.test("foo"));
        assertFalse(predicate.negate().test("foo"));


        Predicate<Boolean> notNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> notEmpty = isEmpty.negate();
    }

//    Functions accept one argument and produce a result.
    @Test
    public void testFunctions(){
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));
    }

//    Suppliers produce a result of a given generic type
    @Test
    public void testSuppliers(){
        Supplier<Person> personSupplier = Person::new;
        assertNotNull(personSupplier.get());
    }

//    Consumer represents operations to be performed on a single input argument
    @Test
    public void testConsumer(){
        Consumer<Person> greeter = (person -> System.out.println("Hello " + person.getName()));
        greeter.accept(new Person("Alex", 22,null, null, null ));
    }

//    Comparator
    @Test
    public void testComparator(){
        Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Person person1 = new Person("Alex");
        Person person2 = new Person("Ion");
        assertTrue(comparator.compare(person1, person2)<0);
        assertTrue(comparator.reversed().compare(person1, person2)>0);
    }

    @Test
    public void testOptionals(){
        Optional<String> optional = Optional.of("bam");
        assertTrue(optional.isPresent());
        assertEquals("bam", optional.get());
        assertEquals("bam",optional.orElse("other"));

        optional.ifPresent( (s) -> System.out.println(s));
    }




}
