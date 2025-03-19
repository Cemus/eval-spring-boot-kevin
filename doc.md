## Documentation de l'API
## Sommaire

* [Endpoints Produits](#endpoints-produits)
  * [Ajouter un produit](#ajouter-un-unproduit)
  * [Récupérer tous les produits](#récupérer-tous-les-produits)
  * [Récupérer un produit par son ID](#récupérer-un-produit-par-son-id)
* [Endpoints Categories](#endpoints-categories)
  * [Ajouter une catégorie](#ajouter-une-catégorie)
  * [Récupérer toutes les catégories](#récupérer-toutes-les-catégories)
  * [Récupérer une catégorie par son ID](#récupérer-une-catégorie-par-son-id)
* [Format de données attendu](#format-de-données-attendu)
* [Gestion des erreurs](#gestion-des-erreurs)
  * [Ressource non trouvée](#ressource-non-trouvée)
  * [Conflit lors de l'ajout](#conflit-lors-de-lajout)
  * [Erreur de format de requête](#erreur-de-format-de-requête)
---


## Endpoints Produits
### Ajouter un produit
**Méthode HTTP** : `POST`  
**URL** : `http://localhost:9000/produit`

**Description** : Cette méthode permet d'ajouter un nouveau produit dans la base de données.

**Body (JSON)** :
```json
{
  "nom": "Pelle",
  "prix": 0.1,
  "categorie": {
    "id": 1,
    "libele": "Jardinage"
  }
}
```
### Récupérer tous les produits
**Méthode HTTP** : `GET`  
**URL** : `http://localhost:9000/produits`

**Description** : Cette méthode permet de récupérer tous les produits.
### Récupérer un produit par son ID
**Méthode HTTP** : `GET`  
**URL** : `http://localhost:9000/produit/{id}`

**Description** : Cette méthode permet de récupérer un produit spécifique dans la base de données à partir de son ID.
## Endpoints Categories
### Ajouter une catégorie
**Méthode HTTP** : `POST`  
**URL** : `http://localhost:9000/categorie`

**Description** : Cette méthode permet d'ajouter une nouvelle catégorie dans la base de données.

**Body (JSON)** :
```json
{
  "libele":"Cuisine"
}
```
### Récupérer toutes les catégories
**Méthode HTTP** : `GET`  
**URL** : `http://localhost:9000/categories`

**Description** : Cette méthode permet de récupérer toutes les catégories.
### Récupérer une catégorie par son ID
**Méthode HTTP** : `GET`  
**URL** : `http://localhost:9000/categorie/{id}`

**Description** : Cette méthode permet de récupérer une catégorie spécifique dans la base de données à partir de son ID.

---

## Format de données attendu
### Produits
**nom** : Le nom du produit.  
* Ne peut pas être vide 
* Taille comprise entre 3 et 50 caractères inclus.

**prix** : Le prix du produit. 
* Ne peut pas être nul
* Doit être positif

### Catégories
**libele** : Le nom de la catégorie. 
* Ne peut pas être vide
* Taille comprise entre 2 et 50 caractères inclus.

---

## Gestion des erreurs 
### Ressource non trouvée
**Cas de figure** : La ressource demandée dans la requête n'existe pas.

**Erreur renvoyée** :
```json
{
  "Erreur": "Catégorie(s) absente(s) dans la base de données"
}
```
### Conflit lors de l'ajout
**Cas de figure** : L'ajout d'un produit ou d'une catégorie qui existe déjà.

**Erreur renvoyée** :
```json
{
  "Erreur": "Le produit 'Moule à madeleine' existe déjà dans la base de donnée"
}
```
### Erreur de format de requête
**Cas de figure** : L'ajout d'un produit ou d'une catégorie ne respecte pas le format de l'entité.

**Erreur renvoyée** :
```json
{
  "nom": "Le nom ne doit pas être vide"
}
```

