package com.kevin.evalspring.controller;

import com.kevin.evalspring.model.Categorie;
import com.kevin.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController("/api")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Categorie> getAllCategories() {
        return categorieService.findAll();
    }

    @GetMapping("/categorie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categorie getCategorie(@PathVariable int id) {
        return categorieService.findById(id);
    }

    @PostMapping("/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie addCategorie(@RequestBody @Valid Categorie categorie) {
        return categorieService.save(categorie);
    }
}
