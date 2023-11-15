package com.chukurs;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        printData("emails", emails);
        List<Contact> phone = ContactData.getData("phone");
        printData("phone", emails);
    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(10));
        System.out.println(header);
        System.out.println("-".repeat(10));
        contacts.forEach(System.out::println);
    }
}