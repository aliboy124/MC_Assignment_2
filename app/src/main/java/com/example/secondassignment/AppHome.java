package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
    }
    public void goToPractice(View view){
        Intent intent = new Intent(AppHome.this,Practice.class);
        startActivity(intent);
    }
    public void goToExam(View view){
        Intent intent = new Intent(AppHome.this,Exam.class);
        startActivity(intent);
    }
}