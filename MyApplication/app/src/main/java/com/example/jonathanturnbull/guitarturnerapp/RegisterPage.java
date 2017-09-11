package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;

public class RegisterPage extends AppCompatActivity {

    public static final String TABLE_LYRICS = "userdata";
    String hasher = "";
    EditText username;
    EditText passWord;
    EditText passWordc;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        username = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        passWordc = (EditText) findViewById(R.id.passWordc);
        register = (Button) findViewById(R.id.Register);


        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (username.length() > 8 && passWord.length() > 8) {

                    username.getText();
                    passWord.getText();
                    hasher = md5(passWord.toString());

                    Log.d("HASHED", "HASHED PASSWORD = " + hasher);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "No Hashing Error!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
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
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    public void logOut(MenuItem item) {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    // https://stackoverflow.com/questions/3934331/how-to-hash-a-string-in-android
    // Author: Yuriy Lisenkov
    public static String md5(final String toEncrypt) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(toEncrypt.getBytes());
            final byte[] bytes = digest.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X", bytes[i]));
            }
            return sb.toString().toLowerCase();
        } catch (Exception exc) {
            return "";
        }
    }
    // End of borrowed code //
}
