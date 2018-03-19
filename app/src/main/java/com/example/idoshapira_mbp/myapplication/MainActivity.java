package com.example.idoshapira_mbp.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final String TAG = "Exe1";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private int pressCounter=0;
    private boolean firstSet = true;
    private boolean secondSet = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button1 = findViewById(R.id.button1);
        button2 =  findViewById(R.id.button2);
        button3 =  findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

    }

    public void buttonOnClick1(View v) {
        button1.setBackgroundColor(Color.BLUE);
        button1.setEnabled(false);
        colorChecker();
    }
    public void buttonOnClick2(View v) {
        button2.setBackgroundColor(Color.GREEN);
        button2.setEnabled(false);
        colorChecker();
    }
    public void buttonOnClick3(View v) {
        button3.setBackgroundColor(Color.BLUE);
        button3.setEnabled(false);
        colorChecker();
    }
    public void buttonOnClick4(View v) {
        button4.setBackgroundColor(Color.GREEN);
        button4.setEnabled(false);
        colorChecker();
    }

    public void colorChecker() {
        pressCounter+=1;

        if(pressCounter == 2)
        {
            pressCounter=0;
            if(!button1.isEnabled() && !button3.isEnabled())
           {
                button1.setBackgroundColor(Color.BLACK);
                button3.setBackgroundColor(Color.BLACK);
                button1.setEnabled(false);
                button3.setEnabled(false);
                firstSet = false; // dont check again

            }
            if(!button2.isEnabled() && !button4.isEnabled())
            {
                button2.setBackgroundColor(Color.BLACK);
                button4.setBackgroundColor(Color.BLACK);
                button2.setEnabled(false);
                button4.setEnabled(false);
                secondSet = false; // dont check again

            }

            resetButtons();

        }

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
