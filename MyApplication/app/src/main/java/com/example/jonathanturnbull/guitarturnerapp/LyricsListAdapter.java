package com.example.jonathanturnbull.guitarturnerapp;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



/**
 * Created by jonathanturnbull on 4/09/2017.
 */

public class LyricsListAdapter extends ArrayAdapter<String> {

    // Declared variables
    private final Context context;
    private final List<String> values;
    DBHelper myDBHelper;

    // Constructor which is called when the custom adapter is created
    public LyricsListAdapter(Context context, List<String> values) {
        // Select the layout for the cell
        super(context, R.layout.lyrics_list, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflates the row with my layout
        View rowView = inflater.inflate(R.layout.lyrics_list, parent, false);

        // Link the widgets on the layout with my adapter class
        TextView id = (TextView) rowView.findViewById(R.id.label_lyric_id);
        TextView songTitle = (TextView) rowView.findViewById(R.id.label_lyric_title);
        TextView lyricsText = (TextView) rowView.findViewById(R.id.label_lyric_lyrics);
        Button removeButton = (Button) rowView.findViewById(R.id.Button_remove);


        // Set the content of the text based on the values string in the lyrics activity
        id.setText(values.get(position));
        //songTitle.setText(values.get(position));
        //lyricsText.setText(values.get(position));
        //removeButton.setText(values.get(position));
        return rowView;

    }
}
