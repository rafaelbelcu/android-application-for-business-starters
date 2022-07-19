package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Notes extends AppCompatActivity {
    private ListView noteLV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initializationWidgets();
        setNoteAdapter();
        loadFromDatabase();
        setOnClickListener();
    }

    private void initializationWidgets()
    {
        noteLV = findViewById(R.id.noteLV);
    }

    private void setNoteAdapter()
    {
        NotesAdapter notesAdapter = new NotesAdapter(getApplicationContext(), Note.nonDeletedNotes());
        noteLV.setAdapter(notesAdapter);
    }

    public void addaNote(View view)
    {
        Intent addaNoteIntent = new Intent(this, NotesExtended.class);
        startActivity(addaNoteIntent);
    }

    private void loadFromDatabase()
    {
        NotesSQLite notesSQLite = NotesSQLite.instanceOfDatabase(this);
        notesSQLite.populatetheNoteListArray();
    }

    private void setOnClickListener()
    {
        noteLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Note selectedNote = (Note) noteLV.getItemAtPosition(position);
                Intent editNoteIntent = new Intent(getApplicationContext(), NotesExtended.class);
                editNoteIntent.putExtra(Note.EditNote, selectedNote.getNoteid());
                startActivity(editNoteIntent);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setNoteAdapter();
    }
}