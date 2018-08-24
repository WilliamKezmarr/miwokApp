package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.layout.list_item;

public class WordAdapter extends ArrayAdapter<Word>{
    private int bgColor;

    public WordAdapter(Context cont, ArrayList<Word> words)
    {
        super(cont, 0, words);
    }

    public WordAdapter(Context cont, ArrayList<Word> words, int color)
    {
        super(cont, 0, words);
        bgColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    list_item, parent, false);
        }
        //listItemView.setBackgroundColor(bgColor);
        int color = ContextCompat.getColor(getContext(), bgColor);
        View textContainer = listItemView.findViewById(R.id.llTextContainer);
        textContainer.setBackgroundColor(color);

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView textViewMiwok = (TextView) listItemView.findViewById(R.id.textView_Miwok);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        textViewMiwok.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView textViewDefaultTranslation = (TextView) listItemView.findViewById(R.id.textView_DefaultTranslation);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        textViewDefaultTranslation.setText(currentWord.getDefaultTranslation());


        //textViewMiwok.setBackgroundColor(Color.parseColor(String.valueOf(R.color.category_family)));

        //Color bg = getApplicationContext().getResources().getColor(R.color.category_family);


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView wordImageView = (ImageView) listItemView.findViewById(R.id.imageView2);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentWord.getImageId() != Word.NO_IMAGE_PROVIDED) {
            wordImageView.setImageResource(currentWord.getImageId());
            wordImageView.setVisibility(View.VISIBLE);
        }
        else
            wordImageView.setVisibility(View.GONE);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
        //return super.getView(position, convertView, parent);
    }
}
