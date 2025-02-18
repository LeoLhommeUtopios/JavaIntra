package org.example.demotestreactif;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TestMonoFlux {

    @Test
    public void testMono() {
        Mono<String> mono = Mono.just("Hello, WebFlux!");
        StepVerifier.create(mono)
                .expectNext("Hello, WebFlux!")
                .verifyComplete();
    }

    @Test
    public void testFlux() {
        Flux<String> flux = Flux.just("A", "B", "C");
        StepVerifier.create(flux)
                .expectNext("A")
                .expectNext("B")
                .expectNext("C")
                .verifyComplete();
    }
}
