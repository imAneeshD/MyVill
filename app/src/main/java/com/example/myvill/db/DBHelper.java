package com.example.myvill.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "myvill.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table contacts(name TEXT primary key, address TEXT, phone TEXT)");
        DB.execSQL("create Table admin(username TEXT primary key, password TEXT)");
    }


    public static void copyDB(Context context) {
        try {
            String destPath = "/data/data/" + context.getPackageName()
                    + "/databases";
            File f = new File(destPath);
            if (!f.exists()) {
                f.mkdir();
                //copy the db from assets folder into the databases folder
                rawCopy(context.getAssets().open("myvill.db"), new FileOutputStream(destPath + "/myvill.db"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rawCopy(InputStream inputStream, OutputStream outputStream) throws IOException {
        // copy 1k bytes at a time
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        // DB.execSQL("drop Table if exists contacts");
    }

    public Boolean insertuserdata(String name, String address, String phone) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("phone", phone);
        long result = DB.insert("contacts", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from contacts", null);
        return cursor;
    }

    public Boolean deleteuserdata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from contacts where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("contacts", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getNumber() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select number from contacts ", null);
        return cursor;

    }

}