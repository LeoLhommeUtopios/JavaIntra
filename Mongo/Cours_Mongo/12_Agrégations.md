## Les agrégations

## Données d'exemple

Les exemples s'appuieront sur une collection nommée `orders` avec les documents suivants :

```json
[
  {
    "_id": 1,
    "customer": "Alice",
    "items": [
      { "product": "Notebook", "quantity": 2, "price": 5 },
      { "product": "Pencil", "quantity": 5, "price": 1 }
    ],
    "total": 15,
    "date": "2023-12-01"
  },
  {
    "_id": 2,
    "customer": "Bob",
    "items": [
      { "product": "Notebook", "quantity": 1, "price": 5 },
      { "product": "Eraser", "quantity": 3, "price": 0.5 }
    ],
    "total": 6.5,
    "date": "2023-12-02"
  },
  {
    "_id": 3,
    "customer": "Charlie",
    "items": [
      { "product": "Pencil", "quantity": 10, "price": 1 },
      { "product": "Eraser", "quantity": 2, "price": 0.5 }
    ],
    "total": 12,
    "date": "2023-12-03"
  }
]

```

---

## Le Pipeline d'Agrégation

### Définition

Le pipeline d'agrégation dans MongoDB est une séquence d’étapes qui transforme et analyse les documents. Chaque étape produit une sortie qui sert d'entrée à l'étape suivante.

---
## Opérateurs d'Agrégation

### 1. `$match`

Filtre les documents selon des critères.

**Exemple :**
Afficher les commandes dont le total est supérieur à 10.

```jsx
db.orders.aggregate([
  { $match: { total: { $gt: 10 } } }
]);
```

**Résultat :**

```json
[
  {
    "_id": 1,
    "customer": "Alice",
    "items": [
      { "product": "Notebook", "quantity": 2, "price": 5 },
      { "product": "Pencil", "quantity": 5, "price": 1 }
    ],
    "total": 15,
    "date": "2023-12-01"
  },
  {
    "_id": 3,
    "customer": "Charlie",
    "items": [
      { "product": "Pencil", "quantity": 10, "price": 1 },
      { "product": "Eraser", "quantity": 2, "price": 0.5 }
    ],
    "total": 12,
    "date": "2023-12-03"
  }
]
```

---
### 2. `$project`

Projette des champs spécifiques et effectue des transformations.

**Exemple :**
Afficher uniquement le client et son total, tout en ajoutant un champ calculé `taxes` (total x 0.2).

```jsx
db.orders.aggregate([
  {
    $project: {
      customer: 1,
      total: 1,
      taxes: { $multiply: ["$total", 0.2] }
    }
  }
]);

```

**Résultat :**

```json
[
  { "_id": 1, "customer": "Alice", "total": 15, "taxes": 3 },
  { "_id": 2, "customer": "Bob", "total": 6.5, "taxes": 1.3 },
  { "_id": 3, "customer": "Charlie", "total": 12, "taxes": 2.4 }
]

```
---
### 3. `$unwind`

L'opérateur **`$unwind`** est utilisé pour décomposer un tableau dans une collection de documents. Il prend chaque élément d'un tableau et crée un document distinct pour chaque élément, ce qui peut être utile pour effectuer des opérations d'agrégation sur les éléments individuels du tableau.

**Exemple :**
Décomposer les items en documents individuels.

```jsx
db.orders.aggregate([
  { $unwind: "$items" }
]);
```

**Résultat :**

```json
[
  { "_id": 1, "customer": "Alice", "items": { "product": "Notebook", "quantity": 2, "price": 5 }, "total": 15, "date": "2023-12-01" },
  { "_id": 1, "customer": "Alice", "items": { "product": "Pencil", "quantity": 5, "price": 1 }, "total": 15, "date": "2023-12-01" },
  { "_id": 2, "customer": "Bob", "items": { "product": "Notebook", "quantity": 1, "price": 5 }, "total": 6.5, "date": "2023-12-02" },
  { "_id": 2, "customer": "Bob", "items": { "product": "Eraser", "quantity": 3, "price": 0.5 }, "total": 6.5, "date": "2023-12-02" },
  { "_id": 3, "customer": "Charlie", "items": { "product": "Pencil", "quantity": 10, "price": 1 }, "total": 12, "date": "2023-12-03" },
  { "_id": 3, "customer": "Charlie", "items": { "product": "Eraser", "quantity": 2, "price": 0.5 }, "total": 12, "date": "2023-12-03" }
]
```
---
### 4. `$group`

L'opérateur **`$group`** est utilisé pour regrouper les documents par une ou plusieurs clés spécifiées et appliquer des fonctions d'agrégation sur chaque groupe de documents. 

Cela permet de réaliser des opérations telles que le calcul de sommes ou de moyennes par exemple

Supposons que vous avez une collection **`orders`** avec des documents comme celui-ci :

```json
{ "_id": 1, "customer": "Alice", "amount": 100 }
{ "_id": 2, "customer": "Bob", "amount": 200 }
{ "_id": 3, "customer": "Alice", "amount": 150 }

```

Vous pouvez utiliser **`$group`** pour compter le nombre de commandes par client :

```jsx
db.orders.aggregate([
  {
    $group: {
      _id: "$customer",
      totalOrders: { $sum: 1 }
    }
  }
])
```

Cela produira un résultat comme celui-ci :

```json
{ "_id": "Alice", "totalOrders": 2 }
{ "_id": "Bob", "totalOrders": 1 }
```

---
### 5. `$sort`

Trie les documents.

**Exemple :**
Trier les commandes par `total` décroissant.

```jsx
db.orders.aggregate([
  { $sort: { total: -1 } }
]);
```

**Résultat :**

```json
[
  { "_id": 1, "customer": "Alice", "items": [...], "total": 15, "date": "2023-12-01" },
  { "_id": 3, "customer": "Charlie", "items": [...], "total": 12, "date": "2023-12-03" },
  { "_id": 2, "customer": "Bob", "items": [...], "total": 6.5, "date": "2023-12-02" }
]
```
---
### 6. `$addFields`

Ajoute de nouveaux champs ou modifie des champs existants.

**Exemple :**
Ajouter un champ `orderDateYear` pour extraire l’année de la date.

```jsx
db.orders.aggregate([
  { $addFields: { orderDateYear: { $year: { $dateFromString: { dateString: "$date" } } } } }
]);
```

**Résultat :**

```json
[
  { "_id": 1, "customer": "Alice", "items": [...], "total": 15, "date": "2023-12-01", "orderDateYear": 2023 },
  { "_id": 2, "customer": "Bob", "items": [...], "total": 6.5, "date": "2023-12-02", "orderDateYear": 2023 },
  { "_id": 3, "customer": "Charlie", "items": [...], "total": 12, "date": "2023-12-03", "orderDateYear": 2023 }
]
```
---
### 7. `$limit`

Limite le nombre de documents renvoyés.

**Exemple :**
Afficher les 2 premières commandes.

```jsx
db.orders.aggregate([
  { $limit: 2 }
]);
```

**Résultat :**

```json
[
  { "_id": 1, "customer": "Alice", "items": [...], "total": 15, "date": "2023-12-01" },
  { "_id": 2, "customer": "Bob", "items": [...], "total": 6.5, "date": "2023-12-02" }
]
```

---
### 8. `$skip`
Ignore les premiers documents.

**Exemple :**
Ignorer la première commande.

```jsx
db.orders.aggregate([
  { $skip: 1 }
]);
```

**Résultat :**

```json
[
  { "_id": 2, "customer": "Bob", "items": [...], "total": 6.5, "date": "2023-12-02" },
  { "_id": 3, "customer": "Charlie", "items": [...], "total": 12, "date": "2023-12-03" }
]
```

___
### 9. `$lookup`

L'opérateur `$lookup` en MongoDB est utilisé pour effectuer des jointures entre deux collections, similaire à une jointure SQL. 

Il permet de combiner des documents de deux collections en une seule opération d'agrégation.

### Syntaxe

La syntaxe de base pour utiliser `$lookup` dans une opération d'agrégation est la suivante :

```json
{
  $lookup: {
    from: <collection to join>,
    localField: <field from the input documents>,
    foreignField: <field from the documents of the from collection>,
    as: <output array field>
  }
}
```

- `from` : Le nom de la collection à joindre.
- `localField` : Le champ de la collection d'entrée (celle sur laquelle vous effectuez l'agrégation) à comparer.
- `foreignField` : Le champ de la collection à joindre à comparer.
- `as` : Le nom du champ de sortie où les documents joints seront stockés.

### Exemple

Supposons que vous avez deux collections : `orders` et `customers`. Vous souhaitez joindre les documents de `customers` aux documents de `orders` en fonction de l'ID du client.

### Collections

- `orders` :
    
    ```json
    { "_id": 1, "item": "apple", "price": 10, "quantity": 2, "customerId": 1 }
    { "_id": 2, "item": "banana", "price": 5, "quantity": 5, "customerId": 2 }
    
    ```
    
- `customers` :
    
    ```json
    { "_id": 1, "name": "Alice", "email": "alice@example.com" }
    { "_id": 2, "name": "Bob", "email": "bob@example.com" }
    
    ```

### Requête `$lookup`

```jsx
db.orders.aggregate([
  {
    $lookup: {
      from: "customers",
      localField: "customerId",
      foreignField: "_id",
      as: "customerDetails"
    }
  }
])
```

### Résultat

```jsx
[
  {
    "_id": 1,
    "item": "apple",
    "price": 10,
    "quantity": 2,
    "customerId": 1,
    "customerDetails": [
      {
        "_id": 1,
        "name": "Alice",
        "email": "alice@example.com"
      }
    ]
  },
  {
    "_id": 2,
    "item": "banana",
    "price": 5,
    "quantity": 5,
    "customerId": 2,
    "customerDetails": [
      {
        "_id": 2,
        "name": "Bob",
        "email": "bob@example.com"
      }
    ]
  }
]
```
---

### Résumé des Opérateurs

| Opérateur | Description |
| --- | --- |
| `$match` | Filtre les documents. |
| `$project` | Projette des champs et calcule des valeurs. |
| `$group` | Regroupe les documents et calcule des stats. |
| `$sort` | Trie les documents. |
| `$unwind` | Décompose des tableaux. |
| `$addFields` | Ajoute ou modifie des champs. |
| `$limit` | Limite le nombre de documents. |
| `$skip` | Ignore un certain nombre de documents. |
| `$lookup` | Joint deux collections. |

---
### Exemple d’une pipeline d’agrégation

```jsx
db.orders.aggregate([
  // 1. Filtrer les commandes dont le total est supérieur à 10
  {
    $match: { total: { $gt: 10 } }
  },
  // 2. Décomposer les éléments du tableau `items`
  {
    $unwind: "$items"
  },
  // 3. Calculer le montant total pour chaque produit
  {
    $project: {
      product: "$items.product",
      totalAmount: { $multiply: ["$items.quantity", "$items.price"] }
    }
  },
  // 4. Regrouper les résultats par produit
  {
    $group: {
      _id: "$product",
      totalSales: { $sum: "$totalAmount" }
    }
  },
  // 5. Trier les résultats par montant total décroissant
  {
    $sort: { totalSales: -1 }
  },
  // 6. Limiter les résultats aux 2 produits les plus vendus
  {
    $limit: 2
  }
]);
```

### Résultat final

```jsx
[
  { "_id": "Pencil", "totalSales": 15 },
  { "_id": "Notebook", "totalSales": 10 }
]
```