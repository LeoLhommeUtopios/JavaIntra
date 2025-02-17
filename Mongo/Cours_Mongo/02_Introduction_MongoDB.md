# Introduction à MongoDB

1. MongoDB, c'est quoi ?

MongoDB est une base de données NoSQL orientée documents, permettant de stocker des données sous un format JSON binaire appelé **BSON** *(Binary JSON)*. Elle est conçue pour des besoins modernes où les structures rigides du SQL deviennent un goulot d'étranglement.

**Licence:** MongoDB est distribué sous licence Server Side Public License (SSPL).

**Plateformes:** Disponible pour les systèmes d'exploitations majeurs (Windows, macOS, Linux) et en cloud via MongoDB Atlas.

**Historique**

- **2007:** Créé par *10gen* comme composant d'une plateforme PaaS.
- **2009:** Lancement en tant que projet autonome.
- **Aujourd'hui:** MongoDB est utilisé par des entreprises comme Uber, eBay, Google pour ses fonctionnalités de scalabilité et de traitement de données en temps réel.

2. Comparaison MongoDB vs SQL

### Caractéristiques principales :

| **MongoDB** | **Base de données relationnelle** |
| --- | --- |
| Données stockées sous forme de documents JSON/BSON | Données stockées dans des tables structurées. |
| Schéma flexible | Schéma rigide, nécessitant une définition initiale. |
| Scalabilité horizontale grâce au *sharding* | Scalabilité verticale principalement. |
| Moins performant pour des transactions complexes | Performant pour les transactions multi-tables. |

3. Concepts clés

- **Langage de requête:** MongoDB utilise un langage de requête appelé MongoDB Query Language (MQL) pour interagir avec la BDD.
Les opérations de lecture, écriture, mise à jour et suppression sont effectuées à l'aide de commandes MongoDB.

### Documents et Collections

- **Document:** Unité de base des données, stockée sous format BSON

- **Collection:** Ensemble de documents similaires. (équivalent à une table SQL)

- **Identifiant unique (_id):** Chaque document à un champ spécial appelé "_id" qui doit être unique au sein de la collection. Il peut être généré automatiquement ou spécifié manuellement.

- **Collections sans schéma fixe:** Les collections ne nécessitent pas de déclaration de schéma à l'avance.

4. Les outils de l'écosystème MongoDB

**MongoDB Atlas**
MongoDB Atlas est une plateforme cloud entièrement gérée pour MongoDB. Elle offre:
- Création et la gestion facile des clusters
- Outils de monitoring et sauvegardes automatiques.
- Multi-cloud: compatible avec AWS, Azure et Google Cloud.

**MongoDB Compass**
GUI pour explorer et analyser les bases MongoDB.
- Interface visuelle pour les documents et collections.
- Outils pour exécuter des requêtes et analyser les performances.
- Gestion avancée des index.

**MongoDB Shell (mongosh)**
Interface CLI pour interagir avec votre base MongoDB
- Exécuter des requêtes
- Gérer les bases de données et les collections
- Automatiser des tâches avec des scripts JavaScript.

**MongoDB Realm**
- Plateforme mobile et backend qui s'intègre à MongoDB
- Gestion des synchronisations temps réel entre bases MongoDB Atlas et applications mobiles.

**Outils de DevOps:**
- MongoDB Ops Manager: Gestion et monitoring des clusters MongoDB locaux.
- Backup Tools: Outils pour sauvegarder/restaurer vos bases, `mongodump` et `mongorestore`.

5. Fonctionnalités avancées

**Transactions**
Depuis MongoDB 4.0, les transactions multi-documents sont prises en charge, rapprochant MongoDB des bdd classiques pour des opérations nécessitant un ACID strict.

**Validation de schéma**
Bien que MongoDB soit **schemaless**, il est possible de définir des contraintes avec JSON Schema Validator

**Drivers MongoDB**
MongoDB offre des pilotes officiels pour plusieurs langages:
- Node.js
- Python (PyMongo)
- Java
- C++
- PHP

**Connecteurs BI**
MongoDB propose un connecteur Business Intelligence (BI) permettant d'intégrer vos données dans des outils comme PowerBI, Excell, Tableau.