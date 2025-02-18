package org.example.demospringwebfluxrest.controller;

import org.example.demospringwebfluxrest.entity.Product;
import org.example.demospringwebfluxrest.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    private final ProductService service;

    public ProductHandler(ProductService service) {
        this.service = service;
    }

    public Mono<ServerResponse> getAllProduct(ServerRequest request){
        return ServerResponse.ok().body(service.getAllProduct(), Product.class);
    }

    public Mono<ServerResponse> getProductById (ServerRequest request){
        String id = request.pathVariable("id");
        return service.getProductById(id)
                .flatMap(product -> ServerResponse.ok().bodyValue(product))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createProduct (ServerRequest request){
        return request.bodyToMono(Product.class)
                .flatMap(service::createProduct)
                .flatMap(product -> ServerResponse.created(request.uri()).bodyValue(product));
    }

}
