package com.example.contactsimportlibrary.FieldElements.NameElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import com.example.contactsimportlibrary.Abstracts.ElementParent;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class DisplaydNameElement extends ElementParent
{
    @Expose
    private String displayName = "";
    @Expose
    private final String elementType;
    public static final String mime = "";
    public static final String column = ContactsContract.Data.DISPLAY_NAME;

    public DisplaydNameElement(Cursor cursor)
    {
        elementType = this.getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getElementType()
    {
        return elementType;
    }
    @Override
    public String getValue()
    {
        if (displayName==null)
        {
            displayName="";
        }

        return displayName;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        displayName = Utility.getColumnIndex(cursor, column);

        if (displayName == null)
        {
            displayName = "";
        }
    }

    public interface IDisplaydNameElement
    {
        String getDisplaydName();
    }
}