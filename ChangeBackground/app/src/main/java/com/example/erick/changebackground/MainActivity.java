package com.example.erick.changebackground;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RelativeLayout uno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno = findViewById(R.id.lo1);
       // uno.setBackgroundColor(Color.parseColor("#fea"));
    }

    /*set the background color direct from the Color library*/
    public void color1(View view){
        uno.setBackgroundColor(Color.CYAN);
    }
    //obtain the color from the resources directory
    //for API up to 23 "getResources()" is not necessary
    public void color2(View view){
        uno.setBackgroundColor(getResources().getColor(R.color.colorTry));
    }

    //create a color giving values argb
    public void color3(View view){
        int colorgenerado = Color.argb(255,153,0,51);
        uno.setBackgroundColor(colorgenerado);
    }


    //generate a random color by setting random int rgb values
    public void randColor(View view){
        Random rand = new Random();
        int coloRand = Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        uno.setBackgroundColor(coloRand);
    }
}
