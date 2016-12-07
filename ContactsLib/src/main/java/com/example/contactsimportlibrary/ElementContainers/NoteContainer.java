package com.example.contactsimportlibrary.ElementContainers;

import android.database.Cursor;

import com.example.contactsimportlibrary.FieldElements.NoteElement.NoteElement;
import com.example.contactsimportlibrary.FieldElements.WebsiteElement.WebsiteElement;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;


public class NoteContainer
{
    @Expose
    private NoteElement note;

    public NoteContainer(Cursor cursor)
    {
        note = new NoteElement(cursor);
    }

    public static Set<String> getFieldColumns()
    {
        Set<String> columns = new HashSet<>();
        columns.add(NoteElement.column);
        return columns;
    }

    public String getNote()
    {
        String result = Utility.elementValue(note);
        return result;
    }

}
