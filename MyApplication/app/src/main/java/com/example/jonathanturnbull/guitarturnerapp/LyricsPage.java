package com.example.jonathanturnbull.guitarturnerapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Vector;


public class LyricsPage extends ListActivity {

      String[] lyricArray = {"Song Title", "Jeff","OMG"};
//    public ArrayList<String> lyricsArray = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstancedState) {
        super.onCreate(savedInstancedState);
        setContentView(R.layout.activity_lyrics_page);

        this.setListAdapter(new ArrayAdapter<String>(
                this, R.layout.lyrics_list,
                R.id.label_lyric, lyricArray));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

    public void goToAddLyricsPage(View view) {
        Intent intent = new Intent(this, AddLyricsPage.class);
        startActivity(intent);
    }

    public void goHome(MenuItem item) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }



}
