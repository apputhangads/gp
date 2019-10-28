package com.example.gp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME;

    static {
        TABLE_NAME = "ART";
    }

    public static final String COL_1="ID";
    public static final String COL_2="USERNAME";
    public static final String COL_3="PHONENUMBER";
    public static final String COL_4="EMAILID";
    public static final String COL_5="PASSWORD";

    public Databasehelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PHONENUMBER TEXT,EMAILID TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);
    }
}
