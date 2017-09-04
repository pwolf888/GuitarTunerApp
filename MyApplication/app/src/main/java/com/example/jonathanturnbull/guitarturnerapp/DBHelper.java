package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jonathanturnbull on 4/09/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "lyrics";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "songtitle";
    public static final String COLUMN_SONG = "lyricstext";
    private static final String DATABASE_NAME = "lyric.db";
    private static final int DATABASE_VERSION = 1;
    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TITLE + " text not null, "
            + COLUMN_SONG + " text not null);";

    Context context;

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(DATABASE_CREATE); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
