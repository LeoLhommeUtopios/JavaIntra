package org.example.demotestreactif;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(ReactiveController.class)
public class TestReactiveController {

    @Autowired
    private WebTestClient webClient;


    @Test
    void testGetSingleData(){
        webClient.get().uri("/api/test/single")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Webflux !!");
    }

    @Test
    void testGetMultipleData (){
        webClient.get().uri("/api/test/stream")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Integer.class).contains(1,2,3,4);
    }
}
