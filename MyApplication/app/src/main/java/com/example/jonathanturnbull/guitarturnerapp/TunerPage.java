package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TunerPage extends AppCompatActivity implements View.OnClickListener{


    Button E;
    Button G;
    Button e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuner_page);

        // Onclick event - switch statement
        E = (Button) findViewById(R.id.button_E);
        E.setOnClickListener(this);
        G = (Button) findViewById(R.id.button_G);
        G.setOnClickListener(this);
        e = (Button) findViewById(R.id.button_e);
        e.setOnClickListener(this);



    }

    public void onClick(View v) {
        // Create mediaplayer
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.test_sound);

        // Find the button by id and play a corresponding note
        switch (v.getId()) {

            case R.id.button_E:
                // play sound of E
                mediaPlayer.start();
                break;

            case R.id.button_G:
                // play sound of G
                mediaPlayer.start();
                break;

            case R.id.button_e:
                // play sound of e
                mediaPlayer.start();
                break;

            default:
                break;
        }
    }



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


    public void playE(View view) {
        // pre load the sound files

    }


}
