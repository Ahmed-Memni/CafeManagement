package com.cafe.models;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.Exceptions.*;
import com.Interfaces.GestionExperience;

public class Inventory {

    // ===================== Attributs =====================
    private Map<Stock, Integer> stockMap; // Map représentant les stocks et leurs quantités

    // ===================== Constructeur =====================
    public Inventory() {
        this.stockMap = new HashMap<>(); // Initialisation de la map
    }

    // ===================== Getters =====================
    public Map<Stock, Integer> getStockMap() {
        return stockMap;
    }
    public Set<Stock> keySet() {
        return stockMap.keySet();
    }

    // ===================== Afficher la liste d'éléments avec index =====================
    public void afficherStock() {
        if (stockMap.isEmpty()) {
            System.out.println("L'inventaire est vide.");
            return;
        }

        System.out.println("\nLes articles en stock sont :");
        int index = 0;
        for (Map.Entry<Stock, Integer> entry : stockMap.entrySet()) {
            System.out.println(index + ": Article : " + entry.getKey() + ", Quantité : " + entry.getValue());
            index++;
        }
    }

    public void modifierDetails() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Menu de Gestion de l'Inventaire ======");
            System.out.println("1. Modifier la quantité d'un article existant par index");
            System.out.println("2. Supprimer un article existant par index");
            System.out.println("3. Afficher l'inventaire");
            System.out.println("4. Quitter");

            System.out.print("\nEntrez votre choix: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1: // Modifier la quantité
                    afficherStock();
                    System.out.print("\nEntrez l'index de l'article à modifier : ");
                    int indexToModify = scanner.nextInt();
                    scanner.nextLine();
                    if (isValidIndex(indexToModify)) {
                        System.out.print("Entrez la nouvelle quantité : ");
                        int nouvelleQuantite = scanner.nextInt();
                        scanner.nextLine();
                        modifierQuantite(indexToModify, nouvelleQuantite);
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;

                case 2: // Supprimer un article
                    afficherStock();
                    System.out.print("\nEntrez l'index de l'article à supprimer : ");
                    int indexToDelete = scanner.nextInt();
                    scanner.nextLine();
                    if (isValidIndex(indexToDelete)) {
                        supprimerArticle(indexToDelete);
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;

                case 3: // Afficher l'inventaire
                    afficherStock();
                    break;

                case 4: // Quitter
                    System.out.println("Fermeture du menu...");
                    break;

                default:
                    System.out.println("Option invalide, veuillez essayer de nouveau.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < stockMap.size();
    }

    public void modifierQuantite(int index, int nouvelleQuantite) {
        Stock stockItem = getStockByIndex(index);
        if (stockItem != null) {
            stockMap.put(stockItem, nouvelleQuantite);
            System.out.println("Quantité mise à jour : " + nouvelleQuantite + " pour l'article " + stockItem);
        } else {
            System.out.println("Échec de la modification, l'élément est introuvable.");
        }
    }

    public void supprimerArticle(int index) {
        Stock stockItem = getStockByIndex(index);
        if (stockItem != null) {
            stockMap.remove(stockItem);
            System.out.println("Article supprimé : " + stockItem);
        } else {
            System.out.println("Échec de la suppression, l'élément est introuvable.");
        }
    }

    private Stock getStockByIndex(int index) {
        int i = 0;
        for (Map.Entry<Stock, Integer> entry : stockMap.entrySet()) {
            if (i == index) {
                return entry.getKey();
            }
            i++;
        }
        return null; // Fallback if invalid index
    }
}
