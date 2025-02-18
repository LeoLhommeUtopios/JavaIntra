package org.example.demotestreactif;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

public class ReactiveService {

    public Mono<String>  getSingleData (){
        return Mono.just("Hello, Webflux!!").delayElement(Duration.ofMillis(500));
    }

    public Flux<Integer> getDataStream (){
        return Flux.just(1,2,3,4,5).delayElements(Duration.ofMillis(500));
    }

    public Flux<Integer> getErrorStream(){
        return Flux.concat(
                Flux.just(1,2,3),
                Flux.error(new RuntimeException("Test Exeption"))
        );
    }
}
