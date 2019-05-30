package com.example.mariu.darklight.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mariu.darklight.DarkLight_Chapters;
import com.example.mariu.darklight.R;
import com.example.mariu.darklight.utility.StoryStrings;


public class Darklight_ChapterOne extends AppCompatActivity {
    int life = 10;
    int light = 10;

    TextView lifePointsTxt;
    TextView lightPointsTxt;
    TextView storyTxtOneTxt;

    Button warnBtn;
    Button talkBtn;
    Button throwBtn;

    private String story;

    StoryStrings storyStrings = new StoryStrings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_one);

        lifePointsTxt = (TextView) findViewById(R.id.lifePointsNumberTxt);
        lightPointsTxt = (TextView) findViewById(R.id.lightNumberTxt);
        storyTxtOneTxt = (TextView) findViewById(R.id.storyTxtOne);

        warnBtn = (Button) findViewById(R.id.warnBtn);
        talkBtn = (Button) findViewById(R.id.talkBtn);
        throwBtn = (Button) findViewById(R.id.throwBtn);

        Game();
    }

    public void showStats() {
        lifePointsTxt.setText("Life: " + String.valueOf(life));
        lightPointsTxt.setText("Light: " + String.valueOf(light));
    }

    public void Game() {
        showStats();
        story=storyStrings.Story1;
        storyTxtOneTxt.setText(story);

    }

    public void backToChaptersFromChapter(View view) {
        Intent intent = new Intent(this, DarkLight_Chapters.class);
        this.startActivity(intent);
    }

    public void warnAction(View view) {
        life -= 2;
        warnBtn.setVisibility(View.INVISIBLE);
        talkBtn.setVisibility(View.INVISIBLE);
        throwBtn.setVisibility(View.INVISIBLE);
        story +=storyStrings.WarnHerChoice;
        storyTxtOneTxt.setText(story);
        showStats();


    }
}
