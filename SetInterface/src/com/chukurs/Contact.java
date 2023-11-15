package com.chukurs;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    String name;
    Set<String> emails = new HashSet<>();
    Set<String> phones = new HashSet<>();


    public Contact(String name) {
       this( name,null);
    }

    public Contact(String name, String email) {
        this( name,email,0);

    }

    public Contact(String name, long phone) {
        this( name,null,0);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            this.emails.add(email);
        }
        if(phone>0){
        String phoneString = Long.toString(phone);
        if (phoneString.length() == 10) {
            String result = "(%s) %s-%s".formatted(phoneString.substring(0, 3),phoneString.substring(3, 6) ,phoneString.substring(6));
            this.phones.add(result);
        }}

    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name,emails,phones);
    }

    public Contact mergeContactData(Contact contact) {
Contact newContact = new Contact(name);
newContact.emails = new HashSet<>(this.emails);
newContact.phones = new HashSet<>(this.phones);
newContact.emails.addAll(contact.emails);
newContact.phones.addAll(contact.phones);

        return newContact;
    }
}
