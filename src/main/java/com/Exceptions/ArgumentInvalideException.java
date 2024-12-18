
package com.Exceptions;


public class ArgumentInvalideException extends Exception {
    
    // Constructeur sans paramètre
    public ArgumentInvalideException() {
        super("Argument invalide.");
    }
    
    // Constructeur avec un message personnalisé
    public ArgumentInvalideException(String message) {
        super(message);
    }
    
    // Constructeur avec un message et la cause
    public ArgumentInvalideException(String message, Throwable cause) {
        super(message, cause);
    }
    
    // Constructeur avec la cause de l'exception
    public ArgumentInvalideException(Throwable cause) {
        super(cause);
    }
}
