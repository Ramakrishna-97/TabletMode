package com.example.tabletmode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname="dbcontact";
    public DbManager(@Nullable Context context) {
        super(context,dbname,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry="create table employeedata(id integer primary key autoincrement,fname text,lname text,mail text,mob text,desg text,doj text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry="DROP TABLE IF EXISTS employeedata";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }


    public String addrecord(String fn, String ln, String m, String mobile, String des, String dateofjoin) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("fname",fn);
        cv.put("lname",ln);
        cv.put("mail",m);
        cv.put("mob",mobile);
        cv.put("desg",des);
        cv.put("doj",dateofjoin);
        float res=db.insert("employeedata",null,cv);

        if(res==-1)
            return "Data Insertion Failed";
        else
            return  "Successfully inserted Data";


    }


    public Cursor readalldata() {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from employeedata order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }

}
