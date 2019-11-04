package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Entities.Personne;
import com.google.gson.Gson;

public class CompteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte);


        Intent intent = getIntent();

        if(intent.hasExtra("PersonneKey"))
        {
            String personneKey = intent.getStringExtra("personneKey");

            Gson gson = new Gson();

            Personne personne = gson.fromJson(personneKey, Personne.class);
        }

    }
}
