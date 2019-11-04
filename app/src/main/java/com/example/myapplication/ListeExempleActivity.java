package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListeExempleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_exemple);

        ListView lstLogement = findViewById(R.id.listLogement);


        final String[] logements = new String[]{"Paris", "Bordeaux", "Lille", "Montpellier", "Marseille", "Lyon"};

        ArrayList<String> arrayLogements = new ArrayList<>();

        for (int i = 0; i < logements.length; i++)
        {
            arrayLogements.add(logements[i]);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayLogements);
        lstLogement.setAdapter(adapter);

        lstLogement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String logement = logements[i];

                Toast.makeText(ListeExempleActivity.this, logement, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
