package com.kevin.evalspring.exception;

public class ProduitAlreadyExistsException extends RuntimeException {
    public ProduitAlreadyExistsException(String nom) {
        super("Le produit '" + nom + "' existe déjà dans la base de donnée");
    }
}
