package com.kevin.evalspring.repository;

import com.kevin.evalspring.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
     Produit findByNom(String nom);
}
