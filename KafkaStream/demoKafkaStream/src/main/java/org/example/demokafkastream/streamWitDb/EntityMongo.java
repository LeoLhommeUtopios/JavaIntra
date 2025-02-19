package org.example.demokafkastream.streamWitDb;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "entity")
public class EntityMongo {
    @Id
    private ObjectId id;
    private String message;

    public EntityMongo(String message) {
        this.message = message;
    }

    public EntityMongo() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
