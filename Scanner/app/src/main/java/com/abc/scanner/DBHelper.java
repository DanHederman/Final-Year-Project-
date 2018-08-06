package com.abc.scanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "app";

    public static final String User_Table = "user_table";

    public static final String Col_1 = "First_Name";

    public static final String Col_2 = "Last_Name";

    public static final String Col_3 = "Email";

    public static final String Col_4 = "Password";


    // Instanciates the database so it can be accessed and used

    public DBHelper(Context context) {
        super(context, DB_Name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + User_Table + "(First_Name TEXT, Last_Name TEXT, Email TEXT, Password TEXT)  ");
    }

    /**
     * Takes in the database name and drops the table if it exists
     * @param db Reads in the database
     * @param i Reads in where to read from
     * @param i1 reads in .........
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + DB_Name);
        onCreate(db);
    }

    /**
     * Used get and display the data from the database(returns the information in the database)
     * @return the database contents
     */

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ User_Table,null);
        return res;
    }

    /**
     *
     * @param First_Name Takes in the users First_Name form the textView
     * @param Last_Name Takes in the users Last_Name from the text view
     * @param Email Takes in the users email address from the textView
     * @param Password Takes in the users password from the textView
     * @return result of attempted data insert
     */

    public boolean insertData(String First_Name, String Last_Name, String Email, String Password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,First_Name);
        contentValues.put(Col_2, Last_Name);
        contentValues.put(Col_3, Email);
        contentValues.put(Col_4, Password);
        long result = db.insert(User_Table, null, contentValues);

        return result != -1;
    }
}