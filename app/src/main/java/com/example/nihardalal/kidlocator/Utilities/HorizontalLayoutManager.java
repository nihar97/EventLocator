package com.example.nihardalal.kidlocator.Utilities;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Nihar Dalal on 8/10/2016.
 */
public class HorizontalLayoutManager extends LinearLayoutManager {

    private int centeredItemOffset;

    public HorizontalLayoutManager(Context context) {
        super(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new Scroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public void setCenteredItemOffset(int centeredItemOffset) {
        this.centeredItemOffset = centeredItemOffset;
    }

    /**
     * ********** Inner Classes **********
     */

    private class Scroller extends LinearSmoothScroller {

        public Scroller(Context context) {
            super(context);
        }

        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return HorizontalLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override
        public int calculateDxToMakeVisible(View view, int snapPreference) {
            return super.calculateDxToMakeVisible(view, SNAP_TO_START) + centeredItemOffset;
        }
    }
}
