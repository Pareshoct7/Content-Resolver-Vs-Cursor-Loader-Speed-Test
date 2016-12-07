package com.example.contactsimportlibrary.ElementContainers;

import android.database.Cursor;

import com.example.contactsimportlibrary.FieldElements.AddressElement.AddressElement;
import com.example.contactsimportlibrary.FieldElements.AddressElement.AddressTypeElement;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;

public class AddressContainer
{
    private transient Cursor cursor;
    @Expose
    private AddressElement address;
    @Expose
    private AddressTypeElement addressType;

    public AddressContainer(Cursor cursor)
    {
        this.cursor = cursor;
        address = new AddressElement(cursor);
        addressType = new AddressTypeElement(cursor);
    }

    public static Set<String> getFieldColumns()
    {
        Set<String> columns = new HashSet<>();
        columns.add(AddressElement.column);
        return columns;
    }

    public String getAddress() {
        String result = Utility.elementValue(address);
        return result;
    }
    public String getAddressType()
    {
        String result = Utility.elementValue(addressType);
        return result;
    }

}