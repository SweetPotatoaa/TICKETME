package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "Login.db";//database of TicketMe

    private  static final String TABLE_USER = "users";//user authentication
    private static final String TABLE_USER_ACCOUNT = "users_account";//user interface (tickets and statistics)
    private static final String TABLE_ARTICLES = "articles";//list of articles TicketMe recognizes

    private static final String KEY_ID = "id";

    /******************************A T T R I B U T E S****************************************/

    /*********************************AUTHENTICATION******************************************/

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE_NB = "phone_nb";

    /************************************ARTICLES********************************************/

    private static final String KEY_BARCODE = "barcode";
    private static final String KEY_PRICE = "price";
    private static final String KEY_ARTICLE_NAME = "article_name";
    private static final String KEY_CATEGORY = "category";

    /**************************************************************************************/

    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERNAME + " TEXT" +
            KEY_PASSWORD + "TEXT" + KEY_ADDRESS + "TEXT" + KEY_EMAIL + "TEXT" + KEY_PHONE_NB + "TEXT);";

    /*private static final String CREATE_TABLE_USER_ACCOUNT = "CREATE TABLE "
            + TABLE_USER_ACCOUNT + "(" + KEY_ID + " INTEGER,"+ KEY_HOBBY + " TEXT );";
*/
    private static final String CREATE_TABLE_ARTICLES = "CREATE TABLE "
            + TABLE_ARTICLES + "(" + KEY_ID + " INTEGER,"+ KEY_BARCODE + " TEXT" +
            KEY_PRICE + "TEXT" + KEY_ARTICLE_NAME + "TEXT" + KEY_CATEGORY + "TEXT);";


    public DatabaseHelper (Context context){ super(context, "Login.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //this will create a table with 2 colums username and password
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        //or : MyDB.execSQL(CREATE_TABLE_USERS);

        //MyDB.execSQL(CREATE_TABLE_USER_ACCOUNT);
        MyDB.execSQL(CREATE_TABLE_ARTICLES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users"); // or : MyDB.execSQL("drop table if exists ' " + TABLE_USER + "'");
        MyDB.execSQL("drop table if exists ' " + TABLE_USER_ACCOUNT + "'");
        MyDB.execSQL("drop table if exists ' " + TABLE_ARTICLES + "'");
        onCreate(MyDB);
    }

    //method to add a user
    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users",null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean updatepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("password", password);
        long result = MyDB.update("users", contentValues, "username = ?", new String[] {username});
        if (result==-1) return false;
        else
            return true;
    }

    //check if the username already exists or not in the table
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        //if the user exists
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //check the password
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

}