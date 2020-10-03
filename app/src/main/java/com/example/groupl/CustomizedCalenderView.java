package com.example.groupl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import androidx.annotation.Nullable;

public class CustomizedCalenderView extends LinearLayout {
    ImageButton NextButton, PreviousButton;
    TextView CurrentDate;
    GridView gridView;

    private static final int MAX_Calender_Days = 42;
    Calendar calender = Calendar.getInstance(Locale.ENGLISH);
    SimpleDateFormat form = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
    SimpleDateFormat monthform= new SimpleDateFormat("MMMM", Locale.ENGLISH);
    SimpleDateFormat yearform = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    List<Date> dates = new ArrayList<>();
    List<Plans> eventsList = new ArrayList<>();



    public CustomizedCalenderView(Context context) {
        super(context);
    }

    public CustomizedCalenderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
