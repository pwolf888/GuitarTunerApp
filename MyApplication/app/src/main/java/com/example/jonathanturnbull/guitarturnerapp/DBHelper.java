package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jonathanturnbull on 4/09/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // My UserData Table and columns
    public static final String TABLE_USERDATA = "userdata";
    public static final String COLUMN_USER_ID = "_userid";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSW = "password";


    // My lyrics table and columns
    public static final String TABLE_LYRICS = "lyrics";
    public static final String COLUMN_ID_LYRICS = "_id";
    public static final String COLUMN_TITLE = "songtitle";
    public static final String COLUMN_SONG = "lyricstext";


    private static final String DATABASE_NAME = "userdata.db";
    private static final int DATABASE_VERSION = 1;


    private static final String CREATE_USERDATA_TABLE = "create table " + TABLE_USERDATA
            + "(" + COLUMN_USER_ID + " integer primary key autoincrement, "
            + COLUMN_USERNAME + " text not null, "
            + COLUMN_PASSW + " text not null);";

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table " + TABLE_LYRICS
            + "(" + COLUMN_ID_LYRICS + " integer primary key autoincrement, "
            + COLUMN_TITLE + " text not null, "
            + COLUMN_SONG + " text not null);";

    Context context;

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {  db.execSQL(CREATE_USERDATA_TABLE); db.execSQL(DATABASE_CREATE); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERDATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LYRICS);
        onCreate(db);
    }
}
