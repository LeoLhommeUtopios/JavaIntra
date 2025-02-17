## Méthodes d'Update

On a la possibilité en MongoDB de modifier un ou plusieurs documents.

1. `updateOne()`
Modifie le **premier document** correspondant au filtre mis en place

```js
db.users.updateOne({name: "John"}, {$set: {age : 30}});
```
Met à jour le champ "age" du premier utilisateur nommé "John".

2. `updateMany()`
Modifie **tous les documents** correspondant au filtre.

```js
db.users.updateMany({status: "inactive"}, {$set: {status: "active"}});
```

3. `replaceOne()`
Remplacer un document entier par un nouveau.

```js
db.users.replaceOne({name: "John"}, {firstName: "Jonathan", age: 40});
```

## Opérateurs de mise à jour

`$set` : Met à jour ou ajouter un champ

`$inc` : Incrémente ou décrémente la valeur d'un **champ numérique**

```js
db.users.updateMany({views: {$exists: true}}, {$inc: {views: 1 }})
```

`$unset` : Supprime un champ d'un document

`$push`: Ajoute une valeur à un tableau

```js
db.users.updateOne({{name: "Bob"}, {$push: {tags: "new"}}})
```

`$pull`: Retire une valeur d'un tableau

```js
db.users.updateOne({{name: "Bob"}, {$pull: {tags: "old"}}})
```
