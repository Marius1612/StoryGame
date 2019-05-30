package com.example.mariu.darklight.chapters;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mariu.darklight.R;


public class Darklight_ChapterOne extends AppCompatActivity {
    int life = 10;
    int light = 10;
    TextView lifePoints;
    TextView lightPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_one);
        lifePoints = (TextView) findViewById(R.id.lifePointsNumberTxt);
        lightPoints =(TextView)findViewById(R.id.lightNumberTxt);
        displayText();

    }

    public void displayText()
    {
        lifePoints.setText("Life: "+String.valueOf(life));
        lightPoints.setText("Light: "+String.valueOf(life));
    }

}
