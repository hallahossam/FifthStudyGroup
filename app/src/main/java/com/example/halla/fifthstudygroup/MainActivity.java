package com.example.halla.fifthstudygroup;

import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.halla.fifthstudygroup.db.DatabaseHelperClass;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    DatabaseHelperClass mDatabaseHelper;
Button addToDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addToDatabase = (Button) findViewById(R.id.btn_add);

        mDatabaseHelper = new DatabaseHelperClass(MainActivity.this);


        Cursor mCursor = mDatabaseHelper.fetchData();
        int mCursorLength = mCursor.getCount();

        for (int i = 0; i < mCursorLength; i++) {
            Toast.makeText(MainActivity.this, "Contact Name: "
                    + mCursor.getString(1) +
                    ", Contact Phone: " + mCursor.getString(2), Toast.LENGTH_LONG)
                    .show();
            mCursor.moveToNext();
        }

        addToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = mDatabaseHelper.insertIntoDB("Mohamed","01929392");
                if(result == 1){
                    Toast.makeText(MainActivity.this, "inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
