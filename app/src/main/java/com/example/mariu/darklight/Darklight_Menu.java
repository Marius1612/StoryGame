package com.example.mariu.darklight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Darklight_Menu extends AppCompatActivity {

    Button closeAppYesBtn;
    Button closeAppNoBtn;
    Button startBtn;
    Button quitBtn;
    Button chaptersBtn;
    TextView areYouSureQuitPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        closeAppYesBtn = findViewById(R.id.closeAppYesBtn);
        closeAppNoBtn = findViewById(R.id.closeAppNoBtn);
        startBtn = findViewById(R.id.startBtn);
        quitBtn = findViewById(R.id.quitBtn);
        chaptersBtn = findViewById(R.id.chaptersBtn);
        areYouSureQuitPopup = findViewById(R.id.areYouSureQuitPopup);
    }

    public void quitApp(View view) {
        closeAppYesBtn.setVisibility(View.VISIBLE);
        closeAppNoBtn.setVisibility(View.VISIBLE);
        startBtn.setVisibility(View.INVISIBLE);
        quitBtn.setVisibility(View.INVISIBLE);
        chaptersBtn.setVisibility(View.INVISIBLE);
        areYouSureQuitPopup.setVisibility(View.VISIBLE);
    }


    public void quitAppYesAction(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void quitAppNoAction(View view) {
        closeAppYesBtn.setVisibility(View.INVISIBLE);
        closeAppNoBtn.setVisibility(View.INVISIBLE);
        startBtn.setVisibility(View.VISIBLE);
        quitBtn.setVisibility(View.VISIBLE);
        chaptersBtn.setVisibility(View.VISIBLE);
        areYouSureQuitPopup.setVisibility(View.INVISIBLE);
    }

    public void chapterPage(View view) {
        Intent intent = new Intent(this, DarkLight_Chapters.class);
        this.startActivity(intent);
    }
}
