package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FrontPage extends Fragment {

    // Declaring variables
    View myView;

    // Setting up the layout of the front page in the first fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // The view is the layout of my frontpage
        myView = inflater.inflate(R.layout.frontpage, container, false);

        return myView;
    }
}
