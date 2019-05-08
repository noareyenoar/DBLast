package com.porducer.test3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnect extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "PlatformDB";
    private static final int VERSION = 100;

    public DBConnect(Context context){ //Contructor
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String DBCreate = "CREATE TABLE IF NOT EXISTS PET" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Username TEXT, " +
                "Password TEXT, " +
                "Regis_Date TEXT, " +
                "PET_Name TEXT, " +
                "PET_Birth TEXT, " +
                "PET_Species TEXT, " +
                "PET_Breed TEXT, ";
        db.execSQL(DBCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){
        onCreate(db);
    }

    public void Regis(String Username, String Password, String Regis_Date, String PET_Name,String PET_Birth, String PET_Species, String PET_Breed){
        SQLiteDatabase db = getWritableDatabase();
        String Register = "INSERT INTO PET(Username, Password, Regis_Date, PET_Name, PET_Birth, PET_Species, PET_Breed)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        String[] RegisValue = {Username, Password, Regis_Date, PET_Name, PET_Birth, PET_Species, PET_Species, PET_Breed};
        db.execSQL(Register, RegisValue);
    }


}
