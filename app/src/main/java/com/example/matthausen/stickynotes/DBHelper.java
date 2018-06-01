package com.example.matthausen.stickynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SQLiteExample.db";
    private static final int DATABASE_VERSION = 1;
    public static final String INPUT_TABLE_NAME = "input";
    public static final String INPUT_COLUMN_ID = "_id";
    public static final String INPUT_COLUMN_Text = "text";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + INPUT_TABLE_NAME + "(" +
                INPUT_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                INPUT_COLUMN_Text + " TEXT )"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + INPUT_TABLE_NAME);
        onCreate(db);
    }




    public boolean insertPerson(String title,String text) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INPUT_COLUMN_Text, text);
        db.insert(INPUT_TABLE_NAME, null, contentValues);
        return true;
    }


    public Cursor getAllPersons() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + INPUT_TABLE_NAME, null );
        return res;
    }


    public Cursor getPerson(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + INPUT_TABLE_NAME + " WHERE " +
                INPUT_COLUMN_ID + "=?", new String[] { id } );
        return res;
    }


    public void deleteSingleContact(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(INPUT_TABLE_NAME, INPUT_COLUMN_ID + "=?", new String[]{id});
//KEY_NAME is a column name
    }
}

