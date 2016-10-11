package com.example.nihardalal.kidlocator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nihardalal.kidlocator.Adapters.HorizontalAdapter;
import com.example.nihardalal.kidlocator.Adapters.ImageAdapter;
import com.example.nihardalal.kidlocator.R;
import com.example.nihardalal.kidlocator.Utilities.HorizontalLayoutManager;

/**
 * Created by Nihar Dalal on 8/8/2016.
 */
public class HorizontalFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.horizontal_fragment, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.horizontal_recycler_view);
        mLayoutManager = new GridLayoutManager(this.getContext(), 1,GridLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HorizontalAdapter();
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }
}
