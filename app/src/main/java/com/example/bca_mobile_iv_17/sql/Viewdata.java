package com.example.bca_mobile_iv_17.sql;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Viewdata extends AppCompatActivity {
Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        showListView();

    }
    private void showListView()
    {
        DbHelper myHelper=new DbHelper(context);
        Cursor cursorob =myHelper.getAllRows(myHelper);
        String[] fromDB=new String[]{DbHelper.KEY_ID,DbHelper.USER_NAME,DbHelper.USER_PASS};
        int[] toShow=new int[]{R.id.txt_id,R.id.txt_user,R.id.txt_pass};
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.onerow,cursorob,fromDB,toShow,0);
        ListView listView=(ListView)findViewById(R.id.mylist);
        listView.setAdapter(simpleCursorAdapter);


    }
}
