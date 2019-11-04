package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Entities.Personne;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnValider = findViewById(R.id.btnValider);


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText textNom = findViewById(R.id.txtNom);
                EditText textPrenom = findViewById(R.id.txtPrenom);
                EditText textEmail = findViewById(R.id.txtEmail);
                EditText textPassword = findViewById(R.id.txtPassword);

                String nom = textNom.getText().toString();
                String prenom = textPrenom.getText().toString();
                String email = textEmail.getText().toString();

                String password = textPassword.getText().toString();

                //Toast.makeText(MainActivity.this, MainActivity.checkPassword(textPassword) ? "TRUE" : "FALSE", Toast.LENGTH_LONG).show();


                if(!nom.isEmpty() && nom.length() > 7){

                    String message = "Bonjour Mr." + nom + ", votre âge est : " + prenom;

                    TextView textMessage = findViewById(R.id.textView);
                    textMessage.setText(message);

                    Personne personne = new Personne(nom, prenom, email, password);

                    //
                    Gson gson = new Gson();
                    String personneJson = gson.toJson(personne);

                    Intent intent = new Intent(MainActivity.this, ListeExempleActivity.class);
                    intent.putExtra("personneKey", personneJson);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre nom avec au moins 8 caractères.", Toast.LENGTH_LONG).show();
                }



            }
        });
    }

    public static boolean checkPassword(EditText texte){
        if(!texte.getText().toString().isEmpty())
            return Character.isUpperCase(texte.getText().charAt(0));
        else
            return false;


    }

}
