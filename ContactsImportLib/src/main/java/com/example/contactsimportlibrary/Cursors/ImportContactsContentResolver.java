package com.example.contactsimportlibrary.Cursors;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.contactsimportlibrary.Cursors.ImportContactsCursorLoader;
import com.example.contactsimportlibrary.FieldContainer.FieldsContainer;
import com.example.contactsimportlibrary.Contact.Contact;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;


public class ImportContactsContentResolver extends QueryFields
{
    private Activity context;

    public ImportContactsContentResolver(Activity context)
    {
        this.context = context;
    }

    public ArrayList<Contact> getMobileContacts()
    {
        Cursor cursor = getContentResolverCursor();
        ArrayList<Contact> contacts = null;

        if (cursor!=null)
        {
            contacts = super.getContacts(cursor);
        }

        if (cursor==null || contacts==null)
        {
            contacts = new ArrayList<>();
        }

        if (cursor != null)
        {
            cursor.close();
        }

        return contacts;
    }

    private Cursor getContentResolverCursor() {
        return context.getContentResolver().
                    query(ContactsContract.Data.CONTENT_URI,       // The content URI of the words table
                    super.getColumns(),                            // The columns to return for each row
                    super.getFilter(),                             // Selection criteria
                    super.getKeyWord(),                            // Selection criteria
                    ContactsContract.Data.DISPLAY_NAME);
    }

}



