package com.example.contactsimportlibrary.FieldElements.EventElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import com.example.contactsimportlibrary.Abstracts.ElementParent;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class EventStartDateElement extends ElementParent
{
    @Expose
    private String eventStartDate = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Event.START_DATE;
    public static final String mime = ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE;

    public EventStartDateElement(Cursor cursor)
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
    public String getValue() {
        return eventStartDate;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        eventStartDate = Utility.getColumnIndex(cursor, column);

        if (eventStartDate == null)
        {
            eventStartDate = "";
        }
    }

}