package com.example.bca_mobile_iv_17.sql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {
EditText e1,e2;
    String s1,s2;
    Context cob=this;
    Button rege;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        rege=(Button)findViewById(R.id.button3);
        rege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                DbHelper mydb=new DbHelper(cob);
                mydb.putinfo(mydb,s1,s2);
                Toast.makeText(getBaseContext(),"Registration Succussfull..!!",Toast.LENGTH_LONG).show();

                finish();
            }

        }

        );


    }
}
