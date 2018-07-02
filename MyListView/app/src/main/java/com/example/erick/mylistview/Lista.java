package com.example.erick.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista extends AppCompatActivity {
    String[] lalista= {"elemento uno",
            "elemento dos",
            "elemento tres",
            "elemento cuatro",
            "elemento cinco ",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista();
    }

    public void lista(){
        ListView l = findViewById(R.id.list1);
        ArrayAdapter adatador = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1,lalista);
        l.setAdapter(adatador);
    }
}
