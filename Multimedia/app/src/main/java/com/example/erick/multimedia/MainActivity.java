package com.example.erick.multimedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Video(View view){
        Intent intent = new Intent(this,Video.class);
        startActivity(intent);
    }

    public void Camara(View view){
        Intent intent = new Intent(this,Camara.class);
        startActivity(intent);
    }

    public void Musica(View view){
        Intent intent = new Intent(this,Musica.class);
        startActivity(intent);
    }

    public void Tonos(View view){
        Intent intent = new Intent(this,Tonos.class);
        startActivity(intent);
    }

    public void Sintetizador(View view){
        Intent intent = new Intent(this,SintetVoice.class);
        startActivity(intent);
    }

}
