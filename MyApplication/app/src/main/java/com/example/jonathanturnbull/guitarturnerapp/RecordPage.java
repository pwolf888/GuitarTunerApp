package com.example.jonathanturnbull.guitarturnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class RecordPage extends Fragment implements OnClickListener{

    // Declaring variables
    View myView;

    // Setting up the layout of the front page in the first fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // The view is the layout of my tunerpage
        myView = inflater.inflate(R.layout.activity_record_page, container, false);
        Button b = (Button) myView.findViewById(R.id.button_addRecord);
        b.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        switch (v.getId()) {
            case R.id.button_addRecord:
                fragmentManager.beginTransaction().replace(R.id.content_frame,
                        new AddRecordsPage()).commit();
                break;
        }
    }

}


