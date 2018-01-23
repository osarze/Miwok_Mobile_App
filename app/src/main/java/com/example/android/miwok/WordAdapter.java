package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by DELL on 1/16/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//       check if existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

//        Get the {} object located at this position in the list
        Word currentword = getItem(position);

//        find the textview in the list_item.xml with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
//        get the default translation from the current word object and set the text text
        defaultTextView.setText(currentword.getDefaultTranslation());

//        find the textview in the list_item.xml with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
//        get the default translation from the cyrrent word object and set the text text
        miwokTextView.setText(currentword.getMiwokTranslation());
//                find the textview in the list_item.xml with the ID miwok_text_view
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentword.hasImage()){
            //        get the default translation from the cyrrent word object and set the text text
            imageView.setImageResource(currentword.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

//       set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
//        \find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        Set the background color of the text container view
        textContainer.setBackgroundColor(color);

//        Return the whole list item layout (containing 2 text views and)
        return listItemView;
    }
}
