package com.cafe.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Scanner;
import com.cafe.models.Personne; // Assurez-vous de spécifier le bon chemin pour Personne si elle est dans un autre package

public final class Supplier extends Personne {
    private String companyName;

    public Supplier(Integer id, String nom, String prenom, Integer telephone, String companyName) {
        super(id, nom, prenom, telephone);
        this.companyName = companyName;
    }


    // ===================== Getter & Setter =====================
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void modifierDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Supplier Details:");
        System.out.println(this);

        System.out.println("\nWhat do you want to modify?");
        System.out.println("1. Nom");
        System.out.println("2. Prenom");
        System.out.println("3. Telephone");
        System.out.println("4. Company Name");
        System.out.println("5. Exit");

        int choice;
        do {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter new Nom: ");
                    setNom(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new Prenom: ");
                    setPrenom(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new Telephone: ");
                    setTelephone(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Enter new Company Name: ");
                    setCompanyName(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Exiting modification...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice >= 1 && choice <= 5) {
                System.out.println("\nUpdated Supplier Details:");
                System.out.println(this);
            }
        } while (choice != 6);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCompany Name: " + companyName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est le même objet


        Supplier supplier = (Supplier) o;

        return super.equals(supplier) &&
                Objects.equals(companyName, supplier.companyName); // Compare tous les champs
    }
}
