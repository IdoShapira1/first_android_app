package com.example.idoshapira_mbp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import java.util.Calendar;
import java.util.Date;
import android.widget.TextView;

import java.util.Calendar;


public class DifficultyPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_picker);
        final TextView name = (TextView) findViewById(R.id.playerName);
        final TextView age = (TextView) findViewById(R.id.playerAge);
        Button easy = (Button) findViewById(R.id.buttonEasy);
        Button medium = (Button) findViewById(R.id.buttonMedium);
        Button hard = (Button) findViewById(R.id.buttonHard);
        setTexts(name,age);
        setButtons(easy,medium,hard,name);

    }

    private void setTexts(TextView name, TextView age){ // Set text for name and age
        name.setText(getIntent().getStringExtra("userName")); // set name
        age.setText("Your age is: "+getIntent().getStringExtra("age"));
    }


    private void setButtons(Button easy, Button medium , Button hard,final TextView name){ // set intents for buttons
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DifficultyPicker.this,GameScreen.class);
                intent.putExtra("diff",30);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DifficultyPicker.this,GameScreen.class);
                intent.putExtra("diff",45);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DifficultyPicker.this,GameScreen.class);
                intent.putExtra("diff",60);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
            }
        });


    }



}
