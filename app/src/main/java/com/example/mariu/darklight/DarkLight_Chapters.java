package com.example.mariu.darklight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DarkLight_Chapters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
    }

    public void backToMenuFromChapters(View view) {
        Intent intent = new Intent(this, Darklight_Menu.class);
        this.startActivity(intent);

    }
}
