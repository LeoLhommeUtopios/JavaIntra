## Architecture: ACID et BASE

Dans le contexte des bases de données, une **transaction** est une séquence d'opérations effectuées sur la base qui est traitée comme une unité de travail indivisible. Les transactions sont essentielles pour garantir la cohérence et l'intégrité des données, surtout dans des environnements où plusieurs utilisateurs ou processus accèdent simultanément à la base de données.

BASE ET ACID sont deux concepts fondamentaux dans le domaine des BDD en ce qui concerne la gestion des transactions

## ACID
ACID est un acronyme qui décrit les propriétés garanties pas les SGBD pour assurer la fiabilité des transactions. Les quatres propriétés sont:

1. **Atomicité (atomicity):**
    - Une transaction est une unité de travail indivisible. Soit toutes les opérations de la transaction sont effectuées avec succès, soit aucune ne l'est. Si une partie de la transaction échoue, toutes les modifications effectuées par la transaction sont annulées (rollback).

2. **Cohérence (Consistency)**:
    - Une transaction doit transformer la base de données d'un état valide à un autre état valide. Les règles de cohérence doivent être respectées avant et après la transaction. Par exemple, si une règle stipule que le solde d'un compte ne peut pas être négatif, cette règle doit être respecté avant et après la transaction.

3. **Isolation (Isolation):**

    - Les transactions doivent être isolées les unes des autres. Les opérations d'une transaction ne doivent pas interférer avec celles d'une autre transaction. Cela garantit que les transactions concurrentes ne voient pas les modifications intermédiaires des autres transactions.

4. **Durabilité (Durability):**

    - Une fois qu'une transaction est validée (commit), ses modifications doivent être permanentes, même en cas de panne du système. Les données doivent être enregistrées de manière durable sur un support non volatile.

## BASE

BASE est un acronyme qui décrit les propriétés des systèmes de bases de données NoSQL, qui sont souvent plus flexibles et tolérants aux pannes que les systèmes ACID. Les trois propriétés de BASE sont:

1. **Basically Available (Disponibilité de base):**
- Le système garantit une disponibilité de base, ce qui signifie qu'il répondra toujours à une reuqête, même si certaines parties du système sont en panne. Cela peut impliquer que le système retourne des données qui ne sont pas à jour ou complètes.

2. **Soft state (état souple):**
- Le système peut être dans un état intermédiaire ou incohérent pendant une courte période. Les données peuvent ne pas être immédiatement cohérentes, mais elles finiront par converger vers un état cohérent.

3. **Eventual consistency (Cohérence éventuelle):**
- Le système garantit que toutes les copies des données finiront par être cohérentes, mais il peut y avoir un délai avant que cela ne se produise. Cela signifie que les lectures peuvent ne pas refléter les écritures les plus récentes immédiatement.

### Comparaison ACID vs BASE
- ACID est souvent utilisé dans les RDBMS où la cohérence et la fiabilité sont **cruciales**, comme dans les systèmes bancaires ou les systèmes de réservation.

- BASE est souvent utilisé dans les systèmes où la disponibilité et la tolérance aux pannes sont plus importantes que la cohérence immédiate, comme dans les systèmes de réseaux sociaux ou les systèmes de recommandation.