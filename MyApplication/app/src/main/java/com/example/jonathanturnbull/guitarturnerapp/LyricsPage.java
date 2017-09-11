package com.example.jonathanturnbull.guitarturnerapp;



import android.content.ContentValues;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

import static com.example.jonathanturnbull.guitarturnerapp.DBHelper.COLUMN_ID;


public class LyricsPage extends AppCompatActivity {

    public static final String TABLE_LYRICS = "lyrics";
    DBHelper myDBHelper;
    Button saveButton;
    EditText songTitle;
    EditText lyrics;
    ListView listView;
    Button deleteButton;
    int position;
    Cursor cursor;


    String[] allColumns = new String[] { "_id", "songTitle", "lyricstext" };

    @Override
    protected void onCreate(Bundle savedInstancedState) {
        super.onCreate(savedInstancedState);
        setContentView(R.layout.activity_lyrics_page);



        // Create the Database
        myDBHelper = new DBHelper(this);

        // Save Button
        saveButton = (Button) findViewById(R.id.button_addLyrics);

        // Delete Button
//        deleteButton = (Button) findViewById(R.id.Button_remove);

//        deleteButton.setOnClickListener( new View.OnClickListener()  {
//            @Override
//            public void onClick(View v) {
//                View parentRow = (View) v.getParent();
//                ListView listView = (ListView) parentRow.getParent();
//                position = listView.getPositionForView(parentRow);
//            }
//        });

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
        cursor = db.query(TABLE_LYRICS, allColumns, null, null, null, null, null);


        // While Loop to collect data
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String SongTitle = cursor.getString(cursor.getColumnIndex("songtitle"));
            String lyricsText = cursor.getString(cursor.getColumnIndex("lyricstext"));
            lyrics.add(id +". " + SongTitle + " -  \n" + lyricsText);
        }

        return lyrics;

    }

    void displayLyrics() {
        // Use the list from getAllLyrics list
        List <String> values = getAllLyrics();

        // If the data is not null push it into an array adapter
        if( values != null) {
//            ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,
//                    android.R.layout.simple_list_item_1, values);
//            listView.setAdapter(adapter);

            LyricsListAdapter adapter = new LyricsListAdapter(this, values);
            // Load the adapter to list view
            listView.setAdapter(adapter);
        }

    }

    public void insert(String songTitle, String lyrics) {
        ContentValues values = new ContentValues();
        values.put("songtitle", songTitle);
        values.put("lyricstext", lyrics);
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.insert(TABLE_LYRICS, null, values);
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

    public void logOut(MenuItem item) {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    public void clearRow(View view) {
        // Get Database
        SQLiteDatabase db = myDBHelper.getReadableDatabase();

        // Create cursor and find the minimum Column ID
        // https://stackoverflow.com/questions/4890616/get-minimum-from-sqlite-database-column
        // Author: Corey Sunwold
        cursor = db.query(TABLE_LYRICS, new String[] { "min(" + COLUMN_ID + ")" }, null, null,
                null, null, null);

        // Move to the first position
        cursor.moveToFirst();
        // An int that stores the first position in the index
        int rowId = cursor.getInt(0);

        /*End of code borrowed*/

        // Use the id of the parent view of the list item to access its position
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        position = listView.getPositionForView(parentRow);
        Log.d("POSANDROW", "pos: " + position + "+ rowid:" + rowId);
        position += rowId;
        Log.d("POSANDROW", "pos: " + position + "+ rowid:" + rowId);

        SQLiteDatabase db2 = myDBHelper.getWritableDatabase();
        db2.execSQL("DELETE FROM " + TABLE_LYRICS + " WHERE " + COLUMN_ID + "='"+ position +"'");
        db2.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_LYRICS + "'");
        db2.close();

        displayLyrics();

        //Log.d("PRESSED", "i have been pressed" + position);
    }






}
