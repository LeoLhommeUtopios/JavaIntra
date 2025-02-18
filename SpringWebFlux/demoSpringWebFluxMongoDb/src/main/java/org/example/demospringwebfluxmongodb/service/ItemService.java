package org.example.demospringwebfluxmongodb.service;

import org.bson.types.ObjectId;
import org.example.demospringwebfluxmongodb.entity.Item;
import org.example.demospringwebfluxmongodb.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Flux<Item> getAllItem (){
        return repository.findAll();
    }

    public Mono<Item> getById(String id){
        return repository.findById(new ObjectId(id));
    }

    public Mono<Item> create (Item item){
        return repository.save(item);
    }

    public Mono<Item> updateItem (String id,Item item){
        return repository.findById(new ObjectId(id))
                .flatMap(existingItem ->{
                    existingItem.setName(item.getName());
                    existingItem.setDescription(item.getDescription());
                    existingItem.setPrice(item.getPrice());
                    return repository.save(existingItem);
                });
    }

    public Mono<Void> deleteItem(String id){
        return repository.deleteById(new ObjectId(id));
    }
}
