package com.example.erick.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {
    Button nx,bk;
    Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c0,plus,equal,ac;
    EditText pad;
    int res;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        nx = findViewById(R.id.nx);
        bk = findViewById(R.id.bk);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c0 = findViewById(R.id.c0);
        plus = findViewById(R.id.plus);
        equal = findViewById(R.id.equal);
        ac = findViewById(R.id.ac);
        pad = findViewById(R.id.pad);

        //btn next
        nx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Calculadora.this, Table.class);
                startActivity(intent);
            }
        });
        backto();
        // listeners
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);
        c9.setOnClickListener(this);
        c0.setOnClickListener(this);
        plus.setOnClickListener(this);
        equal.setOnClickListener(this);
        ac.setOnClickListener(this);

        res = suma(pad.getText().toString());


    }

    public int suma(String n){
       sum = sum + Integer.parseInt(n);
        return sum;

    }


    private void backto(){
        //btn back
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bck= new Intent(Calculadora.this, Layouts.class);
                startActivity(bck);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c1 :
                pad.setText(pad.getText()+"1");
                break;
            case R.id.c2 :
                pad.setText(pad.getText()+"2");
                break;
            case R.id.c3 :
                pad.setText(pad.getText()+"3");
                break;
            case R.id.c4 :
                pad.setText(pad.getText()+"4");
                break;
            case R.id.c5 :
                pad.setText(pad.getText()+"5");
                break;
            case R.id.c6 :
                pad.setText(pad.getText()+"6");
                break;
            case R.id.c7 :
                pad.setText(pad.getText()+"7");
                break;
            case R.id.c8 :
                pad.setText(pad.getText()+"8");
                break;
            case R.id.c9 :
                pad.setText(pad.getText()+"9");
                break;
            case R.id.c0 :
                pad.setText(pad.getText()+"0");
                break;
            case R.id.plus :
                res = suma(pad.getText().toString());
                pad.setText("");
                break;
            case R.id.equal :
                String a = String.valueOf(res);
                pad.setText(a);
                break;
            case R.id.ac :
                res = 0;
                sum = 0;
                pad.setText("");
                break;
        }

    }
}
