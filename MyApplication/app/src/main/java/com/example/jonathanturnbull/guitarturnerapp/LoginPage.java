package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void goToFrontpage(View view) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }
}
