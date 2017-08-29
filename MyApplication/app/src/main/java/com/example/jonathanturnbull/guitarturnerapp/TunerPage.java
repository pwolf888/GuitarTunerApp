package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TunerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuner_page);
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
}
