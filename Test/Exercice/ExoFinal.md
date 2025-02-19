# Exercice : Développement d'une application Spring Boot avec Kafka, MongoDB et WebFlux

## Objectif
Développez une application Spring Boot intégrant les technologies suivantes :

- **Kafka Streams** pour la gestion des flux de données.
- **MongoDB** pour la persistance des données.
- **Spring MVC** pour l'exposition des API REST.
- **WebFlux** pour la gestion réactive.
- **TestContainers** pour les tests d'intégration.
- Respect des principes de **Clean Code**.

## Contexte
Vous êtes chargé de développer un service de traitement de données en temps réel. L'application devra consommer des messages provenant d'un topic Kafka, les transformer et les stocker dans une base de données MongoDB. Une API REST devra permettre de récupérer les données stockées en utilisant Spring WebFlux.

## Exigences Fonctionnelles
1. **Producteur Kafka** : Un microservice doit envoyer des messages JSON contenant des informations sur des transactions bancaires (montant, date, type, utilisateur, etc.).
2. **Consommateur Kafka avec Kafka Streams** : Un autre microservice doit consommer ces messages, effectuer des transformations (exemple : convertir les montants en une autre devise) et les sauvegarder dans MongoDB.
3. **API REST réactive** : Une API REST basée sur Spring WebFlux devra permettre de récupérer les transactions enregistrées en base.
4. **Tests d'intégration** : Utiliser TestContainers pour tester l'application avec des instances réelles de Kafka et MongoDB en environnement isolé.
5. **Respect des bonnes pratiques** : L'application doit être développée en respectant les principes du Clean Code.

## Étapes de Réalisation
1. **Initialisation du projet Spring Boot** avec les dépendances nécessaires.
2. **Mise en place de Kafka** : configuration d'un topic Kafka et d'un producteur.
3. **Développement du consommateur Kafka avec Kafka Streams** pour le traitement des messages.
4. **Intégration avec MongoDB** pour la persistance des données.
5. **Création d'une API REST réactive** pour récupérer les données stockées.
6. **Écriture des tests d'intégration** avec TestContainers.
7. **Refactoring et amélioration du code** pour respecter les bonnes pratiques.

