package com.cafe.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import com.Interfaces.GestionExperience;
import com.Exceptions.SpecialitéNonTrouveException;
import com.Exceptions.VideException;
import com.Exceptions.ArgumentInvalideException;

public class Chef extends Employe implements GestionExperience {

    // ===================== Attributs =====================
    private List<OrderItem> specialities; // L'équipe du chef (ensemble de spécialités)

    // ===================== Constructeur par défaut =====================


    public Chef(int id, String nom, String prenom, int telephone, String adresse, double salaire, String dateEmbaucheStr,OrderItem specialities) {
        super(id, nom, prenom, telephone, adresse, salaire, dateEmbaucheStr);
        ArrayList<OrderItem> intList = new ArrayList<>();
        intList.add(specialities);
        this.specialities = intList;
    }

    // ===================== Constructeur avec paramètres =====================
    public Chef(int id, String nom, String prenom, int telephone, String adresse, double salaire, String dateEmbaucheStr) {
        super(id, nom, prenom, telephone, adresse, salaire, dateEmbaucheStr); // Appel au constructeur parent
        this.specialities = new ArrayList<>();
    }

    // ===================== Getters =====================
    public List<OrderItem> getSpecialities() {
        return specialities;
    }

    // ===================== Setters =====================
    public void setSpecialities(List<OrderItem> specialities) {
        this.specialities = specialities;
    }

    // ===================== Méthodes de gestion d'équipe =====================

    // Ajoute une spécialité à l'équipe.
    public void ajouterSpecialite(OrderItem s) throws  ArgumentInvalideException {
        if (s == null) {
            throw new ArgumentInvalideException("Veuillez spécifier la spécialité.");
        }
        specialities.add(s);
        System.out.println("La spécialité " + s + " a été ajoutée.");
    }
    public OrderItem retirerSpecialite() { return specialities.get(0);}

    // Supprime une spécialité de l'équipe.
    public void supprimerSpecialite(String nom) throws SpecialitéNonTrouveException {
        boolean found = false;

        for (Iterator<OrderItem> iterator = specialities.iterator(); iterator.hasNext();) {
            OrderItem item = iterator.next();
            if (item.getName().equals(nom)) {
                iterator.remove(); // Safely remove the item during iteration
                found = true;
                System.out.println("La spécialité '" + nom + "' a été supprimée.");
                break; // Exit the loop once the item is found and removed
            }
        }

        if (!found) {
            throw new SpecialitéNonTrouveException("La spécialité '" + nom + "' n'existe pas.");
        }
    }


    public void afficherSpecialites() throws VideException {
        if (specialities.isEmpty()) {
            throw new VideException("Les spécialités sont vides.");
        } else {
            System.out.println("Les spécialités de " + getNom() + ":");
            for (OrderItem s : specialities) {
                System.out.println(s);
            }
        }
    }

    public void modifyDetails() throws SpecialitéNonTrouveException, ArgumentInvalideException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Détails du chef actuel : ");
        System.out.println(this);

        System.out.println("\nQue souhaitez-vous modifier ?");
        System.out.println("1. Nom");
        System.out.println("2. Prénom");
        System.out.println("3. Téléphone");
        System.out.println("4. Adresse");
        System.out.println("5. Ajouter une spécialité");
        System.out.println("6. Supprimer une spécialité");
        System.out.println("7. Quitter");

        int choice;
        do {
            System.out.print("\nEntrez votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Entrez le nouveau nom : ");
                    setNom(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Entrez le nouveau prénom : ");
                    setPrenom(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Entrez le nouveau téléphone : ");
                    setTelephone(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Entrez la nouvelle adresse : ");
                    setAdresse(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Entrez la nouvelle spécialité : ");
                    ajouterSpecialite(new OrderItem());
                    break;
                case 6:
                    System.out.print("Entrez la spécialité à supprimer : ");
                    supprimerSpecialite(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Fermeture du menu...");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpécialités : " + specialities;
    }

    @Override
    public void afficherNiveau(int experience) {
        if (experience < 2) {
            System.out.println("Chef : Niveau Junior - " + experience + " années de travail.");
        } else if (experience < 5) {
            System.out.println("Chef : Niveau Confirmé - " + experience + " années de travail.");
        } else {
            System.out.println("Chef : Niveau Senior - " + experience + " années de travail.");
        }
    }

    @Override
    public int calculerExperience(LocalDate dateEmbauche) {
        LocalDate aujourdHui = LocalDate.now();
        return Period.between(dateEmbauche, aujourdHui).getYears();
    }
}
