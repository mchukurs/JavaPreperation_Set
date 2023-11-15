package com.chukurs;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        printData("email data", emails);
        List<Contact> phones = ContactData.getData("phone");
        printData("phone data", phones);
        System.out.println("-".repeat(10) + " NOW moving from Lists to Sets");
        //Crate hashSets from the Lists created by reading the String (can be created this way as both ar form of Collection)
        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        /*
        printData method takes any Collection,
        looks like duplicates are present in HashSet but that is not true. They are not duplicates as Hash is different
        + .equal() is false
        */
        printData("Email contacts", emailContacts);
        printData("Phone contacts", phoneContacts);
        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood forest");
        //test if we can add a duplicate
        robinHood.addEmail("Sherwood forest");
        //test the replace method
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.net");
        System.out.println(robinHood);

    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(10));
        System.out.println(header);
        System.out.println("-".repeat(10));
        contacts.forEach(System.out::println);
    }
}