package com.example.tutorial;

import java.io.*;

import static com.example.tutorial.AddressBookProtos.AddressBook;
import static com.example.tutorial.AddressBookProtos.Person;

public class AddPerson {

    static Person PromptForAddress(BufferedReader stdin, PrintStream stdout) throws IOException {
        Person.Builder builder = Person.newBuilder();
        stdout.print("Enter person ID: ");
        builder.setId(Integer.parseInt(stdin.readLine()));

        stdout.print("Enter name: ");
        builder.setName(stdin.readLine());

        stdout.print("Enter email address (blank for none): ");
        String email = stdin.readLine();
        if (email.length() > 0) {
            builder.setEmail(email);
        }

        while (true) {
            stdout.print("Enter a phone number (or leave blank to finish):");
            String number = stdin.readLine();
            if (number.length() == 0) {
                break;
            }
            Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder().setNumber(number);
            stdout.print("Is this a mobile, home or work phone?");
            String type = stdin.readLine();
            switch (type) {
                case "mobile":
                    phoneNumber.setType(Person.PhoneType.MOBILE);
                    break;
                case "home":
                    phoneNumber.setType(Person.PhoneType.HOME);
                    break;
                case "work":
                    phoneNumber.setType(Person.PhoneType.WORK);
                    break;
                default:
                    stdout.println("Unknown phone type. Using default");
                    break;
            }

            builder.addPhones(phoneNumber);
        }
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: AddPerson ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        AddressBook.Builder addressBook = AddressBook.newBuilder();
        try {
            addressBook.mergeFrom(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + ": File not found. Creating new file.");
        }

        addressBook.addPeople(PromptForAddress(new BufferedReader(new InputStreamReader(System.in)), System.out));

        try (FileOutputStream output = new FileOutputStream(args[0])) {
            addressBook.build().writeTo(output);
        }

    }
}
