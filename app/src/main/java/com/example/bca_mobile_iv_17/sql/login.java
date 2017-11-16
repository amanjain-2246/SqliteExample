package com.example.bca_mobile_iv_17.sql;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
EditText e1,e2;
    String uname,upass;
    Context con=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
    }

    public void usrlogin(View view)
    {
        uname=e1.getText().toString();
        upass=e2.getText().toString();
        DbHelper mob=new DbHelper(con);
        Cursor cur=mob.login(mob);
        boolean flag=false;
        if(cur!=null)
        {
           cur.moveToFirst();
            do
            {
             if(cur.getString(0).equals(uname) && cur.getString(1).equals(upass)) {
                 flag = true;
                 break;
             }
                }while(cur.moveToNext());

        if(flag==true)
        {
            Toast.makeText(con,"login successfully..!! "+uname,Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,MainActivity.class));
        }
        else
        {
            Toast.makeText(con,"login denied..!! ",Toast.LENGTH_LONG).show();
        }
        }


        }


        public void  clr(View view)
        {
            e1.setText("");
            e2.setText("");
        }


    }

