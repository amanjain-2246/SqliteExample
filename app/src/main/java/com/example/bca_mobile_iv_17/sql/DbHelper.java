package com.example.bca_mobile_iv_17.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by BCA-MOBILE-IV-17 on 3/28/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
public static final String KEY_ID="_id";
public static final String USER_NAME="user_name";
public static final String USER_PASS="user_pass";
public static final String TAB_NAME="myinfo";
private static final String DB_NAME="my.db";
private static final int DB_VER=1;
    private static final String CREATE_QUERY="create table " + TAB_NAME +" ( " + KEY_ID +
            " integer primary key autoincrement , " + USER_NAME + " text not null ," + USER_PASS + " text not null);";


public DbHelper(Context context)
{
    super(context,DB_NAME,null,1);

}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("rrrr","oncreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TAB_NAME);
        Log.d("hello","onupgrade");
        onCreate(db);
    }

    public void putinfo(DbHelper mob,String name,String pass)
    {
        SQLiteDatabase sd=mob.getWritableDatabase();
        ContentValues CV=new ContentValues();
        CV.put(USER_NAME,name);
        CV.put(USER_PASS,pass);
        sd.insert(TAB_NAME,null,CV);

    }

    public Cursor getAllRows(DbHelper mob)
    {
       SQLiteDatabase sq = mob.getReadableDatabase();
        Cursor cob =sq.query(TAB_NAME,null,null,null,null,null,null);
        if(cob!=null)
        {
            cob.moveToFirst();
        }
        return cob;

    }

    public  Cursor login(DbHelper mob)
    {
       SQLiteDatabase sb=mob.getWritableDatabase();
        String col[]={USER_NAME,USER_PASS};
        Cursor cob=sb.query(TAB_NAME,col,null,null,null,null,null);
        return cob;
    }

    public void delete(DbHelper mob,String username,String userpass)
    {
       String selection=USER_NAME+ " LIKE ? AND " + USER_PASS +" LIKE ? ";
        String args[]={username,userpass};
        SQLiteDatabase sq=mob.getWritableDatabase();
        sq.delete(TAB_NAME,selection,args);

    }

    public  void update(DbHelper mob,String username,String userpass,String newusername,String newpassword )
    {
       String selection=USER_NAME + " LIKE ? AND " + USER_PASS + " LIKE ? ";
        String args[]={username,userpass};
        SQLiteDatabase sq=mob.getWritableDatabase();
        ContentValues CV=new ContentValues();
         CV.put(USER_NAME,newusername);
        CV.put(USER_PASS,newpassword);

        sq.update(TAB_NAME,CV,selection,args);
    }

    public Cursor getpass(DbHelper mob,String username)
    {
       SQLiteDatabase sq=mob.getReadableDatabase();
        String selection=USER_NAME +"LIKE ? ";
        String col[]={USER_PASS};
        String args[]={username};
        Cursor cr=sq.query(TAB_NAME,col,selection,args,null,null,null);
        return  cr;
    }

}
