package com.example.mariu.darklight;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return;
        }

        closeAppYesBtn=findViewById(R.id.closeAppYesBtn);
        closeAppNoBtn=findViewById(R.id.closeAppNoBtn);
        startBtn=findViewById(R.id.startBtn);
        quitBtn=findViewById(R.id.quitBtn);
        chaptersBtn=findViewById(R.id.chaptersBtn);
        areYouSureQuitPopup = findViewById(R.id.areYouSureQuitPopup);
    }

    public void quitApp(View view) {
        closeAppYesBtn.setVisibility(closeAppYesBtn.VISIBLE);
        closeAppNoBtn.setVisibility(closeAppNoBtn.VISIBLE);
        startBtn.setVisibility(closeAppNoBtn.INVISIBLE);
        quitBtn.setVisibility(closeAppNoBtn.INVISIBLE);
        chaptersBtn.setVisibility(closeAppNoBtn.INVISIBLE);
        areYouSureQuitPopup.setVisibility(areYouSureQuitPopup.VISIBLE);


    }


    public void quitAppYesAction(View view) {
        Intent intent = new Intent(this, Darklight_Menu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Exit me", true);
        startActivity(intent);
        finish();
    }

    public void quitAppNoAction(View view) {
        closeAppYesBtn.setVisibility(closeAppYesBtn.INVISIBLE);
        closeAppNoBtn.setVisibility(closeAppNoBtn.INVISIBLE);
        startBtn.setVisibility(closeAppNoBtn.VISIBLE);
        quitBtn.setVisibility(closeAppNoBtn.VISIBLE);
        chaptersBtn.setVisibility(closeAppNoBtn.VISIBLE);
        areYouSureQuitPopup.setVisibility(areYouSureQuitPopup.INVISIBLE);
    }

    public void chapterPage(View view) {
        Intent intent = new Intent(this, DarkLight_Chapters.class);
        this.startActivity(intent);
    }
}
