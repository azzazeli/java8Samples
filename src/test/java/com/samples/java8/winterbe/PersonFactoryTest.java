package com.samples.java8.winterbe;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonFactoryTest {
    @Test
    public void create() throws Exception {
        PersonFactory<Person> factory = Person::new;
        Person person = factory.create("Alex", "M");
        System.out.println(person.firstName);
        System.out.println(person.lastName);
    }

}