package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splash extends AppCompatActivity {

    Integer MAX_DELAY = 3000;

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Handler used to delay screen transition for 3 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Moves user to login page
                Intent intent = new Intent(Splash.this, LoginPage.class);
                startActivity(intent);
            }
        }, MAX_DELAY);

    }
}
