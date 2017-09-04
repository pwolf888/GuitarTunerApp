package com.example.jonathanturnbull.guitarturnerapp;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;



public class LyricsPage extends AppCompatActivity {

    public static final String TABLE_NAME = "lyrics";
    DBHelper myDBHelper;
    Button saveButton;
    EditText songTitle;
    EditText lyrics;
    ListView listView;

    String[] allColumns = new String[] {"_id", "songTitle", "lyricstext" };

    @Override
    protected void onCreate(Bundle savedInstancedState) {
        super.onCreate(savedInstancedState);
        setContentView(R.layout.activity_lyrics_page);


        // Create the Database
        myDBHelper = new DBHelper(this);

        // Save Button
        saveButton = (Button) findViewById(R.id.button_addLyrics);

        // Add List View
        listView = (ListView) findViewById(R.id.lyricsList);

        // Add Edit Text Views
        songTitle = (EditText) findViewById(R.id.editText_songTitle);
        lyrics = (EditText) findViewById(R.id.editText_lyrics);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(songTitle.getText().toString(), lyrics.getText().toString());
                displayLyrics();
            }
        });

        displayLyrics();

    }

    public List<String> getAllLyrics() {
        // Add the array list
        List<String> lyrics = new ArrayList<String>();

        // Get Database
        SQLiteDatabase db = myDBHelper.getReadableDatabase();

        // Create cursor adapter
        Cursor cursor = db.query(TABLE_NAME, allColumns, null, null, null, null, null);

        // While Loop to collect data
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String SongTitle = cursor.getString(cursor.getColumnIndex("songtitle"));
            String lyricsText = cursor.getString(cursor.getColumnIndex("lyricstext"));
            lyrics.add(id + SongTitle + lyricsText);
        }

        return lyrics;

    }

    void displayLyrics() {
        // Use the list from getAllLyrics list
        List <String> values = getAllLyrics();

        // If the data is not null push it into an array adapter
        if( values != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,
                    android.R.layout.simple_list_item_1, values);
            listView.setAdapter(adapter);
        }

    }

    public void insert(String songTitle, String lyrics) {
        ContentValues values = new ContentValues();
        values.put("songtitle", songTitle);
        values.put("lyricstext", lyrics);
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }


    public void goHome(MenuItem item) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }



}
