package com.example.erick.quizgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        levelMenu();

    }

    private void levelMenu(){
        String l1 = getString(R.string.facil);
        String l2 = getString(R.string.dificil);
        String[] lt = {l1,l2};
        ExpandableListView e1 = findViewById(R.id.level);

        ArrayAdapter adatador = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1,lt);
        e1.setAdapter(adatador);
    }
}
