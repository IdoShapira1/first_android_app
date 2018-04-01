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
        TextView name = (TextView) findViewById(R.id.playerName);
        TextView age = (TextView) findViewById(R.id.playerAge);
        name.setText(getIntent().getStringExtra("userName")); // set name
        int year = getIntent().getIntExtra("year",0); // get year
        int month = getIntent().getIntExtra("month",0); // get month
        int day = getIntent().getIntExtra("day",0); // get day
        age.setText("Your age is:"+getAge(year,month,day)+" IS THIS YOUR BIRTHDAY? "+isBirthday(month,day));


    }

    private String getAge(int year, int month, int day){ // calculate Age
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dob.set(year, month, day);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();
        return ageS;
    }

    private boolean isBirthday(int month,int day){
        Calendar today = Calendar.getInstance();
        return (today.get(Calendar.MONTH) == month && today.get(Calendar.DAY_OF_MONTH) == day); // check month and day
    }
}
