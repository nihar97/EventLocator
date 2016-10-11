package com.example.nihardalal.kidlocator.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nihardalal.kidlocator.Activities.ResultActivity;
import com.example.nihardalal.kidlocator.R;
import com.example.nihardalal.kidlocator.Utilities.CircleTransform;

/**
 * Created by Nihar Dalal on 7/29/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private String[] mTexts = {
            "Harry Potter and The Cursed Child",
            "Suicide Squad Screening",
            "Alice in Wonderland Play",
            "Kids Musical Concert",
            "Bombay Carnival",
            "Arts and Crafts Workshop",
            "Robotics Workshop",
            "Ranibagh Zoo Visit"
    };
    private String[] mDates = {
            "31st July at 11 AM",
            "5th August at 5 PM",
            "6th August at 7 PM",
            "15th August at 6 PM",
            "15th August all day long",
            "17th August at 4 PM",
            "16th August at 11 AM",
            "Any Day till 5 PM"
    };
    private String[] mPlaces = {
            "Crossword", "Inox", "NCPA","NCPA", "MRDA Grounds", "Hobby Ideas", "IIT", "Byculla"
    };
    private String text;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mDate;
        public View mView;

        public ViewHolder(View v, TextView tv, TextView dt) {
            super(v);
            mView = v;
            mTitle = tv;
            mDate = dt;
        }
    }

    public ListAdapter(String text, Context c) {
        this.text = text;
        context = c;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        TextView tv = (TextView) v.findViewById(R.id.list_text);
        TextView dt = (TextView) v.findViewById(R.id.date);
        ViewHolder vh = new ViewHolder(v, tv, dt);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(mTexts[position]);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(context, ResultActivity.class);
                context.startActivity(resultIntent);
            }
        });
        holder.mDate.setText(mDates[position]);
        ((TextView) holder.mView.findViewById(R.id.place)).setText(mPlaces[position]);
        ImageView icon = (ImageView) holder.mView.findViewById(R.id.icon);
        Glide.with(context).load(R.drawable.harry_potter).transform(new CircleTransform(context)).into(icon);
    }

    @Override
    public int getItemCount() {
        return mTexts.length;
    }
}
