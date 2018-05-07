package com.example.android.miwok;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.data.WordContract.WordEntry;

import java.util.ArrayList;

/**
 * Created by DELL on 1/16/2018.
 */

public class WordCursorAdapter extends CursorAdapter {
    public WordCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView defaultTextView = view.findViewById(R.id.default_text_view);
        TextView miwokTextView = view.findViewById(R.id.miwok_text_view);
        ImageView imageView = view.findViewById(R.id.image);

        // Find the columns of words attributes that we're interested in
        int englishWordColumnIndex = cursor.getColumnIndex(WordEntry.COLUMN_WORD_ENGLISH);
        int miwokWordColumnIndex = cursor.getColumnIndex(WordEntry.COLUMN_WORD_MIWOK);

        // Read the word attributes from the Cursor for the current word
        String englishWord = cursor.getString(englishWordColumnIndex);
        String miwokWord = cursor.getString(miwokWordColumnIndex);


//        get the default translation from the current word object and set the text text
        defaultTextView.setText(englishWord);

//        find the textview in the list_item.xml with the ID miwok_text_view
//        get the default translation from the cyrrent word object and set the text text
        miwokTextView.setText(miwokWord);
//                find the textview in the list_item.xml with the ID miwok_text_view

//        if(currentword.hasImage()){
//            //        get the default translation from the cyrrent word object and set the text text
//            imageView.setImageResource(currentword.getImageResourceId());
//            imageView.setVisibility(View.VISIBLE);
//        }else {
            imageView.setVisibility(View.GONE);
//        }

//       set the theme color for the list item
        View textContainer = view.findViewById(R.id.text_container);
//        \find the color that the resource id maps to
//        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        Set the background color of the text container view
//        textContainer.setBackgroundColor(color);

    }
}
