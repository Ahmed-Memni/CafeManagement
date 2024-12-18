package com.Exceptions;

public class QuantiteNegatifException extends Exception {

    // Constructeur avec message
    public QuantiteNegatifException(String message) {
        super(message);
    }

    // Constructeur avec message et cause
    public QuantiteNegatifException(String message, Throwable cause) {
        super(message, cause);
    }
}
