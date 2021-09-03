package com.example.sqlliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.sqlliteapp.data.DatabaseHandler;
import com.example.sqlliteapp.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Log.d("Count", "onCreate: " + db.getCount());

        Contact jeremy = new Contact();
        jeremy.setName("Jeremy");
        jeremy.setPhoneNumber("9876521");

        Contact jason = new Contact();
        jeremy.setName("Jason");
        jeremy.setPhoneNumber("1027635");

        //Get 1 contact
        Contact c = db.getContact(2);
        Log.d("Main", "onCreate: "+c.getName()+", "+c.getPhoneNumber());
        c.setName("NewJeremy");
        c.setPhoneNumber("10000");
       // int updateRow = db.updateContact(c);

        //db.deleteContact(c);

        //db.addContact(jeremy);
        List<Contact> contactList = db.getAllContacts();

        for(Contact contact: contactList){
            Log.d("Main", "onCreate: " + contact.getName());
        }

    }
}