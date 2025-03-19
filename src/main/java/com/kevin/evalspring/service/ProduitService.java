package com.kevin.evalspring.service;

import com.kevin.evalspring.exception.NoProduitFoundException;
import com.kevin.evalspring.exception.ProduitAlreadyExistsException;
import com.kevin.evalspring.model.Produit;
import com.kevin.evalspring.repository.ProduitRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Iterable<Produit> findAll() {
        if (produitRepository.count() == 0) {
            throw new NoProduitFoundException();
        }
        return produitRepository.findAll();
    }

    public Produit findById(int id) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (produit.isEmpty()) {
            throw new NoProduitFoundException();
        }
        return produit.get();
    }

    public Produit save(Produit produit) {
        if (produitRepository.findByNom(produit.getNom()) != null){
            throw new ProduitAlreadyExistsException(produit.getNom());
        }
        return produitRepository.save(produit);
    }
}
