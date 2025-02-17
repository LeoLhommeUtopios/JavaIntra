## Recherche en MongoDB

La méthode `find()` de MongoDB est essentielle pour interagir avec les documents dans une collection. Elle permet d'effectuer des recherches basées sur des critères précis, de limiter les résultats et d'appliquer des projections, des tris, ou des décalages.

1. Méthode de base
La méthode `find()` sans argument retourne tous les documents d'une collection

```js
db.users.find();
```

2. Filtres de recherche
Les filtres permettent des rechercher en utilisant les paires clé-valeur.

```js
db.users.find({ age: 25 });
```

3. Opérateurs logiques

`$and`: Chercher des documents qui répondent à toutes les conditions

```js
db.users.find($and: [{ age: 25 }, { first_name: "John"}]);
```

`$or` : Documents qui remplissent au moins une condition.

```js
db.users.find($or: [{ age: 25 }, { first_name: "John"}]);
```

`$not`: Exclut les documents correspondant à une condition

```js
db.users.find({ age: {$not: 25} });
```

4. Projection
La projection contrôle les champs retournés dans les résultats.  
En spécifiant 1 pour inclure ou 0 pour exclure, vous pouvez configurer les champs à afficher

```js
db.users.find({ age: 25 }, { first_name: 1, age: 1});
```

5. Tri des résultats
Utilisez la méthode `sort()` pour organiser les résultats

```js
db.users.find().sort({ age: 1}); // Tri croissant
```

```js
db.users.find().sort({ age: -1}); // Tri décroissant
```

6. Limitation et décalage

Pour ne récupérer qu'un nombre limité de documents
```js
db.users.find().limit(5);
```

Pour ignorer un certains nombres de documents au début
```js
db.users.find().skip(10);
```

On peut combiner les deux:
```js
db.users.find().skip(10).limit(5);
// Saute les 10 premiers documents et retourne les 5 suivants
```

7. Exemple de combinaison avancée
```js
db.users.find({age: 25}, {first_name: 1, age: 1}).sort({first_name: -1}).limit(5);
```
Retourner les noms et âges des utilisateurs qui ont 25ans, triés par nom décroissant, et limité aux 5 premiers résultats.