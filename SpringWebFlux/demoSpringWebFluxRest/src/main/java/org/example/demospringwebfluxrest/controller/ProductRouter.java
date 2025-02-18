package org.example.demospringwebfluxrest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class ProductRouter {

    private static final String defaultRoute = "/api/products";
    @Bean
    public RouterFunction<ServerResponse> productRoutes (ProductHandler productHandler){
        return route(GET(defaultRoute),productHandler::getAllProduct)
                .andRoute(GET(defaultRoute+"/{id}"),productHandler::getProductById)
                .andRoute(POST(defaultRoute),productHandler::createProduct);
    }
}
