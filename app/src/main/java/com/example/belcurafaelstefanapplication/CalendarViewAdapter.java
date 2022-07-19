package com.example.belcurafaelstefanapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarViewAdapter extends RecyclerView.Adapter<CalendarView> {
    private final OnClickItemListener onClickItemListener;
    private final ArrayList<String> theDaysOfTheMonth;

    public CalendarViewAdapter(ArrayList<String> theDaysOfTheMonth, OnClickItemListener onClickItemListener) {
        this.theDaysOfTheMonth = theDaysOfTheMonth;
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public CalendarView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.calendar, parent, false);
        ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        layoutparams.height = (int) (parent.getHeight() * 0.16);
        return new CalendarView(view, onClickItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarView holder, int position) {
        holder.day.setText(theDaysOfTheMonth.get(position));
    }

    @Override
    public int getItemCount() {
        return theDaysOfTheMonth.size();
    }

    public interface OnClickItemListener
    {
        void OnItemClick(int position, String dayText);
    }
}
