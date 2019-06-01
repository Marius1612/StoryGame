package com.example.mariu.darklight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Darklight_Menu extends AppCompatActivity {


    Button startBtn;
    Button chaptersBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        startBtn = findViewById(R.id.startBtn);
        chaptersBtn = findViewById(R.id.chaptersBtn);

    }

    public void chapterPage(View view) {
        Intent intent = new Intent(this, DarkLight_Chapters.class);
        this.startActivity(intent);
    }
}
