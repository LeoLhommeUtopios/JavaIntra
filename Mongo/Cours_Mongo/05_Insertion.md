## Insertion dans MongoDB

MongoDB offre deux méthodes principales: `insertOne()` et `insertMany()`.
Ces méthodes permettent d'insérer un ou plusieurs documents tout en offrant des options pour personnaliser leur comportement

### La méthode `insertOne()`
Utilisée pour insérer un **unique document** dans une collection.  
Elle renvoie un objet `InsertOneResult` contenant des informations sur le résultat de l'information.

```js
db.inventory.insertOne({
    item: "book",
    qty: 1
}); // Insertion d'un document
```

```js
{
    acknowledged: true,
    insertedId: ObjectId("64d54fez542dvsd");
}
```

### La méthode `insertMany()`
Utilisée pour insérer **plusieurs document** dans une collection.  
Elle renvoie un objet `InsertManyResult` contenant des informations sur le résultat de l'information.

```js
db.inventory.insertMany([<document_1>, <document_2>, <document_3>, ...]); 
```

```js
{
    acknowledged: true,
    insertedId: ObjectId("64d54fez542dvsd");
}
```
