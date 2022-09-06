package com.example.tabletmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelClass> modelClassArrayList;

    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        recyclerView=findViewById(R.id.recyclerfragA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        count=findViewById(R.id.TotalCount);

        Cursor cursor=new DbManager(this).readalldata();
        modelClassArrayList=new ArrayList<>();

        while(cursor.moveToNext())
        {

            ModelClass model=new ModelClass(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            modelClassArrayList.add(model);

        }

        AdapterClass adapter=new AdapterClass(modelClassArrayList);
        recyclerView.setAdapter(adapter);

        count.setText("Total Count:"+""+adapter.modelClassList.size());

    }
}