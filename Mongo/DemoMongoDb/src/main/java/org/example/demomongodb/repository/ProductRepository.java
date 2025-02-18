
package org.example.demomongodb.repository;

import org.bson.types.ObjectId;
import org.example.demomongodb.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    List<Product> findAllByPrixBetween(float prixMini, float prixMax);

    @Query("{'name': ?0}")
    List<Product> findByProductName (String name);

    @Query("""
            {'$limit' : 100}{'$skip': ?0}
            """)
    List<Product> paginate( int skip);

}
