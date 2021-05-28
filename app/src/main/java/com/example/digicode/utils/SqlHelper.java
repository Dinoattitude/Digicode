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

        //janvier
        db.execSQL("INSERT INTO digicode VALUES(1,1,1,1532)");
        db.execSQL("INSERT INTO digicode VALUES(2,2,1,4562)");
        db.execSQL("INSERT INTO digicode VALUES(3,3,1,7866)");
        db.execSQL("INSERT INTO digicode VALUES(4,4,1,7575)");
        db.execSQL("INSERT INTO digicode VALUES(5,5,1,4567)");
        db.execSQL("INSERT INTO digicode VALUES(6,6,1,7532)");
        db.execSQL("INSERT INTO digicode VALUES(7,7,1,6721)");
        db.execSQL("INSERT INTO digicode VALUES(8,8,1,7865)");

        //fevrier
        db.execSQL("INSERT INTO digicode VALUES(9,1,2,7324)");
        db.execSQL("INSERT INTO digicode VALUES(10,2,2,4467)");
        db.execSQL("INSERT INTO digicode VALUES(11,3,2,2387)");
        db.execSQL("INSERT INTO digicode VALUES(12,4,2,1536)");
        db.execSQL("INSERT INTO digicode VALUES(13,5,2,2334)");
        db.execSQL("INSERT INTO digicode VALUES(14,6,2,7852)");
        db.execSQL("INSERT INTO digicode VALUES(15,7,2,7467)");
        db.execSQL("INSERT INTO digicode VALUES(16,8,2,7895)");

        //mars
        db.execSQL("INSERT INTO digicode VALUES(17,1,3,7832)");
        db.execSQL("INSERT INTO digicode VALUES(18,2,3,5766)");
        db.execSQL("INSERT INTO digicode VALUES(19,3,3,4566)");
        db.execSQL("INSERT INTO digicode VALUES(20,4,3,4231)");
        db.execSQL("INSERT INTO digicode VALUES(21,5,3,7821)");
        db.execSQL("INSERT INTO digicode VALUES(22,6,3,4532)");
        db.execSQL("INSERT INTO digicode VALUES(23,7,3,3742)");
        db.execSQL("INSERT INTO digicode VALUES(24,8,3,3723)");

        //avril
        db.execSQL("INSERT INTO digicode VALUES(25,1,4,7833)");
        db.execSQL("INSERT INTO digicode VALUES(26,2,4,7895)");
        db.execSQL("INSERT INTO digicode VALUES(27,3,4,7896)");
        db.execSQL("INSERT INTO digicode VALUES(28,4,4,1345)");
        db.execSQL("INSERT INTO digicode VALUES(29,5,4,1237)");
        db.execSQL("INSERT INTO digicode VALUES(30,6,4,7861)");
        db.execSQL("INSERT INTO digicode VALUES(31,7,4,1345)");
        db.execSQL("INSERT INTO digicode VALUES(32,8,4,6542)");

        //mai
        db.execSQL("INSERT INTO digicode VALUES(33,1,5,9452)");
        db.execSQL("INSERT INTO digicode VALUES(34,2,5,3542)");
        db.execSQL("INSERT INTO digicode VALUES(35,3,5,6789)");
        db.execSQL("INSERT INTO digicode VALUES(36,4,5,3123)");
        db.execSQL("INSERT INTO digicode VALUES(37,5,5,4567)");
        db.execSQL("INSERT INTO digicode VALUES(38,6,5,9543)");
        db.execSQL("INSERT INTO digicode VALUES(39,7,5,9456)");
        db.execSQL("INSERT INTO digicode VALUES(40,8,5,7532)");

        //juin
        db.execSQL("INSERT INTO digicode VALUES(41,1,6,7836)");
        db.execSQL("INSERT INTO digicode VALUES(96,2,6,4532)");
        db.execSQL("INSERT INTO digicode VALUES(42,3,6,7831)");
        db.execSQL("INSERT INTO digicode VALUES(43,4,6,2378)");
        db.execSQL("INSERT INTO digicode VALUES(44,5,6,9632)");
        db.execSQL("INSERT INTO digicode VALUES(45,6,6,3214)");
        db.execSQL("INSERT INTO digicode VALUES(46,7,6,9542)");
        db.execSQL("INSERT INTO digicode VALUES(47,8,6,9756)");

        //juillet
        db.execSQL("INSERT INTO digicode VALUES(48,1,7,7854)");
        db.execSQL("INSERT INTO digicode VALUES(49,2,7,4565)");
        db.execSQL("INSERT INTO digicode VALUES(50,3,7,8923)");
        db.execSQL("INSERT INTO digicode VALUES(51,4,7,6342)");
        db.execSQL("INSERT INTO digicode VALUES(52,5,7,9213)");
        db.execSQL("INSERT INTO digicode VALUES(53,6,7,9786)");
        db.execSQL("INSERT INTO digicode VALUES(54,7,7,2345)");
        db.execSQL("INSERT INTO digicode VALUES(55,8,7,5342)");

        //aout
        db.execSQL("INSERT INTO digicode VALUES(56,1,8,4567)");
        db.execSQL("INSERT INTO digicode VALUES(57,2,8,6548)");
        db.execSQL("INSERT INTO digicode VALUES(58,3,8,9231)");
        db.execSQL("INSERT INTO digicode VALUES(59,4,8,2546)");
        db.execSQL("INSERT INTO digicode VALUES(60,5,8,4567)");
        db.execSQL("INSERT INTO digicode VALUES(61,6,8,5682)");
        db.execSQL("INSERT INTO digicode VALUES(62,7,8,7536)");
        db.execSQL("INSERT INTO digicode VALUES(63,8,8,9675)");

        //septembre
        db.execSQL("INSERT INTO digicode VALUES(64,1,9,9456)");
        db.execSQL("INSERT INTO digicode VALUES(65,2,9,4567)");
        db.execSQL("INSERT INTO digicode VALUES(66,3,9,2321)");
        db.execSQL("INSERT INTO digicode VALUES(67,4,9,6765)");
        db.execSQL("INSERT INTO digicode VALUES(68,5,9,3453)");
        db.execSQL("INSERT INTO digicode VALUES(69,6,9,3483)");
        db.execSQL("INSERT INTO digicode VALUES(70,7,9,8799)");
        db.execSQL("INSERT INTO digicode VALUES(71,8,9,7897)");

        //octobre
        db.execSQL("INSERT INTO digicode VALUES(72,1,10,7889)");
        db.execSQL("INSERT INTO digicode VALUES(73,2,10,9789)");
        db.execSQL("INSERT INTO digicode VALUES(74,3,10,6456)");
        db.execSQL("INSERT INTO digicode VALUES(75,4,10,8799)");
        db.execSQL("INSERT INTO digicode VALUES(76,5,10,3123)");
        db.execSQL("INSERT INTO digicode VALUES(77,6,10,5645)");
        db.execSQL("INSERT INTO digicode VALUES(78,7,10,8797)");
        db.execSQL("INSERT INTO digicode VALUES(79,8,10,6542)");

        //novembre
        db.execSQL("INSERT INTO digicode VALUES(80,1,11,7878)");
        db.execSQL("INSERT INTO digicode VALUES(81,2,11,4562)");
        db.execSQL("INSERT INTO digicode VALUES(82,3,11,5846)");
        db.execSQL("INSERT INTO digicode VALUES(83,4,11,3687)");
        db.execSQL("INSERT INTO digicode VALUES(84,5,11,9365)");
        db.execSQL("INSERT INTO digicode VALUES(85,6,11,8976)");
        db.execSQL("INSERT INTO digicode VALUES(86,7,11,3786)");
        db.execSQL("INSERT INTO digicode VALUES(87,8,11,4562)");

        //decembre
        db.execSQL("INSERT INTO digicode VALUES(88,1,12,5463)");
        db.execSQL("INSERT INTO digicode VALUES(89,2,12,7869)");
        db.execSQL("INSERT INTO digicode VALUES(90,3,12,1325)");
        db.execSQL("INSERT INTO digicode VALUES(91,4,12,8796)");
        db.execSQL("INSERT INTO digicode VALUES(92,5,12,7893)");
        db.execSQL("INSERT INTO digicode VALUES(93,6,12,4562)");
        db.execSQL("INSERT INTO digicode VALUES(94,7,12,8734)");
        db.execSQL("INSERT INTO digicode VALUES(95,8,12,4562)");


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

    public boolean isValidLogin(String mail, String password) {
        boolean isEmpty = true;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.query(TABLE_USERS, USERS_COLUMNS, "login=\'" + mail + "\' AND password=" + password, null, null, null, null);

        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            isEmpty = mCursor.getCount() > 0 ? true : false;
            mCursor.moveToNext();
        }
        mCursor.close();

        return isEmpty;
    }

    public ArrayList getSalles(){
        ArrayList<String> salles = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.query(TABLE_SALLES, SALLES_COLUMNS, null, null, null, null, null);

        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            salles.add(mCursor.getString(1));
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
