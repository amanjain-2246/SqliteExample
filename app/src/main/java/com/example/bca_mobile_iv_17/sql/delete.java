package com.example.bca_mobile_iv_17.sql;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    Context con=this;
    String uname,upass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        e1=(EditText)findViewById(R.id.editText5);
        e2=(EditText)findViewById(R.id.editText6);

        b1=(Button)findViewById(R.id.button9);
        b2=(Button)findViewById(R.id.button10);
        b1.setEnabled(false);
    }
    public void check(View view)
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
                if(cur.getString(0).equals(uname) && cur.getString(1).equals(upass))
                {
                    flag = true;
                    break;
                }
            }
            while(cur.moveToNext());

            if(flag==true)
            {
                Toast.makeText(con,uname+"EXIST...!!",Toast.LENGTH_LONG).show();
                b1.setEnabled(true);
            }
            else
            {
                Toast.makeText(con,"NOT EXIST..!! ",Toast.LENGTH_LONG).show();
            }
        }


    }


    public  void delusr(View view)
    {
        uname=e1.getText().toString();
        upass=e2.getText().toString();
        DbHelper mob=new DbHelper(con);
        try {
            mob.delete(mob,uname,upass);
            Toast.makeText(con, "deleted successfully..!!!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,MainActivity.class));
        }
        catch (Exception ex)
        {
            Toast.makeText(con, "err "+ex, Toast.LENGTH_LONG).show();
        }


    }
}
