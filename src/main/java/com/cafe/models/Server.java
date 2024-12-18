package com.cafe.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un serveur dans un café, héritant de la classe Employe.
 */
public class Server extends Employe {

    // ===================== Attributs =====================
    private List<Integer> tableNumbers; // La liste des noms de tables gérées par le serveur.

    // ===================== Constructeur =====================

    /**
     * Initialise un serveur avec ses informations personnelles et sa liste de tables.
     *
     * @param id              Identifiant unique de l'employé
     * @param nom             Nom du serveur
     * @param prenom          Prénom du serveur
     * @param telephone       Numéro de téléphone du serveur
     * @param adresse         Adresse du serveur
     * @param salaire         Salaire du serveur
     * @param dateEmbaucheStr Date d'embauche du serveur
     */
    public Server(int id, String nom, String prenom, int telephone, String adresse, double salaire, String dateEmbaucheStr) {
        super(id, nom, prenom, telephone, adresse, salaire, dateEmbaucheStr);
        this.tableNumbers = new ArrayList<>(); // Initialise la liste de tables gérées
    }

    public Server(int id, String nom, String prenom, int telephone, String adresse, double salaire, String dateEmbaucheStr, Integer tableNumbers) {
        super(id, nom, prenom, telephone, adresse, salaire, dateEmbaucheStr);
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(tableNumbers);
        this.tableNumbers = intList;
    }

    // ===================== Getters =====================

    /**
     * Retourne la liste des tables gérées par le serveur.
     *
     * @return La liste des noms de tables.
     */
    public List<Integer> getTableNames() {
        return tableNumbers;
    }
    public Integer getTable() {
        return this.tableNumbers.get(0);
    }
    // ===================== Setters =====================

    /**
     * Définit les tables gérées par le serveur.
     *
     * @param tableNames Liste des noms des tables.
     */
    public void setTableNames(List<Integer> tableNames) {
        this.tableNumbers = tableNames;
    }

    // ===================== Méthodes de gestion =====================

    /**
     * Ajoute une table à la liste des tables gérées par le serveur.
     *
     * @param tableName Le nom de la table à ajouter.
     */
    public void addTable(String tableName) {
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nom de la table invalide.");
        }
        tableNumbers.add(Integer.valueOf(tableName));
        System.out.println("La table " + tableName + " a été ajoutée.");
    }

    /**
     * Retire une table de la liste des tables gérées par le serveur.
     *
     * @param tableName Le nom de la table à retirer.
     */
    public void removeTable(String tableName) throws Exception {
        if (tableNumbers.contains(tableName)) {
            tableNumbers.remove(tableName);
            System.out.println("La table " + tableName + " a été supprimée.");
        } else {
            throw new Exception("La table " + tableName + " n'existe pas.");
        }
    }

    /**
     * Affiche la liste des tables actuellement gérées par le serveur.
     */
    public void displayTables() {
        if (tableNumbers.isEmpty()) {
            System.out.println("Aucune table gérée par le serveur.");
        } else {
            System.out.println("Les tables actuellement gérées par " + this.getNom() + ":");
            for (Integer table : tableNumbers) {
                System.out.println(table);
            }
        }
    }
}
