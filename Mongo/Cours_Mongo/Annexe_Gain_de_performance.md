Pour comprendre le **gain de performance d’un index dans MongoDB** à l'aide de la commande `explain()`, vous devez vous concentrer sur certaines métriques spécifiques qui mettent en lumière les différences entre une requête sans index et une requête utilisant un index.

### Étapes pour analyser les performances

1. **Exécuter une requête sans index (COLLSCAN)** :
Effectuez une requête avec `explain("executionStats")` avant d’ajouter un index pour obtenir une ligne de base des performances.
    
    ```jsx
    db.collection.find({ age: 25 }).explain("executionStats");
    
    ```
    
    **Points à noter dans le résultat :**
    
    - **executionTimeMillis** : Le temps d'exécution en millisecondes.
    - **totalDocsExamined** : Le nombre total de documents scannés.
    - **COLLSCAN** : Indique un scan complet de la collection, ce qui est souvent moins performant pour des collections volumineuses.
2. **Ajouter un index** sur le champ utilisé dans votre requête :
    
    ```jsx
    db.collection.createIndex({ age: 1 });
    
    ```
    
3. **Exécuter la même requête avec index (IXSCAN)** :
Refaire l'analyse avec `explain("executionStats")` après l'ajout de l'index.
    
    ```jsx
    db.collection.find({ age: 25 }).explain("executionStats");
    
    ```
    
    **Ce que vous remarquerez :**
    
    - **IXSCAN** : MongoDB utilisera l’index pour rechercher les documents.
    - **totalKeysExamined** : Nombre de clés examinées dans l'index (souvent bien inférieur à `totalDocsExamined`).
    - **executionTimeMillis** : Réduction significative du temps d’exécution.
    - **totalDocsExamined** : Seulement les documents pertinents seront examinés.

---

### Exemple comparatif

**Sans index (COLLSCAN)** :

```json
{
  "executionStats": {
    "executionTimeMillis": 45,
    "totalDocsExamined": 100000,
    "totalKeysExamined": 0,
    "stage": "COLLSCAN"
  }
}

```

**Avec index (IXSCAN)** :

```json
{
  "executionStats": {
    "executionTimeMillis": 5,
    "totalDocsExamined": 10,
    "totalKeysExamined": 10,
    "stage": "IXSCAN"
  }
}

```

Dans cet exemple :

- Le temps d’exécution est passé de **45ms** à **5ms**.
- Le nombre de documents scannés est réduit de **100 000** à seulement **10**.

---

### Interprétation des gains

- **COLLSCAN** est inefficace pour des collections volumineuses car il scanne chaque document.
- **IXSCAN** permet à MongoDB d’examiner uniquement les clés pertinentes de l’index, ce qui réduit drastiquement le temps d’exécution et la charge.

---

### Points clés pour optimiser

- **Créer les bons index** : Basez-vous sur les champs les plus utilisés dans vos filtres ou tri.
- **Utiliser des index composés** si votre requête utilise plusieurs champs.
- **Tester régulièrement avec `explain()`** après l’ajout ou la suppression d’index.