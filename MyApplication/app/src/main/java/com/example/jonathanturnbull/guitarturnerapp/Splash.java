package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splash extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(Splash.this, LoginPage.class);
                startActivity(intent);
            }


        }, 3000);

    }

    public void goToFrontpage(View view) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }
}
