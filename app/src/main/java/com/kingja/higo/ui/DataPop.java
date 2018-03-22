package com.kingja.higo.ui;

import android.view.View;

import com.kingja.higo.R;
import com.kingja.popsir.BasePop;
import com.kingja.popsir.PopConfig;
import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.DefaultDayViewAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * Description:TODO
 * Create Time:2018/3/22 13:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DataPop extends BasePop {
    public DataPop(PopConfig popConfig) {
        super(popConfig);
    }

    @Override
    protected void initPop() {

    }

    @Override
    protected void initView(View contentView) {
        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);
        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        CalendarPickerView calendar = contentView.findViewById(R.id.calendar_view);
        calendar.setCustomDayView(new DefaultDayViewAdapter());
        Calendar today = Calendar.getInstance();
        ArrayList<Date> dates = new ArrayList<Date>();
        today.add(Calendar.DATE, 3);
        dates.add(today.getTime());
        today.add(Calendar.DATE, 5);
        dates.add(today.getTime());
        calendar.setDecorators(Collections.<CalendarCellDecorator>emptyList());
        calendar.init(new Date(), nextYear.getTime()) //
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDates(dates);
    }

    @Override
    protected View getLayoutView() {
        return View.inflate(context, R.layout.pop_date, null);
    }
}
