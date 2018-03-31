package com.example.idoshapira_mbp.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;
public class MainActivity extends AppCompatActivity {

    final String TAG = "Exe1";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private int pressCounter=0;
    private boolean firstSet = true; //buttons 1,3
    private boolean secondSet = true; //button 2,4
    private boolean thirdSet = true; // button 5,6



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button1 = findViewById(R.id.button1);
        button2 =  findViewById(R.id.button2);
        button3 =  findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        resetButtons();
    }

    public void buttonOnClick1(View v) {
        switch(v.getId())
        {
            case R.id.button1:
            {
                button1.setBackgroundColor(Color.BLUE);
                button1.setEnabled(false);
                break;
            }
            case R.id.button3:
            {
                button3.setBackgroundColor(Color.BLUE);
                button3.setEnabled(false);
                break;
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                colorChecker(button1,button3);
            }
        },500);


    }
    public void buttonOnClick2(View v) {
        switch(v.getId())
        {
            case R.id.button2:
            {
                button2.setBackgroundColor(Color.YELLOW);
                button2.setEnabled(false);
                break;
            }
            case R.id.button4:
            {
                button4.setBackgroundColor(Color.YELLOW);
                button4.setEnabled(false);
                break;
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                colorChecker(button2,button4);
            }
        },500);    }


    public void buttonOnClick3(View v) {
        switch(v.getId())
        {
            case R.id.button5:
            {
                button5.setBackgroundColor(Color.GREEN);
                button5.setEnabled(false);
                break;
            }
            case R.id.button6:
            {
                button6.setBackgroundColor(Color.GREEN);
                button6.setEnabled(false);
                break;
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                colorChecker(button5,button6);
            }
        },500);    }


    public void colorChecker(Button first, Button second) {
        pressCounter+=1;
        if(pressCounter == 2)
        {
            pressCounter=0;
            if(!first.isEnabled() && !second.isEnabled())
            {
                first.setBackgroundResource(R.drawable.pig);
                second.setBackgroundResource(R.drawable.pig);
                if(first.getText().toString().equals("Button 1"))
                    firstSet = false;
                else if(first.getText().toString().equals("Button 2"))
                    secondSet= false;
                else
                    thirdSet = false;

            }
            if(!firstSet && !secondSet && !thirdSet)
                finishGame();
            resetButtons();
        }
    }

    public void finishGame(){
        Toast.makeText(getApplicationContext(),"GAME FINISHED!",Toast.LENGTH_LONG).show();
    }

    public void resetButtons(){
        if(firstSet)
        {
            button1.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button1.setEnabled(true);
            button3.setEnabled(true);
        }
        if(secondSet)
        {
            button2.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button2.setEnabled(true);
            button4.setEnabled(true);
        }
        if(thirdSet)
        {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button5.setEnabled(true);
            button6.setEnabled(true);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
