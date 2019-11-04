package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeExempleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_exemple);

        ListView lstLogement = findViewById(R.id.listLogement);


        String[] logements = new String[]{"Paris", "Bordeeaux", "Lille", "Montpellier", "Marseille", "Lyon"};

        ArrayList<String> arrayLogements = new ArrayList<>();

        for (int i = 0; i < logements.length; i++)
        {
            arrayLogements.add(logements[i]);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayLogements);
        lstLogement.setAdapter(adapter);

    }
}
