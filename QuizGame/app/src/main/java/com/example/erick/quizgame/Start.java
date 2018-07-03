package com.example.erick.quizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity implements View.OnClickListener{
    Button start,exit,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        start = findViewById(R.id.start);
        exit = findViewById(R.id.exit);
        settings = findViewById(R.id.settings);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exit :
                finish();
                break;
            case R.id.start :
                Intent intent = new Intent(this, Topic.class);
                startActivity(intent);
                break;
            case R.id.settings :
                Intent i = new Intent(this, Settings.class);
                startActivity(i);
                break;
        }
    }
}
