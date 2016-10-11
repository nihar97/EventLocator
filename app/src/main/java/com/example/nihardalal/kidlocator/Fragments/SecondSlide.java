package com.example.nihardalal.kidlocator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nihardalal.kidlocator.R;

/**
 * Created by Nihar Dalal on 7/27/2016.
 */
public class SecondSlide extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.intro2, container, false);
        return v;
    }
}
