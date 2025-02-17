## Types de données en MongoDB

Dans MongoDB, les données sont stockées au format BSON (Binary JSON), qui supporte divers types de données. Comprendre ces types de données est essentiel car ils jouent un rôle crucial dans la conception du schéma et la performance des requêtes.

### Champ `_id` et ObjectId

- **Identifiant Unique:** Le champ `_id` est utilisé pour identifier de manière unique chaque documentdans une collection.

- **Valeur par défaut:** Si vous n'attribuez pas explicitement une valeur au champ lors de l'insertion d'un nouveau document, MongoDB génère automatiquement une valeur unique. Par défaut, cette valeur est un objet `ObjectId`.

L'ObjectId est un identifiant de 12octets dont la structure est la suivante:
- 4 octets: Timestamp (secondes depuis Unix)
- 5 octets: Identifiant de machine
- 2 octets: Identifiant de processus
- 3 octets: Compteur incrémental

**Personnalisation:** Vous pouvez attribuer une valeur personnalisée. Vous pouvez utiliser une chaîne de caractères, un nombre ou tout autre type de données qui garantit l'unicité.

#### Importance du champ _id:
- **Intégrité des données**
- **Indexation:** Il est automatiquement indexé par MongoDB
- **Références:** Il est souvent utilisé pour créer des références entre documents de différentes collections, facilitant les relations entre données.

### Autres types

- **String:** Il doit être une chaîne de caractères encodée en UTF-8.
- **Boolean**
- **Integer:** MongoDB supporte deux types d'entiers: 32bits (int) et 64bits (long).
- **Double**
- **Date:** Le type Date est utilisé pour stocker date et heure au format Unix (timestamp en millisecondes depuis le 1er janvier 1970)
```json
{
    "createdAt": ISODate("2023-02-22T19:29:22.381Z")
}
```
- **Array**
- **Object**
- **Nullable:** Représente l'absence de valeur. La valeur undefined est également reconnue mais elle est déconseillée en MongoDB.
- **Data binaire:**
```json
{
    "data": BinData(0, "c3VyZS4=")
}
```
- **Code**:
```json
{
    "script": Code("function() { return 'Hello, World!';}")
}
```
- **Regular Expression:**
```json
{
    "pattern": /^mongodb/i
}
```