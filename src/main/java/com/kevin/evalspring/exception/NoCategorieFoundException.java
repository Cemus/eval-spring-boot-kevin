package com.kevin.evalspring.exception;

public class NoCategorieFoundException extends RuntimeException {
    public NoCategorieFoundException() {
        super("Catégorie(s) absente(s) dans la base de données");;
    }
}
