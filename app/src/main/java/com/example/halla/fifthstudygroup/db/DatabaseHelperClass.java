package com.example.halla.fifthstudygroup.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Halla on 05/11/2016.
 */
public class DatabaseHelperClass extends SQLiteOpenHelper {
    public static DatabaseContract mDatabaseContract = new DatabaseContract();
    public static final int DATABASE_VERSION = 1;
    SQLiteDatabase mSQLiteDatabase;

    public DatabaseHelperClass(Context context) {
        super(context, mDatabaseContract.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(mDatabaseContract.CREATE_TABLE_CONTACTS);

     db.execSQL("insert into " + mDatabaseContract.TABLE_CONTACTS + " ("
             + mDatabaseContract.CONTACTS_NAME + "," + mDatabaseContract.CONTACT_PHONE
     +") values ('Ahmed','0100283838')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " + mDatabaseContract.TABLE_CONTACTS + " if exists");
        onCreate(db);

    }
    public Cursor fetchData(){
        mSQLiteDatabase = getReadableDatabase();
        Cursor mCursor = mSQLiteDatabase.rawQuery("select * from "
                + mDatabaseContract.TABLE_CONTACTS, null);
        mCursor.moveToFirst();
        mSQLiteDatabase.close();
        return mCursor;

    }

    public int insertIntoDB (String name, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(mDatabaseContract.CONTACTS_NAME, name);
        contentValues.put(mDatabaseContract.CONTACT_PHONE, phone);

        mSQLiteDatabase = getWritableDatabase();
        mSQLiteDatabase.insert(mDatabaseContract.TABLE_CONTACTS, null, contentValues);
        mSQLiteDatabase.close();
        return 1;
    }


}
