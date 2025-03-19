package com.kevin.evalspring.exception;

public class CategorieAlreadyExistsException extends RuntimeException {
    public CategorieAlreadyExistsException(String libele) {
        super("La catégorie au libellé '" + libele + "' existe déjà dans la base de donnée");

    }
}
