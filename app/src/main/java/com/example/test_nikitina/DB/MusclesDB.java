package com.example.test_nikitina.DB;

public class MusclesDB {
    public static final String TABLE_NAME="Muscles";
    public static final String ID="id";
    public static final String ID_GROUP="id_group";
    public static final String NAME="name";
    public static final String DB_NAME="mydb.db";
    public static final int DB_VERSION= 1;

    public static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXIST" + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    ID_GROUP + " INTEGER NOT NULL," +
                    NAME + " TEXT)" ;

    public static final String TABLE_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
