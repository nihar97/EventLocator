package com.example.nihardalal.kidlocator.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nihardalal.kidlocator.R;

/**
 * Created by Nihar Dalal on 8/11/2016.
 */
public class ListAdapter1 extends RecyclerView.Adapter<ListAdapter1.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView mTextView;

        public ViewHolder(View v, TextView tv) {
            super(v);
            mTextView =tv;
        }

        public View getmView() {
            return mView;
        }

        public TextView getmTextView() {
            return mTextView;
        }
    }

    private String[] mTexts = {
           "Flipkart", "Bookmyshow", "Snapdeal", "Freecharge", "Mobikwik", "Amazon"
    };

    @Override
    public ListAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list1, parent, false);
        TextView tv = (TextView) v.findViewById(R.id.shop);
        return new ListAdapter1.ViewHolder(v, tv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getmTextView().setText(mTexts[position]);
    }
    @Override
    public int getItemCount() {
        return mTexts.length;
    }
}
