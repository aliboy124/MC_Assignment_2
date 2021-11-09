package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exam extends AppCompatActivity {

    final String questionStatement = " - Select the articulation point of the letter ";
    int totalQuestions = 20;
    int correctQuestions = 0;
    String currentLetter = "";
    Map<String, String[]> letters = new HashMap<String, String[]>();

    String[] throat = {"ة","أ","ع","ح","غ","خ"};
    String[] tongue = {"ق","ك","ج","ش","ى","ض","ل","ن","ر","ت","د","ط","ث","ذ","ظ","س","ز","ص"};
    String[] nose = {"م","ن"};
    String[] lips = {"ف","ب","م","و"};
    String[] mouth = {"بىِ","بوُ","باَ"};

    String[] questionLetters = {"ة","أ","ع","ح","غ","خ","ق","ك","ج","ش","ى","ض","ل","ن","ر","ت","د","ط","ث","ذ","ظ","س","ز","ص","م","ن","ف","ب","م","و","بىِ","بوُ","باَ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        letters.put("Throat",throat);
        letters.put("Tongue",tongue);
        letters.put("Nose",nose);
        letters.put("Lips",lips);
        letters.put("Mouth",mouth);

        updateQuestion();

    }
    public void updateQuestion(){
        TextView question = (TextView) findViewById(R.id.questionStatement);

        Random rand = new Random();
        int index = rand.nextInt(questionLetters.length);
        currentLetter = questionLetters[index];

        question.setText("Questions Left: "+totalQuestions+questionStatement+currentLetter+" ?");
    }
    public void moveToNext(View view){
        if(totalQuestions-- <= 0 ){   // incase exam over

            TextView question = (TextView) findViewById(R.id.questionStatement);
            question.setText("Congratulations you have scored:"+correctQuestions+" points out of 20!\nYou can share your results with the button below or go back.");
            Button btn = (Button) findViewById(R.id.Tongue);
            Button btn1 = (Button) findViewById(R.id.Throat);
            Button btn2 = (Button) findViewById(R.id.Lips);
            Button btn3 = (Button) findViewById(R.id.Nose);
            Button btn4 = (Button) findViewById(R.id.Mouth);

            btn1.setVisibility(view.INVISIBLE);
            btn2.setVisibility(view.INVISIBLE);
            btn3.setVisibility(view.INVISIBLE);
            btn4.setVisibility(view.INVISIBLE);

            btn.setText("Share");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    // using intent to implement share functionality

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "I have scored:"+correctQuestions+" points out of 20!";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Exam Result");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

                    // check if there is atleast one sharing app available

                    if(sharingIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                    }
                }
            });

        }else {     // exams is still underway
            String[] arr = letters.get(getResources().getResourceEntryName(view.getId()));
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(currentLetter)) {
                    correctQuestions++;
                    break;
                }
            }
            updateQuestion();
        }
    }
}