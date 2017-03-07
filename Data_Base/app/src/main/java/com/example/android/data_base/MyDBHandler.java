package com.example.android.data_base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sanjaypradeep on 21-09-2016.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "product.db";
    public static final String TABLE_NAME = "san";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "name";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             String query = "CREATE TABLE "+TABLE_NAME+"(" +
                     COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                     COLUMN_PRODUCT_NAME + " VARCHAR(255)"+
                     ");";
         db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addproduct(Product product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME,product.getProduct_name());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public void deleteproduct(String product){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+"WHERE"+COLUMN_PRODUCT_NAME+"= \""+product+"\"");
    }

    public String databasetostring(){
        String dbstring = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();
        while(c.moveToNext()){

            if(c.getString(c.getColumnIndex("name"))!=null){
                    dbstring+=c.getString(c.getColumnIndex("name"));
                    dbstring+="\n";
            }
        }
        return dbstring;
    }
}
