package org.example.demospringwebfluxmongodb.repository;

import org.bson.types.ObjectId;
import org.example.demospringwebfluxmongodb.entity.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, ObjectId> {
    Flux<Item> findByName (String name);
}
