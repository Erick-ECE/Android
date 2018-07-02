package com.example.erick.layouts;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Table extends AppCompatActivity implements View.OnClickListener {
    Button siguiente;
    ImageButton ib;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        siguiente = findViewById(R.id.sig);

        //btn next
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(Table.this, Layouts.class);
                startActivity(n);
            }
        });
        Button t3 = findViewById(R.id.t3);
        Button t4 = findViewById(R.id.t4);
        Button t5 = findViewById(R.id.t5);
        ib = findViewById(R.id.ib);


        boton1();
        boton2();

        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        ib.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode== 1 & resultCode== RESULT_OK ){
            Bitmap imagen = data.getParcelableExtra("data");
            ib.setImageBitmap(imagen);
        }

    }

    private void boton1() {
        Button t1 = findViewById(R.id.t1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendintent = new Intent();
                sendintent.setAction(Intent.ACTION_SEND);
                sendintent.putExtra(Intent.EXTRA_TEXT,
                        "Este texto se envio desde un intent");
                sendintent.setType("text/plain");
                startActivity(sendintent);
            }
        });
    }

    private void boton2() {
        Button t2 = findViewById(R.id.t2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri web = Uri.parse("http://proteco.mx/cursos");
                Intent openweb = new Intent(Intent.ACTION_VIEW, web);
                if (openweb.resolveActivity(getPackageManager()) != null) {
                    startActivity(openweb);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t3:
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:5559400775"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(i);
                break;
            case R.id.t4:
                Intent marca = new Intent(Intent.ACTION_DIAL);
                marca.setData(Uri.parse("tel:5560662035"));
                startActivity(marca);
                break;
            case R.id.t5:
                Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (camara.resolveActivity(getPackageManager())!= null){
                    startActivityForResult(camara,1);
                }
                break;
            case R.id.ib:
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setMessage("¡¡Image button clickeado!!");
                alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alerta.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alerta.show();
                break;

            case R.id.t7: break;
            case R.id.t8: break;
            case R.id.t9: break;
        }
    }
}
