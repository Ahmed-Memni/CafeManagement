package com.cafe.models;

/**
 * Classe représentant un élément de stock avec un lien vers son fournisseur.
 */
public class Stock {

    // ===================== Attributs =====================
    private Integer id; // Identifiant unique pour l'élément de stock
    private String nom; // Nom de l'article en stock
    private Supplier typeSupplier; // Le fournisseur associé à cet élément de stock
    private Integer quantity;
    // ===================== Constructeur =====================
    /**
     * Initialise un objet Stock avec ses attributs.
     * @param id Identifiant unique de l'article de stock
     * @param nom Nom de l'article
     * @param typeSupplier Le fournisseur associé à l'article
     */
    public Stock(Integer id, String nom, Supplier typeSupplier,Integer quantity) {
        this.id = id;
        this.nom = nom;
        this.typeSupplier = typeSupplier;
        this.quantity = quantity;
    }

    public Stock(Integer id, String nom, String prenom, Integer telephone, String companyName, Integer quantity) {
        this.id = id;
        this.nom = nom;
        this.typeSupplier = new Supplier(id, nom, prenom, telephone, companyName); // Correct instantiation
        this.quantity = quantity;
    }


    // ===================== Getters =====================
    /**
     * Retourne l'identifiant de l'article de stock.
     * @return L'identifiant de l'article
     */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id=id;}
    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Retourne le nom de l'article en stock.
     * @return Le nom de l'article
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le fournisseur associé à cet élément de stock.
     * @return Le fournisseur associé
     */
    public Supplier getTypeSupplier() {
        return typeSupplier;
    }

    // ===================== Setters =====================
    /**
     * Définit un nouveau nom pour l'article de stock.
     * @param nom Le nouveau nom de l'article
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit un nouveau fournisseur pour l'article de stock.
     * @param typeSupplier Le nouveau fournisseur
     */
    public void setTypeSupplier(Supplier typeSupplier) {
        this.typeSupplier = typeSupplier;
    }


    // ===================== Méthodes =====================
    @Override
    public String toString() {
        return "Stock ID: " + id + ", Nom: " + nom + ", Supplier: " + typeSupplier;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Stock stock = (Stock) obj;
        return id.equals(stock.id);
    }
}
