package com.example.digicode.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class SqlHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bdDigicode";

    public SqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE users ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "login TEXT, "+
                "password TEXT )";

        String CREATE_SALLE_TABLE = "CREATE TABLE salles ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nom TEXT )";

        String CREATE_DIGICODE_TABLE = "CREATE TABLE digicode (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idSalle INTEGER, " +
                "idDate INTEGER, " +
                "idDigicode INTEGER )";

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_SALLE_TABLE);
        db.execSQL(CREATE_DIGICODE_TABLE);

        // Creation d'un jeu d'essai

        db.execSQL("INSERT INTO users VALUES(1,'a@gmail.com',123)");
        db.execSQL("INSERT INTO users VALUES(2,'b@gmail.com',456)");

        db.execSQL("INSERT INTO salles VALUES(1,'Majorelle')");
        db.execSQL("INSERT INTO salles VALUES(2,'Gruber')");
        db.execSQL("INSERT INTO salles VALUES(3,'Lamour')");
        db.execSQL("INSERT INTO salles VALUES(4,'Longwy')");
        db.execSQL("INSERT INTO salles VALUES(5,'Daum')");
        db.execSQL("INSERT INTO salles VALUES(6,'Gallé')");
        db.execSQL("INSERT INTO salles VALUES(7,'Corbin')");
        db.execSQL("INSERT INTO salles VALUES(8,'Baccarat')");

        db.execSQL("INSERT INTO digicode VALUES(1,1,1,1234)");
        db.execSQL("INSERT INTO digicode VALUES(2,1,2,5678)");
        db.execSQL("INSERT INTO digicode VALUES(3,2,1,9101)");
        db.execSQL("INSERT INTO digicode VALUES(4,2,2,1213)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS salles");
        db.execSQL("DROP TABLE IF EXISTS digicode");
    }

    private static final String TABLE_USERS = "users";

    private static final String TABLE_SALLES = "salles";
    private static final String TABLE_DIGICODE = "digicode";


    private static final String USERS_KEY_ID = "id";
    private static final String USERS_KEY_LOGIN = "login";
    private static final String USERS_KEY_PASSWORD = "password";

    private static final String[] USERS_COLUMNS = {USERS_KEY_ID,USERS_KEY_LOGIN,USERS_KEY_PASSWORD};


    private static final String SALLES_NOM = "nom";
    private static final String SALLES_ID = "id";

    private static final String[] SALLES_COLUMNS = {SALLES_ID,SALLES_NOM};

    private static final String DIGICODE_ID = "id";
    private static final String DIGICODE_SALLE = "idSalle";
    private static final String DIGICODE_DATE = "idDate";
    private static final String DIGICODE_DIG = "idDigicode";

    private static final String[] DIGICODE_COLUMNS = {DIGICODE_ID,DIGICODE_SALLE,DIGICODE_DATE,DIGICODE_DIG};

    public boolean login(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE login=? AND password=?", new String[]{login,password});

        if (mCursor != null) {
            if(mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public ArrayList getSalles(){
        ArrayList<String> salles = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.query(TABLE_SALLES, SALLES_COLUMNS, null, null, null, null, null);

        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            salles.add(mCursor.getString(1));
            Log.i("aled", mCursor.getString(1));
            mCursor.moveToNext();
        }
        mCursor.close();

        return salles;
    }

    public int recupDigicode(String mois, String numeroSalle){

        int digicode = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.query(TABLE_DIGICODE, DIGICODE_COLUMNS, "idDate=" + mois + " AND idSalle=" + numeroSalle, null, null, null, null);

        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            digicode = mCursor.getInt(mCursor.getColumnIndex(DIGICODE_DIG));
            mCursor.moveToNext();
        }
        mCursor.close();

        return digicode;
    }

}
