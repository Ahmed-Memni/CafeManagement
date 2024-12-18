package com.cafe.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
// Assurez-vous de spécifier le bon chemin pour Personne si elle est dans un autre package

public final class Customer extends Personne {
    private double moneySpent;
    private OrderItem mostItemBought;
    private int loyaltyPoints;
    private double rewardBalance;
    private Map<OrderItem,Integer> boughts;

    // Constructor with parameters
    public Customer(int id, String nom, String prenom, int telephone,
                    double moneySpent, OrderItem mostItemBought, int loyaltyPoints, double rewardBalance) {
        super(id, nom, prenom, telephone);
        this.moneySpent = moneySpent;
        this.mostItemBought = mostItemBought;
        this.loyaltyPoints = loyaltyPoints;
        this.rewardBalance = rewardBalance;
        this.boughts = new HashMap<OrderItem,Integer>();
    }
    public Customer(int id,String nom,int telephone,String prenom) {
        super(id, nom, prenom, telephone);
        this.moneySpent = 0.0;
        this.mostItemBought = null;
        this.loyaltyPoints = 0;
        this.rewardBalance = 0.0;
        this.boughts = null;
    }
    // No-argument constructor
    public Customer() {
        super(0, "Unknown", "Unknown", 0);
        this.moneySpent = 0.0;
        this.mostItemBought = null;
        this.loyaltyPoints = 0;
        this.rewardBalance = 0.0;
        this.boughts = null;
    }


    public OrderItem getMostItemBoughtCalculation() {
        if (boughts == null || boughts.isEmpty()) {
            return null; // No items bought
        }

        return boughts.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Function to calculate total money spent
    public double calculateMoneySpent() {
        if (boughts == null || boughts.isEmpty()) {
            return 0.0; // No money spent if nothing is bought
        }

        return boughts.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public OrderItem getMostItemBought() {
        return mostItemBought;
    }

    public void setMostItemBought(OrderItem mostItemBought) {
        this.mostItemBought = mostItemBought;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getRewardBalance() {
        return rewardBalance;
    }

    public void setRewardBalance(double rewardBalance) {
        this.rewardBalance = rewardBalance;
    }

    public void addPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void redeemPoints(int points) {
        if (points <= this.loyaltyPoints) {
            this.loyaltyPoints -= points;
            this.rewardBalance += points * 0.01; // Example: 1 point = $0.01
        } else {
            throw new IllegalArgumentException("Not enough loyalty points to redeem.");
        }
    }

    @Override
    public void modifierDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Customer Details:");
        System.out.println(this);

        System.out.println("\nWhat do you want to modify?");
        System.out.println("1. Nom");
        System.out.println("2. Prenom");
        System.out.println("3. Telephone");
        System.out.println("4. Money Spent");
        System.out.println("5. Most Item Bought");
        System.out.println("6. Loyalty Points");
        System.out.println("7. Reward Balance");
        System.out.println("8. Exit");

        int choice;
        do {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter new Nom: ");
                    this.setNom(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new Prenom: ");
                    this.setPrenom(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new Telephone: ");
                    this.setTelephone(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    break;
                case 4:
                    System.out.print("Enter new Money Spent: ");
                    this.setMoneySpent(scanner.nextDouble());
                    scanner.nextLine(); // Consume newline
                    break;
                case 5:
                    System.out.print("Enter new Loyalty Points: ");
                    this.setLoyaltyPoints(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    break;
                case 6:
                    System.out.print("Enter new Reward Balance: ");
                    this.setRewardBalance(scanner.nextDouble());
                    scanner.nextLine(); // Consume newline
                    break;
                case 7:
                    System.out.println("Exiting modification...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice >= 1 && choice <= 8) {
                System.out.println("\nUpdated Customer Details:");
                System.out.println(this);
            }
        } while (choice != 9);
    }


    @Override
    public String toString() {
        // Build the boughts string representation
        StringBuilder boughtsString = new StringBuilder("\nItems Bought:\n");
        for (Map.Entry<OrderItem, Integer> entry : boughts.entrySet()) {
            boughtsString.append(entry.getKey().toString()) // Uses OrderItem's toString
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }

        // Append boughtsString to the existing toString implementation
        return super.toString() +
                "\nMoney Spent: " + moneySpent +
                "\nMost Item Bought: " + (mostItemBought != null ? mostItemBought.toString() : "None") +
                "\nLoyalty Points: " + loyaltyPoints +
                "\nReward Balance: " + rewardBalance +
                boughtsString.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est la même instance
        if (o == null || getClass() != o.getClass()) return false; // Vérifie le type exact de l'objet

        // Appelle equals de la classe parente Personne
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        return Double.compare(customer.moneySpent, moneySpent) == 0 &&
                loyaltyPoints == customer.loyaltyPoints &&
                Double.compare(customer.rewardBalance, rewardBalance) == 0 &&
                Objects.equals(mostItemBought, customer.mostItemBought) &&
                Objects.equals(boughts, customer.boughts);
    }


}
