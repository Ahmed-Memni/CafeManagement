package com.cafe.models;

import com.Interfaces.GestionExperience;

import java.util.Objects;
import java.util.Scanner;
/**
 * Classe abstraite Personne avec un constructeur interactif
 * et une méthode pour modifier ses détails.
 */
public abstract class Personne {
    //---------------------attributs--------------------
    private Integer id;
    private String nom;
    private String prenom;
    private Integer telephone;

    //--------------------constructeurs--------------------
    public Personne(Integer id, String nom, String prenom, Integer telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;

    }



    //--------------------getters & setters--------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }



    public Integer getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public Integer getTelephone() {
        return this.telephone;
    }


    //--------------------methodes--------------------

    // Méthode abstraite pour modifier une personne
    public abstract void modifierDetails();

    // Méthode pour afficher une personne
    public void afficher() {
        System.out.println("ID : " + this.getId());
        System.out.println("Nom : " + this.getNom());
        System.out.println("Prénom : " + this.getPrenom());
        System.out.println("Téléphone : " + this.getTelephone());
    }

    @Override
    public String toString() {
        return "Id : " + this.id + "\n" + "Nom : " + this.nom + "\n" + "Prenom : " + this.prenom + "\n"
                + "Téléphone : " + this.telephone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est le même objet
        if (o == null || getClass() != o.getClass()) return false; // Vérifie la classe

        Personne personne = (Personne) o; // Cast de l'objet en Personne

        return Objects.equals(id, personne.id) &&
                Objects.equals(nom, personne.nom) &&
                Objects.equals(prenom, personne.prenom) &&
                Objects.equals(telephone, personne.telephone); // Compare tous les attributs
    }




}
