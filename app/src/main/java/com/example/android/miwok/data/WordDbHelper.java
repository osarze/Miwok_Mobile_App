package com.example.android.miwok.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.miwok.data.WordContract.WordEntry;

/**
 * Created by OKHAMAFE EMMANUEL on 5/6/2018.
 */

public class WordDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = WordDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "miwok.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public WordDbHelper(Context context) {
        // Create a String that contains the SQL statement to create the pets table
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /** Create a String that contains the SQL statement to create the pets table */
        String SQL_CREATE_WORD_TABLE = "CREATE TABLE " + WordEntry.TABLE_NAME + " ("
                + WordEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WordEntry.COLUMN_WORD_ENGLISH + " TEXT NOT NULL,"
                + WordEntry.COLUMN_WORD_MIWOK + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_WORD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
