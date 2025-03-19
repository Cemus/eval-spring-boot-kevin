package com.kevin.evalspring.service;

import com.kevin.evalspring.exception.CategorieAlreadyExistsException;
import com.kevin.evalspring.exception.NoCategorieFoundException;
import com.kevin.evalspring.model.Categorie;
import com.kevin.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public Iterable<Categorie> findAll() {
        if (categorieRepository.count() == 0) {
            throw new NoCategorieFoundException();
        }
        return categorieRepository.findAll();
    }

    public Categorie findById(long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        if (categorie.isEmpty()) {
            throw new NoCategorieFoundException();
        }
        return categorie.get();
    }

    public Categorie save(Categorie categorie) {
        if (categorieRepository.findByLibele(categorie.getLibele()) != null){
            throw new CategorieAlreadyExistsException(categorie.getLibele());
        }
        return categorieRepository.save(categorie);
    }
}
