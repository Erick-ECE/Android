package com.example.erick.sharedpref;

import android.content.Context;
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
    public static final Random _RAND = new Random();
    Button btn_guardar,btn_randColor;
    LinearLayout lo;
    Switch stch1;
    int new_color;
    int saved_color;
    boolean switch_state;
    private static final String _MIS_PREFERENCIAS = "Mis_Preferencias";
    private static final String _BACKGROUND = "Background";
    private static final String _MARCADOR = "Marcador";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_randColor = findViewById(R.id.btn_randomColors);
        btn_guardar = findViewById(R.id.btn_save);
        lo = findViewById(R.id.ly1);
        stch1 = findViewById(R.id.sw1);
        loadPreferences();

    }

    public void setRandBackground(View view){
       new_color =  Color.argb(255,
               _RAND.nextInt(255),
               _RAND.nextInt(255),
               _RAND.nextInt(255));
        lo.setBackgroundColor(new_color);
    }



    public void  guardarPreferencias(View view){
        //getSharedPreferences("identificado de la coleccion", "modo de acceso")
        // ya solo se usa el modo de acceso privado
        SharedPreferences prefs = getSharedPreferences(_MIS_PREFERENCIAS, Context.MODE_PRIVATE);
        // se crea un editor para poder actualizar/insertar un valor a la coleccion
        SharedPreferences.Editor editor= prefs.edit();
        editor.putInt(_BACKGROUND,new_color);
        editor.putBoolean(_MARCADOR,stch1.isChecked());// isChecked() regresa un booleano con el estado del switch
        editor.commit(); // se llama al commit para confirmar los cambios
    }

    private void loadPreferences(){
        SharedPreferences prefs = getSharedPreferences(_MIS_PREFERENCIAS,MODE_PRIVATE);
        //salvamos en una variable el valor previamente salvado en el identificador "_BACKGROUND"
        //en caso de no existir dicho valor, se pasa el valor por defecto '0'
        saved_color = prefs.getInt(_BACKGROUND,0);
        switch_state = prefs.getBoolean(_MARCADOR,false);//de igual manera secede con getBoolean()
        lo.setBackgroundColor(saved_color);
        stch1.setChecked(switch_state);
    }


}
