package com.example.myapplication.Entities;

public class Personne {

    private String Nom;
    private String Prenom;
    private String Email;
    private String Password;

    public Personne(String nom, String prenom, String email, String password) {
        Nom = nom;
        Prenom = prenom;
        Email = email;
        Password = password;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
