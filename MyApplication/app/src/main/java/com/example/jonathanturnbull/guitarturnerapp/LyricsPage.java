package com.example.jonathanturnbull.guitarturnerapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LyricsPage extends Fragment {

    // Declaring variables
    View myView;

    // Setting up the layout of the front page in the first fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // The view is the layout of my tunerpage
        myView = inflater.inflate(R.layout.activity_lyrics_page, container, false);

        return myView;
    }
}
