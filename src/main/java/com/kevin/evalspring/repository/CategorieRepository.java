package com.kevin.evalspring.repository;

import com.kevin.evalspring.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
     Categorie findByLibele(String libele);
}
