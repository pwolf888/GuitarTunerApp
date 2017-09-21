package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MetronomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metronome_page);

        MediaPlayer metronomeSound = MediaPlayer.create(this, R.raw.metronomesound);



        ToggleButton toggle = (ToggleButton) findViewById(R.id.switch_Metro);
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                metronomeSound.start();
            } else {
                metronomeSound.pause();
            }
        });
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
}
