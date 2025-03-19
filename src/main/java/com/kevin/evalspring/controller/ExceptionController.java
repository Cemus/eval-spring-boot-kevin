package com.kevin.evalspring.controller;

import com.kevin.evalspring.exception.CategorieAlreadyExistsException;
import com.kevin.evalspring.exception.NoCategorieFoundException;
import com.kevin.evalspring.exception.NoProduitFoundException;
import com.kevin.evalspring.exception.ProduitAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CategorieAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> categorieAlreadyExists(CategorieAlreadyExistsException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(NoCategorieFoundException.class)
    public ResponseEntity<Map<String,String>> noCategorie(NoCategorieFoundException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(NoProduitFoundException.class)
    public ResponseEntity<Map<String,String>> noProduit(NoProduitFoundException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ProduitAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> produitAlreadyExists(ProduitAlreadyExistsException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
