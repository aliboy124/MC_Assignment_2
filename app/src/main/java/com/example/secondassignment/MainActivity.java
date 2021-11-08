package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView github = (ImageView) findViewById(R.id.github);
        github.setVisibility(View.INVISIBLE);
    }
    public void goToApp(View view){
        Intent intent = new Intent(MainActivity.this,AppHome.class);
        startActivity(intent);
    }
    public void goToGithub(View view){
        Intent intent = new Intent( Intent.ACTION_VIEW , Uri.parse("https://github.com/aliboy124/MC_Assignment_2") );
        startActivity(intent);
    }
    public void switchImage(View view){
        Switch sw = (Switch) findViewById(R.id.switch1);
        ImageView github = (ImageView) findViewById(R.id.github);
        if(sw.isChecked()){
            github.setVisibility(View.VISIBLE);
        }
        else{
            github.setVisibility(View.INVISIBLE);
        }

    }
}