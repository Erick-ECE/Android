package com.example.erick.layouts;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.erick.layouts.R.layout.relative_layout;

public class Layouts extends AppCompatActivity {

    Button next;
    EditText input;
    TextView output;

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
        setContentView(relative_layout);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Layouts.this, Calculadora.class);
                startActivity(i);
            }
        });

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        putText();
        eraseText();

    }

    private void putText(){
        Button enter = findViewById(R.id.enter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // se asigna al textview  el texto obtenido del EditText
                output.setText(input.getText().toString());
            }
        });

       // txt.putExtra("text",input.getText().toString());
    }

    private void eraseText(){
        Button  cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se asigna la cadena vacia al TextView
                output.setText("");
            }
        });
        //output.setText(out.getExtras().getString("text"));
    }
}
