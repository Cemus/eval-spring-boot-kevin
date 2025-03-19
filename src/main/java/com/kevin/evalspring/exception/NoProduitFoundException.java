package com.kevin.evalspring.exception;

public class NoProduitFoundException extends RuntimeException {
    public NoProduitFoundException() {
        super("Produit(s) absent(s) dans la base de données");
    }
}
