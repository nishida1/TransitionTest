package com.example.nishida.transitiontest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, Common.DB_NAME, null, Common.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+
                Common.DB_TABLE+"(id integer primary key autoincrement,lastdate text,latitude text,longitude text,reserved text, currentdt text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+Common.DB_TABLE);
        onCreate(db);
    }
}

