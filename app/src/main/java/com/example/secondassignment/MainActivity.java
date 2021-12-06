package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.practice:
                intent = new Intent(this,Practice.class);
                startActivity(intent);
                return true;
            case R.id.exam:
                intent = new Intent(this,Exam.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView github = (ImageView) findViewById(R.id.github);
        github.setVisibility(View.INVISIBLE);
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
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