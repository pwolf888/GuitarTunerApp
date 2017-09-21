package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import static com.example.jonathanturnbull.guitarturnerapp.DBHelper.COLUMN_PASSW;
import static com.example.jonathanturnbull.guitarturnerapp.DBHelper.COLUMN_USERNAME;
import static com.example.jonathanturnbull.guitarturnerapp.DBHelper.TABLE_USERDATA;
import static com.example.jonathanturnbull.guitarturnerapp.LyricsPage.TABLE_LYRICS;

public class LoginPage extends AppCompatActivity {

    public static final String TABLE_USERDATA = "userdata";
    EditText username;
    EditText passWord;
    Button login;
    String hasher = "";
    DBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Create the Database
        myDBHelper = new DBHelper(this);
        login = (Button) findViewById(R.id.button_Login);
        username = (EditText) findViewById(R.id.editText_username);
        passWord = (EditText) findViewById(R.id.editText_userPassword);


//        login.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (username.length() >= 8 && passWord.length() >= 8) {
//                    // get Text from form elements
//                    username.getText();
//                    passWord.getText();
//
//                    // Hash password to a 32 bit string
//                    hasher = md5(passWord.toString());
//
//
//                    Log.d("HASHED", "HASHED PASSWORD = " + hasher);
//                } else {
//                    Context context = getApplicationContext();
//                    CharSequence text = "No such username or password";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//
//                }
//            }
//        });
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

    public void goToFrontpage(View view) {
        Intent intent = new Intent(this, TunerPage.class);
        startActivity(intent);
    }

    public void goToRegisterPage(View view) {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
}
