package com.example.halla.fifthstudygroup.db;

/**
 * Created by Halla on 05/11/2016.
 */
public class DatabaseContract {
    public static final String DATABASE_NAME = "ContactsManager";

    public static final String TABLE_CONTACTS = "contacts";
    public static final String CONTACTS_ID = "id";
    public static final String CONTACTS_NAME = "name";
    public static final String CONTACT_PHONE = "phone";

    public static final String CREATE_TABLE_CONTACTS = "create table " + TABLE_CONTACTS +
            "(" + CONTACTS_ID + " integer primary key autoincrement, " + CONTACTS_NAME
            + " text, " + CONTACT_PHONE + " text)";


}
