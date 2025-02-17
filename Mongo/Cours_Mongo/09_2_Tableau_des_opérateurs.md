## Tableau des opérateurs MongoDB

### **1. Opérateurs d’agrégation**
| **Opérateur** | **Description**                     | **Exemple**                                                                                                     |
|---------------|-------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `$sum`        | Additionne des valeurs             | `db.sales.aggregate([{ $group: { _id: "$category", total: { $sum: "$amount" } } }])`                            |
| `$avg`        | Calcule la moyenne                 | `db.sales.aggregate([{ $group: { _id: "$category", avgSales: { $avg: "$amount" } } }])`                         |
| `$min`        | Retourne la valeur minimale        | `db.sales.aggregate([{ $group: { _id: "$category", minAmount: { $min: "$amount" } } }])`                        |
| `$max`        | Retourne la valeur maximale        | `db.sales.aggregate([{ $group: { _id: "$category", maxAmount: { $max: "$amount" } } }])`                        |
| `$count`      | Compte les documents               | `db.sales.aggregate([{ $group: { _id: null, count: { $sum: 1 } } }])`                                           |
| `$push`       | Crée un tableau de valeurs         | `db.sales.aggregate([{ $group: { _id: "$category", items: { $push: "$itemName" } } }])`                         |
| `$addToSet`   | Ajoute des valeurs uniques au set  | `db.sales.aggregate([{ $group: { _id: "$category", uniqueItems: { $addToSet: "$itemName" } } }])`               |

---

### **2. Opérateurs de projection**
| **Opérateur** | **Description**                     | **Exemple**                                                                                                     |
|---------------|-------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `$slice`      | Limite les éléments d’un tableau   | `db.orders.find({}, { items: { $slice: 2 } })`                                                                  |
| `$elemMatch`  | Retourne le premier élément qui correspond à un filtre | `db.orders.find({ items: { $elemMatch: { qty: { $gt: 2 } } } })`                                                |
| `$size`       | Nombre d’éléments dans un tableau  | `db.orders.find({ items: { $size: 3 } })`                                                                       |

---


---

### **5. Opérateurs de tableau**
| **Opérateur** | **Description**                     | **Exemple**                                                                                                     |
|---------------|-------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `$all`        | Correspond à tous les éléments     | `db.orders.find({ items: { $all: ["pen", "notebook"] } })`                                                      |
| `$size`       | Taille du tableau                  | `db.orders.find({ items: { $size: 3 } })`                                                                       |
| `$elemMatch`  | Match avec une condition           | `db.orders.find({ items: { $elemMatch: { qty: { $gt: 2 } } } })`                                                |

---

### **6. Opérateurs d’arithmétique**
| **Opérateur** | **Description**                     | **Exemple**                                                                                                     |
|---------------|-------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `$add`        | Additionne des valeurs             | `db.sales.aggregate([{ $project: { total: { $add: ["$price", "$tax"] } } }])`                                   |
| `$subtract`   | Soustrait des valeurs              | `db.sales.aggregate([{ $project: { discount: { $subtract: ["$price", "$discount"] } } }])`                      |
| `$multiply`   | Multiplie des valeurs              | `db.sales.aggregate([{ $project: { total: { $multiply: ["$price", "$quantity"] } } }])`                         |
| `$divide`     | Divise des valeurs                 | `db.sales.aggregate([{ $project: { ratio: { $divide: ["$profit", "$sales"] } } }])`                             |
| `$mod`        | Retourne le reste d’une division   | `db.sales.aggregate([{ $project: { remainder: { $mod: ["$total", 2] } } }])`                                    |

---

### **7. Opérateurs de chaîne**
| **Opérateur** | **Description**                     | **Exemple**                                                                                                     |
|---------------|-------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `$concat`     | Concatène des chaînes              | `db.users.aggregate([{ $project: { fullName: { $concat: ["$firstName", " ", "$lastName"] } } }])`               |
| `$substr`     | Extrait une sous-chaîne            | `db.users.aggregate([{ $project: { initials: { $substr: ["$name", 0, 2] } } }])`                                |
| `$toLower`    | Convertit en minuscule             | `db.users.aggregate([{ $project: { nameLower: { $toLower: "$name" } } }])`                                      |
| `$toUpper`    | Convertit en majuscule             | `db.users.aggregate([{ $project: { nameUpper: { $toUpper: "$name" } } }])`                                      |

