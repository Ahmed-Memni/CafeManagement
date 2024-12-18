package com.cafe.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Employe extends Personne {

    //--------------------Attributs--------------------
    private String date_embauche; // Consider putting final
    private double salaire;
    private String adresse;

    //--------------------Constructeur avec paramètres--------------------
    public Employe(int id, String nom, String prenom, int telephone, String adresse, double salaire, String dateEmbaucheStr) {
        super(id, nom, prenom, telephone);
        this.salaire = salaire;
        this.date_embauche = dateEmbaucheStr;
        this.adresse = adresse;

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //--------------------Constructeur sans paramètres--------------------
/*
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Entrez l'ID : ");
            int id = sc.nextInt();
            sc.nextLine(); // Consommer le retour de ligne
            super.set_id(id);

            System.out.print("Entrez le nom : ");
            String nom = sc.nextLine();
            super.set_nom(nom);

            System.out.print("Entrez le prénom : ");
            String prenom = sc.nextLine();
            super.set_prenom(prenom);

            System.out.print("Entrez le numéro de téléphone : ");
            int telephone = sc.nextInt();
            sc.nextLine(); // Consommer le retour de ligne
            super.set_telephone(telephone);

            System.out.print("Entrez l'adresse : ");
            String adresse = sc.nextLine();
            this.set_adresse(adresse);

            System.out.print("Entrez le salaire : ");
            this.salaire = sc.nextDouble();
            sc.nextLine(); // Consommer le retour de ligne

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            boolean dateValide = false;
            while (!dateValide) {
                System.out.print("Entrez la date d'embauche (format dd/MM/yyyy) : ");
                String dateInput = sc.nextLine();
                try {
                    this.date_embauche = LocalDate.parse(dateInput, formatter);
                    dateValide = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
                }
            }

            System.out.println("Employé créé avec succès avec les valeurs saisies.");
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de la saisie des données : " + e.getMessage());
        } finally {
            sc.close();
        }
    }
*/
    //---------------------Methodes--------------------

    //--------------------geters & seters---------------------

    public String getAddress() {
        return date_embauche;
    }

    public String getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public String get_adresse() {
        return this.adresse;
    }


    // Méthode pour afficher un employé
    public void afficher() {
        super.afficher();
        System.out.println("Salaire : " + this.getSalaire());
        System.out.println("Date d embauche : " + this.getDate_embauche());
    }

    public void set_date_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }

    //--------------------Méthodes override--------------------
    @Override
    public void modifierDetails() {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            // Boucle pour forcer un choix valide (entre 0 et 6)
            do {
                System.out.println("Que voulez-vous modifier ?");
                System.out.println("1 : nom");
                System.out.println("2 : prenom");
                System.out.println("3 : adresse");
                System.out.println("4 : telephone");
                System.out.println("5 : salaire");
                System.out.println("6 : date d'embauche");
                System.out.println("0 : quitter");

                while (!sc.hasNextInt()) {
                    System.out.println("Saisie invalide, veuillez entrer un nombre entre 0 et 6.");
                    sc.next();
                }
                choice = sc.nextInt();
                sc.nextLine();

            } while (choice < 0 || choice > 6);

            switch (choice) {
                case 1:
                    System.out.print("Saisir le nouveau nom : ");
                    super.setNom(sc.nextLine());
                    System.out.println("Nom mis à jour.");
                    break;

                case 2:
                    System.out.print("Saisir le nouveau prénom : ");
                    super.setPrenom(sc.nextLine());
                    System.out.println("Prénom mis à jour.");
                    break;

                case 3:
                    System.out.print("Saisir la nouvelle adresse : ");
                    this.setAdresse(sc.nextLine());
                    System.out.println("Adresse mise à jour.");
                    break;

                case 4:
                    System.out.print("Saisir le nouveau téléphone : ");
                    super.setTelephone(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Téléphone mis à jour.");
                    break;

                case 5:
                    System.out.print("Saisir le nouveau salaire : ");
                    setSalaire(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Salaire mis à jour.");
                    break;

                case 6:
                    System.out.print("Veuillez entrer la nouvelle date d'embauche (format dd/MM/yyyy) : ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    boolean dateValide = false;
                    while (!dateValide) {
                        try {
                            String dateInput = sc.nextLine();
                            LocalDate new_date = LocalDate.parse(dateInput, formatter);
                           // this.set_date_embauche(new_date);
                            dateValide = true;
                            System.out.println("Date d'embauche mise à jour : " + new_date);
                        } catch (DateTimeParseException e) {
                            System.out.println("Format de date invalide. Veuillez réessayer.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Quitter le menu.");
                    break;
            }

        } while (choice != 0);

        sc.close();
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalaire de l'employé : " + this.salaire + "\nDate d'embauche : " + this.date_embauche + "\nadresse :" + this.adresse;
    }

    public int calcul_anciennette() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(date_embauche, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return today.getYear() - date.getYear();
    }
}
