package com.example.bca_mobile_iv_17.sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void regis(View view)
    {
        Intent in=new Intent(this,registration.class);
        startActivity(in);

    }

    public void viewuser(View view)
    {
        Intent inn=new Intent(this,Viewdata.class);
        startActivity(inn);

    }
    public void deluser(View view)
    {
        Intent dl=new Intent(this,delete.class);
        startActivity(dl);
    }
    public void log(View view)
    {
        Intent lo=new Intent(this,login.class);
        startActivity(lo);
    }
    public void updateuser(View view)
    {
        Intent up=new Intent(this,update.class);
        startActivity(up);
    }

}
