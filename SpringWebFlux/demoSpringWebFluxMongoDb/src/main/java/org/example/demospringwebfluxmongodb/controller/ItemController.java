package org.example.demospringwebfluxmongodb.controller;

import com.mongodb.MongoNodeIsRecoveringException;
import org.example.demospringwebfluxmongodb.entity.Item;
import org.example.demospringwebfluxmongodb.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Item> getAllItem (){
        return  service.getAllItem();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Item>> getById (@PathVariable("id") String id){
        return  service.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Item> createItem(@RequestBody Item item){
        return service.create(item);
    }


    @PutMapping("/{id}")
    public Mono<ResponseEntity<Item>> updateItem (@PathVariable String id,@RequestBody Item item){
        return service.updateItem(id,item)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteItem (@PathVariable String id){
        return service.deleteItem(id).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
