package org.example.demospringwebfluxexception.Controller;

import jakarta.validation.Valid;
import org.example.demospringwebfluxexception.entity.Personne;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/validation")
public class ValidationController {

    @PostMapping
    public Mono<String> addPersonne (@Valid @RequestBody Personne personne){
        return Mono.just("Personne add");
    }
}
