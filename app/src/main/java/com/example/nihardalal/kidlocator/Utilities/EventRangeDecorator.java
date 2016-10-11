package com.example.nihardalal.kidlocator.Utilities;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import com.example.nihardalal.kidlocator.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

/**
 * Created by Nihar Dalal on 8/8/2016.
 */
public class EventRangeDecorator implements DayViewDecorator {
    Drawable selector;
    CalendarDay first, last;
    public EventRangeDecorator(Drawable selector, @Nullable  CalendarDay first, @Nullable CalendarDay last){
        this.first = first;
        this.last = last;
        this.selector = selector;
    }

    public boolean shouldDecorate(CalendarDay day){
        return (day.isInRange(first, last) || day.equals(first) || day.equals(last));
    }

    public void decorate(DayViewFacade view){
        view.setSelectionDrawable(selector);
    }
}
