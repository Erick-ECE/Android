package com.example.erick.externalmemmory;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class media extends AppCompatActivity {
    private  EditText e1,e2;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guardar(v);
            }
        });


    }

    public void Guardar(View view){
        String nombre= e1.getText().toString();
        String contenido = e2.getText().toString();

        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this,tarjetaSD.getPath(),Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetaSD.getPath(),nombre);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();
            Toast.makeText(this,"Guardado Correctamente",Toast.LENGTH_SHORT).show();
            e1.setText("");
            e2.setText("");
        }catch (IOException e){
            Toast.makeText(this,"Error al guardar el archivo",Toast.LENGTH_SHORT).show();
        };
    }

    //Método consultar
    public void Consultar(View view){
        String nombre = e1.getText().toString();


        try{
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String contenidoCompleto = "";

            while (linea != null){
                contenidoCompleto = contenidoCompleto + linea + "\n";
                linea = leerArchivo.readLine();
            }

            leerArchivo.close();
            abrirArchivo.close();
            e2.setText(contenidoCompleto);
        }catch (IOException e){
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}
