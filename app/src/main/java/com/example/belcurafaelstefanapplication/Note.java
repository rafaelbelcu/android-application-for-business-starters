package com.example.belcurafaelstefanapplication;

import java.util.ArrayList;
import java.util.Date;

public class Note
{
    public static ArrayList<Note> noteArrayList = new ArrayList<>();
    public static String EditNote =  "noteEdit";
    private int noteid;
    private String notetitle;
    private String notecontent;
    private java.util.Date deletednote;

    public Note(int noteid, String notetitle, String notecontent, Date deletednote)
    {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notecontent = notecontent;
        this.deletednote = deletednote;
    }

    public Note(int noteid, String notetitle, String notecontent)
    {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notecontent = notecontent;
    }

    public static Note getNoteForID(int passedNoteID)
    {
        for (Note note : noteArrayList)
        {
            if(note.getNoteid() == passedNoteID)
                return note;
        }

        return null;
    }

    public static ArrayList<Note> nonDeletedNotes()
    {
        ArrayList<Note> nonDeleted = new ArrayList<>();
        for(Note note : noteArrayList)
        {
            if(note.getDeletednote() == null)
                nonDeleted.add(note);
        }

        return nonDeleted;
    }

    public int getNoteid()
    {
        return noteid;
    }

    public void setNoteid(int noteid)
    {
        this.noteid = noteid;
    }

    public String getNotetitle()
    {
        return notetitle;
    }

    public void setNotetitle(String notetitle)
    {
        this.notetitle = notetitle;
    }

    public String getNotecontent()
    {
        return notecontent;
    }

    public void setNotecontent(String notecontent)
    {
        this.notecontent = notecontent;
    }

    public Date getDeletednote() {
        return deletednote;
    }

    public void setDeletednote(Date deletednote) {
        this.deletednote = deletednote;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteid=" + noteid +
                ", notetitle='" + notetitle + '\'' +
                ", notecontent='" + notecontent + '\'' +
                ", deletednote=" + deletednote +
                '}';
    }
}
