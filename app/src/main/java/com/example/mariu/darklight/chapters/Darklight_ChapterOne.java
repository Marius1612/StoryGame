package com.example.mariu.darklight.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mariu.darklight.Darklight_Menu;
import com.example.mariu.darklight.R;
import com.example.mariu.darklight.death.Death;
import com.example.mariu.darklight.utility.StoryStrings;


public class Darklight_ChapterOne extends AppCompatActivity {
    int life = 10;
    int light = 10;

    TextView lifePointsTxt;
    TextView lightPointsTxt;
    TextView storyTxtOneTxt;
    Death death = new Death();

    Button warnBtn;
    Button talkBtn;
    Button throwBtn;
    Button nextIfYouAreDeadBtn;
    Button chargeWithKnivesBtn;
    Button runBtn;
    Button castAProtectiveShieldBtn;

    Button restartFromTheLastCheckPointBtn;
    Button restartChapterBtn;
    Button goToMenuFromChapterOneBtn;

    StoryStrings storyStrings = new StoryStrings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_one);

        lifePointsTxt = findViewById(R.id.lifePointsNumberTxt);
        lightPointsTxt = findViewById(R.id.lightNumberTxt);
        storyTxtOneTxt = findViewById(R.id.storyTxtOne);

        nextIfYouAreDeadBtn = findViewById(R.id.nextBtn);
        restartChapterBtn = findViewById(R.id.restartChapterBtn);
        restartFromTheLastCheckPointBtn = findViewById(R.id.restartFromTheLastCheckPointBtn);
        goToMenuFromChapterOneBtn = findViewById(R.id.goToMenuFromAChapterBtn);

        warnBtn = findViewById(R.id.warnBtn);
        talkBtn = findViewById(R.id.talkBtn);
        throwBtn = findViewById(R.id.throwBtn);
        chargeWithKnivesBtn = findViewById(R.id.chargeWithKnivesBtn);
        castAProtectiveShieldBtn = findViewById(R.id.castProtectionBtn);
        runBtn = findViewById(R.id.runBtn);


        showStats();
        storyTxtOneTxt.setText(storyStrings.Story1);

    }

    public void showStats() {
        lifePointsTxt.setText("Life: " + String.valueOf(life));
        lightPointsTxt.setText("Light: " + String.valueOf(light));
    }


    public void restartOptions(View view) {

        if (restartFromTheLastCheckPointBtn.getVisibility() == View.GONE) {
            restartFromTheLastCheckPointBtn.setVisibility(View.VISIBLE);
            restartChapterBtn.setVisibility(View.VISIBLE);
            goToMenuFromChapterOneBtn.setVisibility(View.VISIBLE);
        } else if (restartFromTheLastCheckPointBtn.getVisibility() == View.VISIBLE) {
            restartFromTheLastCheckPointBtn.setVisibility(View.GONE);
            restartChapterBtn.setVisibility(View.GONE);
            goToMenuFromChapterOneBtn.setVisibility(View.GONE);
        }
    }

    public void warnAction(View view) {
        life -= 2;
        warnBtn.setVisibility(View.GONE);
        talkBtn.setVisibility(View.GONE);
        throwBtn.setVisibility(View.GONE);
        storyTxtOneTxt.setText(storyStrings.WarnHerChoice);
        showStats();
        chargeWithKnivesBtn.setVisibility(View.VISIBLE);
        runBtn.setVisibility(View.VISIBLE);
        castAProtectiveShieldBtn.setVisibility(View.VISIBLE);
    }


    public void goToDeathLayout(View view) {
        Intent intent = new Intent(this, Death.class);
        this.startActivity(intent);
    }

    public void chargeWithKnives(View view) {
        storyTxtOneTxt.setText(storyStrings.chargeWithKnives);
        life -= 8;
        showStats();
        checkForDeath();
    }

    private void makeAllTheButtonsVanish() {
        warnBtn.setVisibility(View.GONE);
        talkBtn.setVisibility(View.GONE);
        throwBtn.setVisibility(View.GONE);
        chargeWithKnivesBtn.setVisibility(View.GONE);
        runBtn.setVisibility(View.GONE);
        castAProtectiveShieldBtn.setVisibility(View.GONE);
    }

    private void checkForDeath() {
        if (death.isDeath(life)) {
            makeAllTheButtonsVanish();
            nextIfYouAreDeadBtn.setVisibility(View.VISIBLE);
        }
    }

    public void goToMenuFromAChapterAction(View view) {
        Intent intent = new Intent(this, Darklight_Menu.class);
        this.startActivity(intent);
    }
}
