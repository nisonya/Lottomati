package com.example.test_nikitina;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public final static int DATABASE_VERSION=1;
    public final static String DATABASE_NAME="my_db";
    public final static String TABLE_NAME="exercises";


    public final static String KEY_ID="_id";
    public final static String KEY_MUSCLE_ID="muscle_id";
    public final static String KEY_NAME="name";
    public final static String KEY_DESCRIPTION="desc";
    public final static String KEY_PHOTO="photo";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] name_exer= {"Barbell Overhead Press","Dumbbell Seated Overhead \nPress",
                "Cable Lateral Raise"};
        String[] photo= {"https://149874912.v2.pressablecdn.com/wp-content/uploads/2020/12/Overhead-press-exercise.gif",
                "https://thumbs.gfycat.com/ExcitableOblongFluke-max-1mb.gif",
                "https://fitnessprogramer.com/wp-content/uploads/2021/02/Cable-Lateral-Raise.gif"};
        String[] descr= {"Barbell_Overhead_Press", "Dumbbell_Seated_Overhead_Press", "Cable_Lateral_Raise"};
        int[] id_musle= {1,1,1};

        ContentValues cv = new ContentValues();
        //создаем таблицу
        db.execSQL("create table "+ TABLE_NAME + "("
                + KEY_ID+"integer primary key autoincrement,"+KEY_MUSCLE_ID +"integer,"
        +KEY_NAME+"text,"+KEY_DESCRIPTION+"text,"+KEY_PHOTO+"text"+")");

        //заполняем её
        for(int i =0;i< name_exer.length;i++){
            cv.clear();
            cv.put("KEY_MUSCLE_ID", id_musle[i]);
            cv.put("KEY_NAME", name_exer[i]);
            cv.put("KEY_DESCRIPTION", descr[i]);
            cv.put("KEY_PHOTO", photo[i]);
            db.insert(TABLE_NAME, null, cv);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
}
