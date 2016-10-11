package com.example.nihardalal.kidlocator.Adapters;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nihardalal.kidlocator.Activities.MainActivity;
import com.example.nihardalal.kidlocator.Fragments.List;
import com.example.nihardalal.kidlocator.R;

/**
 * Created by Nihar Dalal on 7/28/2016.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Integer[] mThumbIds = {
            R.color.tile1, R.color.tile2, R.color.tile3, R.color.tile6, R.color.tile4, R.color.tile5
    };

    private String[] categories = {
            "Playgrounds", "Learning Activities", "Movie Screenings", "Theme Parks", "Special Events", "Music"
    };
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View mColorView;
        public View v;
        public ViewHolder(View v, View iv){
            super(v);
            this.v = v;
            mColorView = iv;
        }

        public View getmColorView() {
            return mColorView;
        }

        public View getV() {
            return v;
        }
    }
    public ImageAdapter(Activity a){
        mActivity = a;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid, parent, false);
        View iv = v.findViewById(R.id.imageView);
        ViewHolder vh = new ViewHolder(v,iv);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mColorView.setBackgroundResource(mThumbIds[position]);
        holder.mColorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new List();
                MainActivity mainActivity = (MainActivity) mActivity;
                Bundle args = new Bundle();
                args.putString("title", (String) ((TextView) holder.getV().findViewById(R.id.text_view)).getText());
                ColorDrawable colorDrawable = (ColorDrawable) holder.mColorView.getBackground() ;
                args.putInt("color", colorDrawable.getColor());
                fragment.setArguments(args);
                mainActivity.replaceFragment(fragment, R.id.grid_fragment);
            }
        });
        TextView textView = (TextView) holder.getV().findViewById(R.id.text_view);
        textView.setText(categories[position]);
    }
    @Override
    public int getItemCount() {
        return mThumbIds.length;
    }

}
