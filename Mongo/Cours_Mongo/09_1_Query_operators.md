## Les opérateurs de requêtes (query operators)

En MongoDB, il existe beaucoup d'opérateurs, nous allons ici parcourir
- Les opérateurs de comparaison
- Les opérateurs logiques
- Les opérateurs d'éléments
- Les opérateurs de tableaux

### Les opérateurs de comparaison

| Opérateur | Description | Exemple |
| --- | --- | --- |
| `$eq` | Correspond à une valeur exacte. | `{ age: { $eq: 25 } }` |
| `$gt` | Correspond à une valeur strictement supérieure. | `{ age: { $gt: 25 } }` |
| `$gte` | Correspond à une valeur supérieure ou égale. | `{ age: { $gte: 25 } }` |
| `$lt` | Correspond à une valeur strictement inférieure. | `{ age: { $lt: 25 } }` |
| `$lte` | Correspond à une valeur inférieure ou égale. | `{ age: { $lte: 25 } }` |
| `$ne` | Correspond à une valeur différente. | `{ age: { $ne: 25 } }` |
| `$in` | Correspond à une valeur présente dans un tableau. | `{ age: { $in: [20, 25, 30] } }` |
| `$nin` | Correspond à une valeur absente d'un tableau. | `{ age: { $nin: [20, 25, 30] } }` |

### Les opérateurs logiques

| Opérateur | Description | Exemple |
| --- | --- | --- |
| `$and` | Toutes les conditions doivent être vraies. | `{ $and: [{ age: { $gt: 20 } }, { age: { $lt: 30 } }] }` |
| `$or` | Au moins une des conditions doit être vraie. | `{ $or: [{ age: { $lt: 20 } }, { age: { $gt: 30 } }] }` |
| `$not` | Inverse une condition. | `{ age: { $not: { $gt: 30 } } }` |
| `$nor` | Aucune des conditions ne doit être vraie. | `{ $nor: [{ age: { $lt: 20 } }, { age: { $gt: 30 } }] }` |

### Les opérateurs d'éléments
Ils ciblent des champs spécifiques

| Opérateur | Description | Exemple |
| --- | --- | --- |
| `$exists` | Vérifie si un champ existe. | `{ email: { $exists: true } }` |
| `$type` | Vérifie le type BSON d’un champ. | `{ age: { $type: "int" } }` |

### Les opérateurs de tableaux

| Opérateur | Description | Exemple |
| --- | --- | --- |
| `$all` | Tous les éléments spécifiés doivent être présents. | `{ tags: { $all: ["mongodb", "database"] } }` |
| `$elemMatch` | Au moins un élément du tableau doit correspondre aux conditions. | `{ scores: { $elemMatch: { $gte: 80, $lt: 90 } } }` |
| `$size` | Le tableau doit avoir une taille spécifique. | `{ tags: { $size: 3 } }` |