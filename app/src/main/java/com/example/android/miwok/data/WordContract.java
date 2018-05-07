package com.example.android.miwok.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by OKHAMAFE EMMANUEL on 5/6/2018.
 */

public class WordContract {
    // Empty Private Constructor to prevent accidental instantiating Contract Class
    private WordContract() {}

    public static final String CONTENT_AUTHORITY = "com.example.android.miwok";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_WORDS = "words";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class WordEntry implements BaseColumns {
        /** The content URI to access the word data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_WORDS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WORDS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WORDS;

        /** Name of database table for words */
        public final static String TABLE_NAME = "words";

        /**
         * Unique ID number for the word
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * The Word in English Language
         *
         * Type: String
         */
        public final static String COLUMN_WORD_ENGLISH = "english_word";

        /**
         * Miwok Translation of the Word
         * *
         * Type: String
         */
        public final static String COLUMN_WORD_MIWOK = "miwok_word";

    }

}
