package com.example.skyroot.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION =1;
    public static final String DB_NAME = "Results";

    public static final String TABLE_NAME1 = "result_data";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_RESULT = "result";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "(" + COLUMN_DATE + " TEXT," + COLUMN_RESULT + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int insertResult(int result) {

        ResultDB resultDB = new ResultDB(result);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_DATE, resultDB.getDate());
        values1.put(COLUMN_RESULT, resultDB.getResult());
        int i = (int) db.insert(TABLE_NAME1, null, values1);
        db.close();
        return i;
    }

    public ArrayList<ResultDB> returnDb()
    {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME1;

        ArrayList<ResultDB> resultDBList = new ArrayList<ResultDB>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        ResultDB resultDB = new ResultDB();
                        resultDB.setDate(cursor.getString(0));
                        resultDB.setResult(cursor.getInt(1));
                        resultDBList.add(resultDB);
                        System.out.println(cursor.getString(0));
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ex) {System.out.println(ex.getMessage());}
            }

        } finally {
            try { db.close(); } catch (Exception ex) {System.out.println(ex.getMessage());}
        }

        return resultDBList;
    }
}
