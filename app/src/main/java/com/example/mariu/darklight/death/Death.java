package com.example.mariu.darklight.death;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mariu.darklight.R;

public class Death extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.death);
    }

    public boolean isDeath(int life)
    {
        return life <= 0;
    }
}
