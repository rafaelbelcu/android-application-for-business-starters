package com.example.belcurafaelstefanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Note>
{
    public NotesAdapter(Context context, List<Note> notes)
    {
        super(context, 0, notes);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Note note = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_section, parent, false);
        TextView notetitle = convertView.findViewById(R.id.sectiontitle);
        TextView notecontent1 = convertView.findViewById(R.id.sectiondescription);
        notetitle.setText(note.getNotetitle());
        notecontent1.setText(note.getNotecontent());
        return convertView;
    }
}