package com.Exceptions;


public class EmployeExistantException extends Exception {

    // Constructeur qui accepte un message d'erreur
    public EmployeExistantException(String message) {
        super(message);  // Appel du constructeur parent de Exception
    }
}