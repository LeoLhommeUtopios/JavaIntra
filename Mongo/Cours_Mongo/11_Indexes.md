## Les Indexs dans MongoDB

Un index est une structure spéciale stockée dans une collection qui améliore la vitesse des opérations de recherche.  
Sans index, MongoDB doit parcourir toute la collection pour trouver les documents correspondants, ce qui peut être inefficace sur de grandes collections.

### Pourquoi utiliser des indexs ?

Les indexs sont utilisés pour:
1. **Accélérer les recherches:** Réduisent considérablement le temps nécessaire pour localiser les documents dans une collections.
2. **Trier les résultats efficacemment:** Ils permettent à MongoDB de trier les données sans avoir à les charger intégralement.
3. **Assurer l'unicité des champs:** Grâce à des indexs uniques, on peut imposer des contraintes sur un champ (ex: un email unique).

### Inconvénients des index.

- **Espace disque:** Les index nécessitent un espace supplémentaire
- **Temps de mise à jour:** Lors des opérations d'insertion, de mise à jour ou de suppression, les index aussi doivent être mis à jour, ce qui peut ralentir ces opérations.

### Syntaxe

**Création d'un index:**
```js
db.users.createIndex({email: 1});
```

**Suppression d'un index:**
```js
// Suppression d'un index ciblé
db.users.dropIndex("nom_de_l'index");

// Suppression de tous les indexes de la collection.
db.users.dropIndexes();
```

**Vérification des index existants**
```js
db.users.getIndexes();
```

### Les types d'index

1. **Index unique**
```js
db.users.createIndex({email: 1}, {unique: true});
```
Cette option spécifie que l'index doit être unique.

2. **Index composé**
Index sur plusieurs champs. Utilisé pour optimiser les recherches complexes.
```js
db.users.createIndex({firstName: 1, lastName: 1});
```
**Ordre des champs:** MongoDB utilise l'ordre des champs pour optimiser la requête. Donc un index sur `{firstName:1, lastName:1}` est différent d'un index sur `{lastName:1, firstName:1 }`

3. **Index texte**

```js
db.products.createIndex({description: "text"});
```
Vous pouvez maintenant effectuer des recherches en texte intégral sur le champ `description`

4. **Index géospatial**
Optimise les requêtes sur les données géographiques
```js
db.collection.createIndex({location: "2dsphere"});
```

5. **Index partiel**
Index uniquement sur les documents qui remplissent une condition.
```js
db.collection.createIndex({age: 1}, {partialFilterExpression: {age: { $gt: 18}}});
```

6. **Index TTL (Time-to-live)**

C'est une fonctionnalité qui permet de supprimer automatiquement les documents d'une collection après un certain temps.  
Cela est particulièrement utile pour les applications qui ont besoin de gérer des données temporaires, comme les sessions utilisateurs, les logs, ou les caches.
**Ils doivent être appliqués sur un champ de type Date**
```js
db.sessions.insertOne({userId: "user123", createdAt: new Date()})
db.sessions.createIndex({createdAt: 1}, {expireAfterSeconds: 3600});
```

### Vérifier les performances avec `explain()`

MongoDB permet d'analyser les performances des requêtes.

```js
db.collection.find({age: 25}).explain("executionStats");
```

- **COLLSCAN**: Indique un scan complet de la collection.
- **IXSCAN**: Indique que MongoDB a utilisé un index.