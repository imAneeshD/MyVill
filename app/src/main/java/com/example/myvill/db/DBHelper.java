package com.example.myvill.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "contacts.db", null, 1);
}

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table contacts(name TEXT primary key, address TEXT, phone TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists contacts");
    }
    public Boolean insertuserdata(String name, String address, String phone)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("phone", phone);
        long result = DB.insert("contacts", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from contacts", null);
        return cursor;
    }
    public Boolean deleteuserdata(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from contacts where name = ?", new String[]{name});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("contacts", "name=?", new String[]{name});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

}