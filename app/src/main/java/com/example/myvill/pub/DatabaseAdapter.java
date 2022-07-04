package com.example.myvill.pub;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.myvill.R;

public class DatabaseAdapter {

    DatabaseHelper helper;
    SQLiteDatabase db;
    Context context;

    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        this.context = context;
    }

    public SimpleCursorAdapter populateListViewFromDB(){
        String columns[] = {DatabaseHelper.KEY_NAME, DatabaseHelper.KEY_ADDRESS,DatabaseHelper.KEY_PHONE};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns,null, null,null, null, null, null);
        String[] fromFieldNames = new String[]{
                DatabaseHelper.KEY_NAME, DatabaseHelper.KEY_ADDRESS,DatabaseHelper.KEY_PHONE
        };
        int[] toViewIDs = new int[]{R.id.item_name, R.id.item_address,R.id.item_phone};
        SimpleCursorAdapter contactAdapter = new SimpleCursorAdapter(
                context,
                R.layout.single_item,
                cursor,
                fromFieldNames,
                toViewIDs
        );
        return contactAdapter;
    }



    private static class DatabaseHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "contacts.db";
        private static final String TABLE_NAME = "contacts";
        // When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 1;
        private static final String KEY_NAME="name";
        public static final String KEY_ADDRESS = "address";
        public static final String KEY_PHONE = "phone";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_NAME+" integer primary key autoincrement, "+ KEY_NAME + " text, "+ KEY_ADDRESS+ " text)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                //db.execSQL(CREATE_TABLE);
                Toast.makeText(context, "onCreate called", Toast.LENGTH_SHORT).show();
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try{
                Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
                //db.execSQL(DROP_TABLE);
                //onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
