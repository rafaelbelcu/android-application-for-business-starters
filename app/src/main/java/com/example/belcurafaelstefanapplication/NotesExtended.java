package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Date;
public class NotesExtended extends AppCompatActivity {
    private EditText titleEdit, notecontentEdit;
    private Button deleteBTN;
    private Note selectedNote;
    private ImageView imageDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_extended);
        initializationWidgets();
        checkforediting();
    }

    private void initializationWidgets()
    {
        titleEdit = findViewById(R.id.editTitle);
        notecontentEdit = findViewById(R.id.editNoteContent);
        deleteBTN = findViewById(R.id.deletenoteBTN);
        imageDelete = findViewById(R.id.imageView10);
    }

    private void checkforediting()
    {
        Intent previousIntent = getIntent();

        int passedNoteID = previousIntent.getIntExtra(Note.EditNote, -1);
        selectedNote = Note.getNoteForID(passedNoteID);

        if (selectedNote != null)
        {
            titleEdit.setText(selectedNote.getNotetitle());
            notecontentEdit.setText(selectedNote.getNotecontent());
        }
        else
        {
            deleteBTN.setVisibility(View.INVISIBLE);
            imageDelete.setVisibility(View.INVISIBLE);
        }
    }

    public void savetheNote(View view)
    {
        NotesSQLite sqLiteManager = NotesSQLite.instanceOfDatabase(this);
        String notetitle = String.valueOf(titleEdit.getText());
        String notecontent1 = String.valueOf(notecontentEdit.getText());

        if(selectedNote == null)
        {
            int noteid = Note.noteArrayList.size();
            Note newNote = new Note(noteid, notetitle, notecontent1);
            Note.noteArrayList.add(newNote);
            sqLiteManager.addaNoteToDatabase(newNote);
        }
        else
        {
            selectedNote.setNotetitle(notetitle);
            selectedNote.setNotecontent(notecontent1);
            sqLiteManager.updatetheNote(selectedNote);
        }
        finish();
    }

    public void deletetheNote(View view)
    {
        selectedNote.setDeletednote(new Date());
        NotesSQLite notesSQLite = NotesSQLite.instanceOfDatabase(this);
        notesSQLite.updatetheNote(selectedNote);
        finish();
    }
}