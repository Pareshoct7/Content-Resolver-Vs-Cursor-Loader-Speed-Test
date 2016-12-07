package com.example.contactsimportlibrary.ElementContainers;

import android.database.Cursor;
import com.example.contactsimportlibrary.FieldElements.NumberElements.LabelElement;
import com.example.contactsimportlibrary.FieldElements.NumberElements.NormNumElement;
import com.example.contactsimportlibrary.FieldElements.NumberElements.NumberElement;
import com.example.contactsimportlibrary.FieldElements.NumberElements.NumberTypeElement;
import com.example.contactsimportlibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;

public class NumberContainer
{
    @Expose
    private NumberElement number;
    @Expose
    private NormNumElement normalizedNumber;
    @Expose
    private NumberTypeElement numType;
    @Expose
    private LabelElement numLabel;

    public NumberContainer(Cursor cursor) {
        number = new NumberElement(cursor);
        normalizedNumber = new NormNumElement(cursor);
        numType = new NumberTypeElement(cursor);
        numLabel = new LabelElement(cursor);
    }

    public static Set<String> getFieldColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(NumberElement.column);
        columns.add(NormNumElement.column);
        columns.add(NumberTypeElement.column);
        columns.add(LabelElement.column);
        return columns;
    }

    public String elementValue() {

        String result = Utility.elementValue(number);
        return result;
    }
    public String getNormalizedNumber() {

        String result = Utility.elementValue(normalizedNumber);
        return result;
    }
    public String getNumlabel() {

        String result = Utility.elementValue(numLabel);
        return result;
    }
    public String getNumType() {

        String result = Utility.elementValue(numType);
        return result;
    }


}