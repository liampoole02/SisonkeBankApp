package com.example.liam.sisonkebankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text, firstname text, lastname text, mobile text, currentaccount double, savingsaccount double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }

    public boolean addUser(User user){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put("email", user.getUserEmail());
        contentValues.put("password", user.getUserPassword());
        contentValues.put("firstname", user.getUserName());
        contentValues.put("lastname", user.getUserSurname());
        contentValues.put("mobile", user.getUserMobile());
        contentValues.put("currentaccount", user.getCurrentAccountBal());
        contentValues.put("savingsaccount", user.getSavingsAccountBal());

        long ins=db.insert("user", null, contentValues);

        if (ins==-1)return false;
        else return true;
    }

     public boolean checkEmail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0){
            return false;
        }else{
            return true;
        }
     }

     public boolean emailPassword(String email, String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=? and password=?", new String[]{email,password});
        if(cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor getUserDetails(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?", new String[]{email});
        return cursor;
    }
}
