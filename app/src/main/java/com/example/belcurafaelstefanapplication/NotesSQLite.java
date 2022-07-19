package com.example.belcurafaelstefanapplication;

import android.annotation.SuppressLint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesSQLite extends SQLiteOpenHelper
{
    private static NotesSQLite notesSQLite;

    private static final String DBName = "NoteDatabase";
    private static final String Table = "NoteTable";
    private static final String FieldId = "noteid";
    private static final String FieldTitle = "notetitle";
    private static final String FieldDescription = "notecontent1";
    private static final String FieldDeleted = "deletednote";
    private static final int DBVersion = 1;
    private static final String Counter = "Counter";

    @SuppressLint("SimpleDateFormat")
    private static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

    public NotesSQLite(Context context)
    {
        super(context, DBName, null, DBVersion);
    }

    public static NotesSQLite instanceOfDatabase(Context context)
    {
        if(notesSQLite == null)
            notesSQLite = new NotesSQLite(context);
        return notesSQLite;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        StringBuilder sqlite;
        sqlite = new StringBuilder()
                .append("CREATE TABLE ")
                .append(Table)
                .append("(")
                .append(Counter)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(FieldId)
                .append(" INT, ")
                .append(FieldTitle)
                .append(" TEXT, ")
                .append(FieldDescription)
                .append(" TEXT, ")
                .append(FieldDeleted)
                .append(" TEXT)");
        sqLiteDatabase.execSQL(sqlite.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    { }

    public void addaNoteToDatabase(Note note)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FieldId, note.getNoteid());
        values.put(FieldTitle, note.getNotetitle());
        values.put(FieldDescription, note.getNotecontent());
        values.put(FieldDeleted, getStringFromDate(note.getDeletednote()));
        sqLiteDatabase.insert(Table, null, values);
    }

    private String getStringFromDate(Date date)
    {
        if(date == null)
            return null;
        return dateFormat.format(date);
    }

    private Date getDateFromString(String string)
    {
        try
        {
            return dateFormat.parse(string);
        }
        catch (ParseException | NullPointerException e)
        {
            return null;
        }
    }

    public void populatetheNoteListArray()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + Table, null))
        {
            if(result.getCount() != 0)
            {
                while (result.moveToNext())
                {
                    int noteid = result.getInt(1);
                    String notetitle = result.getString(2);
                    String notecontent1 = result.getString(3);
                    String stringDeleted = result.getString(4);
                    Date deletednote = getDateFromString(stringDeleted);
                    Note note = new Note(noteid, notetitle, notecontent1, deletednote);
                    Note.noteArrayList.add(note);
                }
            }
        }
    }

    public void updatetheNote(Note note)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FieldId, note.getNoteid());
        contentValues.put(FieldTitle, note.getNotetitle());
        contentValues.put(FieldDescription, note.getNotecontent());
        contentValues.put(FieldDeleted, getStringFromDate(note.getDeletednote()));
        sqLiteDatabase.update(Table, contentValues, FieldId + " =? ", new String[]{String.valueOf(note.getNoteid())});
    }

}
