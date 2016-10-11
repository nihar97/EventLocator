package com.example.nihardalal.kidlocator.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nihardalal.kidlocator.R;

/**
 * Created by Nihar Dalal on 8/8/2016.
 */
public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    public int[] mImages = {
            R.drawable.california1, R.drawable.california2, R.drawable.california3, R.drawable.california1, R.drawable.california5, R.drawable.california6
    };

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private View v;

        public ViewHolder(View v, ImageView iv) {
            super(v);
            this.v = v;
            mImageView = iv;
        }

        public ImageView getmImageView() {
            return mImageView;
        }

        public View getV() {
            return v;
        }


    }

    public HorizontalAdapter() {

    }

    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal, parent, false);
        ImageView iv = (ImageView) v.findViewById(R.id.horizontal_image);
        return new ViewHolder(v, iv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getmImageView().setImageResource(R.drawable.california1);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }
}

