## Compter les documents en MongoDB

MongoDB propose deux principales méthodes pour effectuer cette opération:

- `countDocuments()`: Fournit un décompte précis basé sur un filtre spécifique
- `estimatedDocumentCount()`: Donne une estimation rapide basée sur les métadonnées de la collection.

Ces méthodes permettent d'optimiser les performances selon les besoins

### countDocuments()

**Syntaxe:**

```js
collection.countDocuments(filter, options)
```
- `filter`: (Facultatif) Un objet de requête pour filtrer les documents avant le comptage.
- `options`: (Facultatif) Options supplémentaires comme `skip`, `limit` ou `collection`.

**Exemple:**

```js
db.orders.countDocuments({ status: "completed"}, (err, count) => {
    if (err) throw err;
    console.log("Nombre de commandes finalisées: ", count)
})
```

**Avantages:**
- Permet un comptage précis.
- Supporte les filtres complexes.

### estimatedDocumentCount()

Cette méthode fournit une estimation rapide du nombre totale de documents dans une collection, sans appliquer de filtres

**Syntaxe:**
```js
collection.estimatedDocumentCount(options);
```

- `options`: (Facultatif) Options supplémentaires, comme `maxTimeMS` pour limiter le temps d'exécution.

**Limites:**
- Ne prend pas en charge les filtres
- L'estimation peut être inexacte si la collection est fréquemment modifiée.