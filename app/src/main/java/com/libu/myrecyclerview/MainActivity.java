package com.libu.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


//web site for this
// https://guides.codepath.com/android/using-the-recyclerview#overview
public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        // Add a new contact
        contacts.add(0, new Contact("Barney", true,0));
// Notify the adapter that an item was inserted at position 0
        adapter.notifyItemInserted(0);

        // record this value before making any changes to the existing list
        int curSize = adapter.getItemCount();

// replace this line with wherever you get new records
        ArrayList<Contact> newItems = Contact.createContactsList(20);

// update the existing list
        contacts.addAll(newItems);
// curSize should represent the first element that got added
// newItems.size() represents the itemCount
        adapter.notifyItemRangeInserted(curSize, newItems.size());

        adapter.notifyItemInserted(contacts.size() - 1);  // contacts.size() - 1 is the last element position
        rvContacts.scrollToPosition(adapter.getItemCount() - 1); // update based on adapter

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        rvContacts.addItemDecoration(itemDecoration);

        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        rvContacts.addItemDecoration(decoration);
    }
}
