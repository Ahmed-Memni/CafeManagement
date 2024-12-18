package com.cafe.models;

import java.util.Objects;
import java.util.Scanner;

public class Administrator {
    private final String username;
    private final String password;
    private final String cin;
    private final int questionNumber;
    private final String answer;

    public Administrator(String username, String password) {this.username = username; this.password = password; this.cin = null;
    this.questionNumber = 0;this.answer = null;}
    // ===================== Constructors =====================
    public Administrator(String username, String password, String cin, int questionNumber, String answer) {
        this.username = username;
        this.password = password;
        this.cin = cin;
        this.questionNumber = questionNumber;
        this.answer = answer;
    }

    // ===================== Getters & Setters =====================
    public String getUsername() {
        return username;
    }


    public int getQuestionNumber() {
        return questionNumber;
    }


    // ===================== Methods =====================
    public void afficher(){
                System.out.println("\nUpdated Administrator Details:");
                System.out.println(this);
            }


    @Override
    public String toString() {
        return "Username: " + username +
                "\nPassword: " + password +
                "\nCIN: " + cin +
                "\nQuestion Number: " + questionNumber +
                "\nAnswer: " + answer;
    }
    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // If the same object, return true
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // If the object is null or not the same class, return false
        }
        Administrator other = (Administrator) obj;
        // Compare only username and password
        return this.username.equals(other.username) && this.password.equals(other.password);
    }

}
