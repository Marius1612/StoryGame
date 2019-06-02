package com.example.mariu.darklight.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mariu.darklight.Darklight_Menu;
import com.example.mariu.darklight.R;
import com.example.mariu.darklight.death.Death;


public class Darklight_ChapterOne extends AppCompatActivity {
    private int life = 10;
    private int light = 10;

    private boolean sword = true;
    private boolean knifes = true;

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
    Button lastChoiceBtn;

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_one);

        scrollView = findViewById(R.id.scrollView3);
        scrollView.scrollTo(0, 0);

        lifePointsTxt = findViewById(R.id.lifePointsNumberTxt);
        lightPointsTxt = findViewById(R.id.lightNumberTxt);
        storyTxtOneTxt = findViewById(R.id.storyTxtOne);

        nextIfYouAreDeadBtn = findViewById(R.id.nextBtn);
        restartChapterBtn = findViewById(R.id.restartChapterBtn);
        restartFromTheLastCheckPointBtn = findViewById(R.id.restartFromTheLastCheckPointBtn);
        goToMenuFromChapterOneBtn = findViewById(R.id.goToMenuFromAChapterBtn);
        lastChoiceBtn = findViewById(R.id.lastChoiceBtn);

        warnBtn = findViewById(R.id.warnBtn);
        talkBtn = findViewById(R.id.talkBtn);
        throwBtn = findViewById(R.id.throwBtn);
        chargeWithKnivesBtn = findViewById(R.id.chargeWithKnivesBtn);
        castAProtectiveShieldBtn = findViewById(R.id.castProtectionBtn);
        runBtn = findViewById(R.id.runBtn);


        showStats();
        storyTxtOneTxt.setText(R.string.storyChapterOneSecondOption);

    }

    public void showStats() {
        lifePointsTxt.setText(String.format("Life: %s", String.valueOf(life)));
        lightPointsTxt.setText(String.format("Light: %s", String.valueOf(light)));
    }


    public void restartOptions(View view) {

        if (restartFromTheLastCheckPointBtn.getVisibility() == View.GONE) {
            restartFromTheLastCheckPointBtn.setVisibility(View.VISIBLE);
            restartChapterBtn.setVisibility(View.VISIBLE);
            goToMenuFromChapterOneBtn.setVisibility(View.VISIBLE);
            lastChoiceBtn.setVisibility(View.VISIBLE);
        } else if (restartFromTheLastCheckPointBtn.getVisibility() == View.VISIBLE) {
            restartFromTheLastCheckPointBtn.setVisibility(View.GONE);
            restartChapterBtn.setVisibility(View.GONE);
            goToMenuFromChapterOneBtn.setVisibility(View.GONE);
            lastChoiceBtn.setVisibility(View.GONE);
        }
    }

    public void warnAction(View view) {
        sword = false;
        life -= 2;
        warnBtn.setVisibility(View.GONE);
        talkBtn.setVisibility(View.GONE);
        throwBtn.setVisibility(View.GONE);
        storyTxtOneTxt.setText(R.string.warnHerChoice);
        showStats();
        chargeWithKnivesBtn.setVisibility(View.VISIBLE);
        runBtn.setVisibility(View.VISIBLE);
        castAProtectiveShieldBtn.setVisibility(View.VISIBLE);
        scrollView.scrollTo(0, 0);
        Toast.makeText(this, "-2 life", Toast.LENGTH_LONG).show();
    }


    public void chargeWithKnives(View view) {
        storyTxtOneTxt.setText(R.string.chargeWithKnivesChoice);
        life -= 8;
        showStats();
        checkForDeath();
        Toast.makeText(this, "-8 life", Toast.LENGTH_LONG).show();
    }

    private void makeAllTheButtonsVanish() {
        warnBtn.setVisibility(View.GONE);
        talkBtn.setVisibility(View.GONE);
        throwBtn.setVisibility(View.GONE);
        chargeWithKnivesBtn.setVisibility(View.GONE);
        runBtn.setVisibility(View.GONE);
        castAProtectiveShieldBtn.setVisibility(View.GONE);
    }

    public void goToDeathLayout(View view) {
        Intent intent = new Intent(this, Death.class);
        this.startActivity(intent);
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
