package com.example.contactsimportlibrary.FieldElements.NickNameElement;

import android.database.Cursor;
import android.provider.ContactsContract;
import com.example.contactsimportlibrary.Abstracts.ElementParent;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class NickNameElement extends ElementParent
{
    @Expose
    private String nickName = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Nickname.NAME;
    public static final String mime = ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE;

    public NickNameElement(Cursor cursor)
    {
        elementType = getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getElementType()
    {
        return elementType;
    }
    @Override
    public String getValue() {
        return nickName;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        nickName = Utility.getColumnIndex(cursor, column);

        if (nickName == null)
        {
            nickName = "";
        }
    }

}