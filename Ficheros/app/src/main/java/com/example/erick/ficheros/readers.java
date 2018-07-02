package com.example.erick.ficheros;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class readers extends AppCompatActivity {
    String[] archivero;
    EditText e1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readers);

        archivero = fileList(); // get a list of all the files
        btn1 = findViewById(R.id.btn1);
        e1 = findViewById(R.id.ed1);

        if (ArchivoExiste(archivero, "texto.txt")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("texto.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine(); //Read a line from the file in the buffer
                String fichero = "";

                while (linea!=null){
                    fichero += linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                e1.setText(fichero);

            }catch(IOException e){

            }

        }

    }


    public void Guardar(View view) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("texto.txt", Activity.MODE_PRIVATE));
            archivo.write(e1.getText().toString());
            archivo.flush();
            archivo.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this,"Can't save the file",Toast.LENGTH_LONG).show();
        }

        Toast.makeText(this,"Saved Successful",Toast.LENGTH_LONG).show();
    }

    /*ArchivoExiste
    * @param archivos lista de archivos existentes
    * @param archivo documento a buscar en la lista
    * */
    private boolean ArchivoExiste(String[] archivos, String archivo) {
        for(String a :archivos)
            if (archivo.equals(archivo))
                return true;
        return false;
    }

}
