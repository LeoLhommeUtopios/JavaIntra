## Méthodes de suppression

Les méthodes de suppression permettent de retirer des documents d'une collection, soit de façon ciblée, soit en supprimant une collection entière.

1. `deleteOne()`  
Supprime **le premier document** correspondant au filtre
```js
db.users.deleteOne({name: "John"});
```

2. `deleteMany()`  
Supprime **tous les documents** correspondant au filtre
```js
db.users.deleteMany({country: "France"});
```

3. `drop()`  
Supprime toute une collection, y compris les métadonnées.
```js
db.users.drop();
```