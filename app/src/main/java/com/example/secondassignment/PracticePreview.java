package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PracticePreview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_preview);

        // This view exists merely to preview the images hence all code is in onCreate callback
        // We get the image name from intent Extra and then get the resource id and finally
        // set the image of our image view

        Intent intent = getIntent();
        String image_name = intent.getStringExtra("image_name");
        ImageView preview = (ImageView)  findViewById(R.id.preview_image);
        int resId = getResources().getIdentifier(image_name,"drawable",getPackageName());
        preview.setBackgroundResource(resId);
    }
}