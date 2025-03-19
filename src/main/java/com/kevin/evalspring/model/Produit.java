package com.kevin.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Le nom ne doit pas être vide")
    @Size(min = 3, max = 50, message = "Le nom de l'article doit contenir entre 3 et 50 caractères")
    @Column(name="nom", length = 50, unique = true, nullable = false)
    private String nom;

    @NotBlank(message = "Le prix ne doit pas être vide")
    @DecimalMin(value="0", inclusive = false, message="Le prix doit être supérieur à zéro")
    @Column(name="prix", nullable = false)
    private double prix;

    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Categorie categorie;

    public Produit() {}

    public Produit(String nom, double prix, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", categorie=" + categorie + '}';
    }
}
