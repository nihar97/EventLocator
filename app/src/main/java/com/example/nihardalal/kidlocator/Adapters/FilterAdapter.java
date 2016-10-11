package com.example.nihardalal.kidlocator.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nihardalal.kidlocator.Activities.AgeActivity;
import com.example.nihardalal.kidlocator.Activities.DateActivity;
import com.example.nihardalal.kidlocator.R;

/**
 * Created by Nihar Dalal on 8/5/2016.
 */
public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder>  {

    private Context context;
    private String[] categories = {
            "Ages", "Dates", "Distance"
    };
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    public FilterAdapter(Context c){
        context = c;
    }
    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView category, selected, change;
        category = (TextView) holder.mView.findViewById(R.id.filter_type);
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/FogSans.otf");
        selected = (TextView) holder.mView.findViewById(R.id.current_selection);
        category.setTypeface(custom_font);
        category.setText(categories[position] + "");
        selected.setText("No Preference");
        selected.setTypeface(custom_font);
        change = (TextView) holder.mView.findViewById(R.id.change);
        change.setTypeface(custom_font);
        switch (position) {
            case 1:
                change.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, DateActivity.class);
                        context.startActivity(i);
                    }
                });
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, DateActivity.class);
                        context.startActivity(i);
                    }
                });
                break;
            case 0:
                change.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, AgeActivity.class);
                        context.startActivity(i);
                    }
                });
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, AgeActivity.class);
                        context.startActivity(i);
                    }
                });
                break;
        }
    }


    @Override
    public int getItemCount() {
        return categories.length;
    }
}
