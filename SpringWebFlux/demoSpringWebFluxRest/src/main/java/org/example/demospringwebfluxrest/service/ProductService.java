package org.example.demospringwebfluxrest.service;

import org.example.demospringwebfluxrest.entity.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class ProductService {
    private final Map<String, Product> productMap = new ConcurrentHashMap<>();

    public ProductService() {
        productMap.put("1",new Product("1","Livre", BigDecimal.valueOf(0.99)));
        productMap.put("2",new Product("2","Pain", BigDecimal.valueOf(2.55)));
    }

    public Flux<Product> getAllProduct (){
        return Flux.fromIterable(productMap.values());
    }

    public Mono<Product> getProductById(String id){
        return Mono.justOrEmpty(productMap.get(id));
    }

    public Mono<Product> createProduct (Product product){
        String id = UUID.randomUUID().toString();
        product.setId(id);
        productMap.put(id,product);
        return Mono.just(product);
    }
}
