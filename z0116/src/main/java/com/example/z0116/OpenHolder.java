package com.example.z0116;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHolder extends SQLiteOpenHelper {
    public OpenHolder(Context context) {
        super(context, "peng.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table xiao(id integer primary key autoincrement," +
                "imageUrl text," +
                "name text," +
                "releaseTimeShow text," +
                "summary text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
