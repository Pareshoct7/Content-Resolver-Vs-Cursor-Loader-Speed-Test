package com.example.contactsimportlibrary.Abstracts;

import android.database.Cursor;

import com.example.contactsimportlibrary.ElementContainers.NumberContainer;

import java.util.LinkedList;
import java.util.Set;

public abstract class FieldParent
{
    public abstract Set<String> registerElementsColumns();
    public abstract void execute(String mime, Cursor cursor);
}


