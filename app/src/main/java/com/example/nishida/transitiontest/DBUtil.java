package com.example.nishida.transitiontest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBUtil {

    //TODO: TB
    public static void writeDB(String lastdate, String latitude, String longitude, String reserved, String currentdt, SQLiteDatabase db) throws Exception {

        Log.v("sqltest", lastdate);
        Log.v("sqltest", latitude);

        ContentValues values = new ContentValues();
        values.put("lastdate", lastdate);
        values.put("latitude", latitude);
        values.put("longitude", longitude);
        values.put("reserved", reserved);
        values.put("currentdt", currentdt);
        db.insert(Common.DB_TABLE, null, values);
    }

    public static ArrayList<AdapterItem> readDB(ArrayList<AdapterItem> dbitems, SQLiteDatabase db) throws Exception {
        dbitems = new ArrayList<AdapterItem>();
        Cursor c = db.query(Common.DB_TABLE, new String[]{"id", "lastdate", "latitude", "longitude", "reserved", "currentdt"},
                null, null, null, null, "id desc");
        if (c.moveToFirst()) {
            do {
                Log.v("sqltest", Integer.toString(c.getInt(0)));
                Log.v("sqltest", c.getString(1));
                AdapterItem item = new AdapterItem();
                item.id = Integer.toString(c.getInt(0));
                item.lastdate = c.getString(1);
                item.latitude = c.getString(2);
                item.longitude = c.getString(3);
                item.reserved = c.getString(4);
                item.currentdt = c.getString(5);
                dbitems.add(item);
            } while (c.moveToNext());
        }
        c.close();
        return dbitems;
    }

}
