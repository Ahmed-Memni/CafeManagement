package com.Exceptions;


public class SpecialitéNonTrouveException extends Exception {
    public SpecialitéNonTrouveException(String message) {
        super(message); // Passer le message d'exception au constructeur parent
    }
}
