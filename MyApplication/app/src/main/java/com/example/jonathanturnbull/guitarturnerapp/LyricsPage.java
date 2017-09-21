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

import static com.example.jonathanturnbull.guitarturnerapp.DBHelper.COLUMN_ID_LYRICS;


public class LyricsPage extends AppCompatActivity {


    // Declare variables
    public static final String TABLE_LYRICS = "lyrics";
    DBHelper myDBHelper;
    Button saveButton;
    EditText songTitle;
    EditText lyrics;
    ListView listView;
    int position;
    Cursor cursor;

    // Collumns of my database
    String[] allColumns = new String[] { "_id", "songTitle", "lyricstext" };

    // Array to store id
    ArrayList<Integer> arrayid = new ArrayList<Integer>();

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

        // Inserts text from the Edit text views into the lyrics database
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(songTitle.getText().toString(), lyrics.getText().toString());
                arrayid.clear();
                displayLyrics();
            }
        });
        arrayid.clear();
        displayLyrics();
    }

    // Function to get all lyrics from the database
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

            // Adds the id into an array for deleting purposes
            arrayid.add(id);

            String SongTitle = cursor.getString(cursor.getColumnIndex("songtitle"));
            String lyricsText = cursor.getString(cursor.getColumnIndex("lyricstext"));
            lyrics.add(id +". " + SongTitle + " -  \n" + lyricsText);
        }

        return lyrics;

    }

    // Pushes the data into a list Adapter
    void displayLyrics() {
        // Use the list from getAllLyrics list
        List <String> values = getAllLyrics();

        // If the data is not null push it into an array adapter
        if( values != null) {
            LyricsListAdapter adapter = new LyricsListAdapter(this, values);

            // Load the adapter to list view
            listView.setAdapter(adapter);
        }

    }

    // Funciton ot insert values into the database
    public void insert(String songTitle, String lyrics) {
        ContentValues values = new ContentValues();
        values.put("songtitle", songTitle);
        values.put("lyricstext", lyrics);
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.insert(TABLE_LYRICS, null, values);
    }

    // Create my menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

    // Moves the user back to the Tunerpage
    public void goHome(MenuItem item) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }

    // Moves the user to the login page
    public void logOut(MenuItem item) {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    // Removes a row from the listview and database
    public void clearRow(View view) {

        // Use the id of the parent view of the list item to access its position
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        position = listView.getPositionForView(parentRow);
        Log.d("POS", "OUTPUT POS : " + position);

        // Remove the value from the database and redraw it to the screen
        SQLiteDatabase db2 = myDBHelper.getWritableDatabase();
        db2.execSQL("DELETE FROM " + TABLE_LYRICS + " WHERE " + COLUMN_ID_LYRICS + "='"+ arrayid.get(position) +"'");
        db2.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_LYRICS + "'");
        db2.close();

        // Clears the array to remake it
        arrayid.clear();
        displayLyrics();
    }


}
