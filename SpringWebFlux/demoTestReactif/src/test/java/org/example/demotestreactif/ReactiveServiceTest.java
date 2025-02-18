package org.example.demotestreactif;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class ReactiveServiceTest {

    private final ReactiveService service = new ReactiveService();

    @Test
    void TestGetSingleData(){
        StepVerifier.create(service.getSingleData())
                .expectSubscription()
                .expectNext("Hello, Webflux!!")
                .verifyComplete();
    }

    @Test
    void testGetDataStream (){
        StepVerifier.create(service.getDataStream())
                .expectSubscription()
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }

    @Test
    void testErrorStream (){
        StepVerifier.create(service.getErrorStream())
                .expectSubscription()
                .expectNext(1,2,3)
                .expectErrorMatches(throwable -> throwable instanceof  RuntimeException
                        && throwable.getMessage().equals("Test Exeption"))
                .verify();
    }
}
