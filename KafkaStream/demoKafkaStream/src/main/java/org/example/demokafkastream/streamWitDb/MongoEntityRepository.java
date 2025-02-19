package org.example.demokafkastream.streamWitDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEntityRepository extends MongoRepository<EntityMongo, ObjectId> {
}
