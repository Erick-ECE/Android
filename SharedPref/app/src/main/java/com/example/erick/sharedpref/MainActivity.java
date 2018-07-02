package com.example.erick.sharedpref;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Switch s1;
    EditText e1;
    TextView t1;
    LinearLayout ll;
    public static final String SHARED_PREFS = "Shared_Prefs";
    public static final String COLOR = "color";
    public static final String SWITCH1 = "switch1";
    int color;
    int color2;
    boolean sw_v;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = findViewById(R.id.ly1);
        Switch s1 = findViewById(R.id.sw1);
        btn1();
        btn2();
        load();
        update();


    }

    private void update() {
        ll.setBackgroundColor(color2);
        s1.setChecked(sw_v);

    }

    private void load() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        color2 = sp.getInt(COLOR,0);
        sw_v = sp.getBoolean(SWITCH1,false);

    }

    private void btn1(){
        Button b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(225,
                        rnd.nextInt(256),
                        rnd.nextInt(256),
                        rnd.nextInt(256));
                ll.setBackgroundColor(color);
            }
        });
    }

    private void btn2(){
        Button b2 = findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });
    }

    private void guardar() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(COLOR,color);
        editor.putBoolean(SWITCH1,s1.isChecked());
        editor.apply();
        Toast.makeText(this,"sp guardadas",Toast.LENGTH_LONG);

    }



}
