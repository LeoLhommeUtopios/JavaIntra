### **Exercice 2 : Tester les endpoints d’une API de gestion des commandes**
**Contexte :**
Un service de gestion des commandes permet de lister et d’ajouter des commandes via une API REST réactive.

#### **Instructions** :
1. Implémentez les endpoints suivants:
    - `GET /api/orders` : Retourne une liste de commandes (par ex. : `[{"id":1,"item":"Laptop"},{"id":2,"item":"Phone"}]`).
    - `POST /api/orders` : Ajoute une nouvelle commande à partir d’un JSON comme :
      ```json
      {
          "id": 3,
          "item": "Tablet"
      }
      ```

2. Écrivez des tests avec `WebTestClient` pour :
    - Vérifier que la liste initiale des commandes contient les éléments attendus.
    - Tester l’ajout d’une nouvelle commande et vérifier qu’elle est correctement ajoutée.

#### **Critères de réussite** :
- Les tests valident les réponses (statut HTTP, corps de la réponse).
- Le test POST vérifie que la commande ajoutée est accessible via GET.