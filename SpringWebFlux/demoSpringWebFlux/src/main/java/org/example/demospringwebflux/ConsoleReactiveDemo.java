package org.example.demospringwebflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsoleReactiveDemo {
    public static void main(String[] args) {
        //Simple mono
        Mono<String> mono = Mono.just("Hello world");
        mono.subscribe(System.out::println);

        //Simple FLux
        Flux<Integer> flux = Flux.just(1,2,3);
        flux.subscribe(System.out::println);

        //operation sur le flux
        Flux<Integer> flux2 = Flux.range(1,10)
                .filter(n -> n%2 ==0)
                .map(n -> n * 10);
        flux2.subscribe(System.out::println);

        Flux<String> errorFlux = Flux.just("1","B","2")
                .map(value ->{
                    if(value.equals("B")){
                        throw new RuntimeException("Erreur simuler !!");
                    }
                    return value;
                }).onErrorResume(e -> Flux.just("Default1","Default2"));

        errorFlux.subscribe(System.out::println, error -> System.err.println("erreur recupere"+error));


        Flux<Integer> errorFlux2 = Flux.range(1,5)
                .map(n ->{
                    if(n == 3 || n == 1){
                        throw new RuntimeException("Erreur simuler !! pour la valeur : "+n);
                    }
                    return n;
                }).onErrorContinue((e,value)->{
                    System.err.println("Erreur avec : "+value+" -> "+e.getMessage());
                });

        errorFlux2.subscribe(System.out::println);
    }
}
