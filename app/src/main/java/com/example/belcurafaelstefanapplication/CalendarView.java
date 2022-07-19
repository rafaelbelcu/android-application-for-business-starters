package com.example.belcurafaelstefanapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarView extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final TextView day;
    private final CalendarViewAdapter.OnClickItemListener onClickItemListener;
    public CalendarView(@NonNull View itemView, CalendarViewAdapter.OnClickItemListener onClickItemListener)
    {
        super(itemView);
        day = itemView.findViewById(R.id.thedayTxt);
        this.onClickItemListener = onClickItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        onClickItemListener.OnItemClick(getAdapterPosition(), (String) day.getText());
    }
}

