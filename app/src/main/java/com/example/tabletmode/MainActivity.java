package com.example.tabletmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout fname,lname,mail,mob,desg,doj;

    Button sbmt;
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        fname=findViewById(R.id.firstname);
        lname=findViewById(R.id.lastname);
        mail=findViewById(R.id.mail);
        mob=findViewById(R.id.mobile);
        desg=findViewById(R.id.desg);
        doj=findViewById(R.id.doj);
        sbmt=findViewById(R.id.btnid);
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert(fname.getEditText().getText().toString(),lname.getEditText().getText().toString(),mail.getEditText().getText().toString(),mob.getEditText().getText().toString(),desg.getEditText().getText().toString(),doj.getEditText().getText().toString());

            }
        });


    }
    private void processinsert(String fn, String ln, String m, String mobile, String des, String dateofjoin) {


        String result=new DbManager(this).addrecord(fn,ln,m,mobile,des,dateofjoin);
        fname.getEditText().setText(" ");
        lname.getEditText().setText("");
        mail.getEditText().setText("");
        mob.getEditText().setText("");
        desg.getEditText().setText("");
        doj.getEditText().setText("");
        Toast.makeText(this, ""+result, Toast.LENGTH_LONG).show();

    }

    public void nextpage(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}