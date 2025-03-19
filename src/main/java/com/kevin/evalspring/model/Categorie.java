package com.kevin.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le libellé ne doit pas être vide")
    @Size(min = 2, max = 50, message = "Le libellé doit avoir une taille comprise entre 2 et 50 caractères")
    @Column(name="libele", nullable = false,length = 50)
    private String libele;

    public Categorie(){

    }

    public Categorie(String libele) {
        this.libele = libele;
    }

    @Override
    public String toString() {
        return "Categorie [libele=" + libele + "]";
    }
}
