package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Calendar extends AppCompatActivity implements CalendarViewAdapter.OnClickItemListener {
    private TextView monthAndYear;
    private RecyclerView calendarRV;
    private LocalDate date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initializeWidgets();
        date = LocalDate.now();
        setMonth();
    }

    private void setMonth() {
        monthAndYear.setText(monthYearDate(date));
        ArrayList<String> days = daysArray(date);

        CalendarViewAdapter calendarviewAdapter = new CalendarViewAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRV.setLayoutManager(layoutManager);
        calendarRV.setAdapter(calendarviewAdapter);
    }

    private String monthYearDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    private void initializeWidgets() {
        calendarRV = findViewById(R.id.calendarRV);
        monthAndYear = findViewById(R.id.monthandyear);

    }

    private ArrayList<String> daysArray(LocalDate date) {
        ArrayList<String> daysArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int daysOfMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = date.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        for (int i = 1; i <= 42; i++) {
            if (i <= dayOfWeek || i > daysOfMonth + dayOfWeek) {
                daysArray.add("");
            } else {
                daysArray.add(String.valueOf(i - dayOfWeek));
            }
        }
        return daysArray;
    }


    public void previousMonth(View view) {
        date = date.minusMonths(1);
        setMonth();
    }

    public void nextMonth(View view) {
        date = date.plusMonths(1);
        setMonth();
    }

    @Override
    public void OnItemClick(int position, String dayText) {
        if (!dayText.equals("")) {
            String message = "The Selected Date is " + dayText + " " + monthYearDate(date);
             Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}