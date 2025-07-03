package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="Login.db";
    public DBHelper(Context context){
        super(context,"Login.db",null,1);
    }
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(email TEXT primary key,password TEXT,Fname TEXT,Lname TEXT,phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String email,String password,String Fname,String Lname,String phone){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("email",email);
        contentvalues.put("password",password);
        contentvalues.put("Fname",Fname);
        contentvalues.put("Lname",Lname);
        contentvalues.put("phone",phone);
        long result=MyDB.insert("users",null,contentvalues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkUser(String email){
       SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where email = ?",new String[]{email});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where email = ? and password = ?",new String[]{email,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
