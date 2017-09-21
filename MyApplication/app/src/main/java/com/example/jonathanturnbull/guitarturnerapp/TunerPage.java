package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/***********************************
 * Jonathan Turnbull
 * 214527872
 * jmturnbu
 ***********************************/

public class TunerPage extends AppCompatActivity implements View.OnClickListener{

    // Declare variables
    Button E, A, D, G, B, e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuner_page);

        // Onclick event - switch statement
        E = (Button) findViewById(R.id.button_E);
        E.setOnClickListener(this);
        A = (Button) findViewById(R.id.button_A);
        A.setOnClickListener(this);
        D = (Button) findViewById(R.id.button_D);
        D.setOnClickListener(this);
        G = (Button) findViewById(R.id.button_G);
        G.setOnClickListener(this);
        B = (Button) findViewById(R.id.button_B);
        B.setOnClickListener(this);
        e = (Button) findViewById(R.id.button_e);
        e.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }


    public void onClick(View v) {
        // Create mediaplayer to play E A D G B e sounds
        MediaPlayer lowEsound = MediaPlayer.create(this, R.raw.lowesound);
        MediaPlayer aSound = MediaPlayer.create(this, R.raw.asound);
        MediaPlayer dSound = MediaPlayer.create(this, R.raw.dsound);
        MediaPlayer gSound = MediaPlayer.create(this, R.raw.gsound);
        MediaPlayer bSound = MediaPlayer.create(this, R.raw.bsound);
        MediaPlayer hiEsound = MediaPlayer.create(this, R.raw.hiesound);

        // Find the button by id and play a corresponding note
        switch (v.getId()) {

            case R.id.button_E:
                // play sound of E
                lowEsound.start();
                break;

            case R.id.button_A:
                // play sound of A
                aSound.start();
                break;

            case R.id.button_D:
                // play sound of D
                dSound.start();
                break;

            case R.id.button_G:
                // play sound of G
                gSound.start();
                break;
            case R.id.button_B:
                // play sound of B
                bSound.start();
                break;

            case R.id.button_e:
                // play sound of e
                hiEsound.start();
                break;

            default:
                break;
        }
    }


    // Buttons that link to other pages
    public void goToFrontpage(View view) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }

    public void goToRecordpage(View view) {
        Intent intent = new Intent(this, RecordPage.class);
        startActivity(intent);
    }

    public void goToLyricspage(View view) {
        Intent intent = new Intent(this, LyricsPage.class);
        startActivity(intent);
    }

    public void goToMetronomepage(View view) {
        Intent intent = new Intent(this, MetronomePage.class);
        startActivity(intent);
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
