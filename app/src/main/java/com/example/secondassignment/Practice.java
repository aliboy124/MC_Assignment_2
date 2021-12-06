package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Practice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPractice);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void go(View view){
        // getResourceEntryName will return the string version of id
        String str = getResources().getResourceEntryName(view.getId());
        str = "@drawable/"+str;
        Intent intent = new Intent(Practice.this,PracticePreview.class);
        intent.putExtra("image_name",str);
            startActivity(intent);
    }
}