package com.cafe.models;

import java.time.LocalDate;
import java.util.Scanner;

public final class Feedback {
    private String feedbackId;
    private Customer customer;
    private int rating; // Out of 5
    private LocalDate feedbackDate;

    // Constructor with parameters
    public Feedback(String feedbackId, Customer customer, int rating, String comments, LocalDate feedbackDate) {
        this.feedbackId = feedbackId;
        this.customer = customer;
        this.rating = rating;
        this.feedbackDate = feedbackDate;
    }

    // No-argument constructor
    public Feedback() {
        this.feedbackId = "Unknown";
        this.customer = new Customer(); // Use default no-entry constructor
        this.rating = 0;
        this.feedbackDate = LocalDate.now();
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void modifierDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Feedback Details:");
        System.out.println(this);

        System.out.println("\nWhat do you want to modify?");
        System.out.println("1. Rating");
        System.out.println("2. Use Default Customer Info");
        System.out.println("3. Exit");

        int choice;
        do {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter new Rating (out of 5): ");
                    int newRating = scanner.nextInt();
                    if (newRating >= 0 && newRating <= 5) {
                        this.rating = newRating;
                        System.out.println("Rating updated successfully.");
                    } else {
                        System.out.println("Invalid rating. Please enter a value between 0 and 5.");
                    }
                    break;

                case 2:
                    // Use the no-entry Customer constructor
                    this.customer = new Customer();
                    System.out.println("Customer information set to default.");
                    break;

                case 3:
                    System.out.println("Exiting modification...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice >= 1 && choice <= 2) {
                System.out.println("\nUpdated Feedback Details:");
                System.out.println(this);
            }

        } while (choice != 3);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", customer=" + customer +
                ", rating=" + rating +
                ", feedbackDate=" + feedbackDate +
                '}';
    }
}
