package com.example.nihardalal.kidlocator.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nihardalal.kidlocator.Adapters.ListAdapter1;
import com.example.nihardalal.kidlocator.R;
import com.example.nihardalal.kidlocator.Adapters.ListAdapter;
import com.example.nihardalal.kidlocator.CustomLayouts.DividerItemDecoration;


/**
 * Created by Nihar Dalal on 7/29/2016.
 */
public class List extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_fragment, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.list_recycler_view);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapter = new ListAdapter1();
//        mAdapter = new ListAdapter(getResources().getString(R.string.placeholder), getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mTextView = (TextView) v.findViewById(R.id.category);
        mTextView.setText(getArguments().getString("title"));
        mTextView.setBackgroundColor(getArguments().getInt("color"));
        return v;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
