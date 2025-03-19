package com.kevin.evalspring.controller;

import com.kevin.evalspring.model.Produit;
import com.kevin.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Produit> getAllProduits() {
        return produitService.findAll();
    }

    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produit getProduitById(@PathVariable int id) {
        return produitService.findById(id);
    }

    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit addProduit(@RequestBody @Valid Produit produit) {
        return produitService.save(produit);
    }
}
