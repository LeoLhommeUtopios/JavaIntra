package org.example.demospringwebfluxexception.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/errors")
public class ErrorController {

    @GetMapping
    public Mono<String> getGLobalError (){
        return Mono.error(new RuntimeException("GLobal error throw !!"));
    }
}
