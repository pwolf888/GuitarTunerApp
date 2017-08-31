package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AddLyricsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lyrics_page);
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
