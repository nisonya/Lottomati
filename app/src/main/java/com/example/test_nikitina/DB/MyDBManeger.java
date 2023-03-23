package com.example.test_nikitina.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_nikitina.Muscles;

import java.util.ArrayList;

public class MyDBManeger {
    private Context context;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;
    public MyDBManeger(Context context) {
        this.context = context;
        dbHelper = new MyDBHelper(context);
    }
    public void openDB(){
        db = dbHelper.getWritableDatabase();
    }
    public void insertDB(String Name, int ID_group, String Photo){
        ContentValues cv= new ContentValues();
        cv.put(MusclesDB.NAME, Name);
        cv.put(MusclesDB.ID_GROUP, ID_group);
        cv.put(MusclesDB.PHOTO, Photo);
        db.insert(MusclesDB.TABLE_NAME, null, cv);
    }

    public ArrayList<Muscles> readDB(){
       ArrayList<Muscles> templist = new ArrayList<>();
        Cursor cursor =db.query(MusclesDB.TABLE_NAME, null, null, null, null, null, null);
        while(cursor.moveToNext()) {
            int id =cursor.getInt(cursor.getColumnIndexOrThrow(MusclesDB.ID));
            int id_group =cursor.getInt(cursor.getColumnIndexOrThrow(MusclesDB.ID_GROUP));
            String name =cursor.getString(cursor.getColumnIndexOrThrow(MusclesDB.NAME));
            Muscles itemId = new Muscles(id, id_group,name);
            templist.add(itemId);
        }
        cursor.close();
        return templist;
    }
}
