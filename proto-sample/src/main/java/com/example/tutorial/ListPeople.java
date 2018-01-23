package com.example.tutorial;

import java.io.FileInputStream;
import java.io.IOException;

import static com.example.tutorial.AddressBookProtos.AddressBook;
import static com.example.tutorial.AddressBookProtos.Person;

public class ListPeople {
    static void Print(AddressBook addressBook){
        for (Person person : addressBook.getPeopleList() ) {
            System.out.println("Person ID:" + person.getId());
            System.out.println(" Name:" + person.getName());
            if(person.hasEmail()){
                System.out.println(" E-mail address: " + person.getEmail());
            }

            for (Person.PhoneNumber phoneNumber : person.getPhonesList())  {
                switch (phoneNumber.getType()){
                    case HOME:
                        System.out.print(" Mobile phone #:");
                        break;
                    case WORK:
                        System.out.print(" Home phone #");
                        break;
                    case MOBILE:
                        System.out.print(" Work phone #:");
                }
                System.out.println(phoneNumber.getNumber());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if(args.length!=1){
            System.err.println("Usage: ListPeople ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(args[0]));
        Print(addressBook);

    }
}
