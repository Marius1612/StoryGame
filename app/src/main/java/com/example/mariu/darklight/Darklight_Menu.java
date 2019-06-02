package com.example.mariu.darklight;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

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

    public void changeLanguage(View view) {
        if(Locale.getDefault().getLanguage().equals("ro")) {
            setLocale("Default language");
            Toast.makeText(this, "Selected language: English", Toast.LENGTH_LONG).show();
        }
        else {
            setLocale("ro");
            Toast.makeText(this, "Limba selectata: Romana", Toast.LENGTH_LONG).show();
        }
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, Darklight_Menu.class);
        startActivity(refresh);
        finish();
    }
}
