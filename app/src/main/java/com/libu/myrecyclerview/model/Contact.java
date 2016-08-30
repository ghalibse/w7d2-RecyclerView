package com.libu.myrecyclerview.model;

import java.util.ArrayList;

public class Contact {
    private String mName;
    private boolean mOnline;

    public int getId() {
        return id;
    }

    private int id;

    public Contact(String name, boolean online, int Id) {
        mName = name;
        mOnline = online;
        id = Id;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            int count = ++lastContactId;
            contacts.add(new Contact("Person " + count, i <= numContacts / 2, count));
        }

        return contacts;
    }
}
