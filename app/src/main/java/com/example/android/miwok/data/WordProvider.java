package com.example.android.miwok.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.miwok.data.WordContract.WordEntry;

/**
 * Created by OKHAMAFE EMMANUEL on 5/6/2018.
 */

public class WordProvider extends ContentProvider {
    /** Tag for the log messages */
    public static final String LOG_TAG = WordProvider.class.getSimpleName();

    /** URI matcher code for the content URI for the words table */
    private static final int WORDS = 100;

    /** URI matcher code for the content URI for the single word in the words table */
    private static final int WORD_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.PATH_WORDS, WORDS);

        sUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.PATH_WORDS + "/#", WORD_ID);
    }

    /** Database helper object */
    private WordDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new WordDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // Get readable database
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        // This cursor will hold the result of the query
        Cursor cursor;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match) {
            case WORDS:
                // For the PETS code, query the pets table directly with the given
                // projection, selection, selection arguments, and sort order. The cursor
                // could contain multiple rows of the pets table.
                cursor = database.query(WordEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case WORD_ID:
                // For the PET_ID code, extract out the ID from the URI.
                // For an example URI such as "content://com.example.android.pets/pets/3",
                // the selection will be "_id=?" and the selection argument will be a
                // String array containing the actual ID of 3 in this case.
                //
                // For every "?" in the selection, we need to have an element in the selection
                // arguments that will fill in the "?". Since we have 1 question mark in the
                // selection, we have 1 String in the selection arguments' String array.
                selection = WordEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                // This will perform a query on the pets table where the _id equals 3 to return a
                // Cursor containing that row of the table.
                cursor = database.query(WordContract.WordEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }


        // If the data at this URI changes, then we know we need to update the Cursor.
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);

        switch (match) {
            case WORDS:
                return WordEntry.CONTENT_LIST_TYPE;
            case WORD_ID:
                return WordEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);

        switch (match){
            case WORDS:
                return insertWord(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    private Uri insertWord(Uri uri, ContentValues values){
        String englishWord = values.getAsString(WordEntry.COLUMN_WORD_ENGLISH);
        if (englishWord == null) {
            throw new IllegalArgumentException("English Word requires");
        }

        String miwokWord = values.getAsString(WordEntry.COLUMN_WORD_MIWOK);
        if (miwokWord == null) {
            throw new IllegalArgumentException("Miwok Word requires");
        }
        // Get writeable database
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        //Insert new word
        long id = database.insert(WordEntry.TABLE_NAME, null, values);

        if (id == -1){
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }

        // Notify all listeners that the data has changed for the pet content URI
        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
