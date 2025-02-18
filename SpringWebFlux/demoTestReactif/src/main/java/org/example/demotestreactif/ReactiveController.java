package org.example.demotestreactif;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/test")
public class ReactiveController {

    @GetMapping("/single")
    public Mono<String> getSingleData (){
        return Mono.just("Hello, Webflux !!");
    }

    @GetMapping("/stream")
    public Flux<Integer> getStream (){
        return Flux.just(1,2,3,4);
    }
}
