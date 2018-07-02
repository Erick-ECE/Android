package com.example.erick.multimedia;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SintetVoice extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintet_voice);
        tv = findViewById(R.id.sint_tv);
    }

    public void sintent(View view){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());



        if(getIntent().resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,10);
            tv.setText(intent.getDataString());
        }else {
            Toast.makeText(getApplicationContext(),"no soportado por el dispositivo",Toast.LENGTH_SHORT).show();
        }
    }
}
