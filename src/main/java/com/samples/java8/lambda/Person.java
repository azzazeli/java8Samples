package com.samples.java8.lambda;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    private String name;
    private int age;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return new ToStringBuilder(this).
                append("name", name).
                append("age", age).
                append("birthday", birthday).
                append("gender", gender).
                append("emailAddress", emailAddress).toString();
    }

    public void printPerson() {
        System.out.println(this.toString());
    }
}
