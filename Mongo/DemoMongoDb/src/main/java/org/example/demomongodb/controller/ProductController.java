package org.example.demomongodb.controller;

import org.example.demomongodb.dto.ProductDtoReceive;
import org.example.demomongodb.dto.ProductDtoResponse;
import org.example.demomongodb.service.ServiceProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private ServiceProduct serviceProduct;

    public ProductController(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @PostMapping
    public ResponseEntity<ProductDtoResponse> addProduct (@RequestBody ProductDtoReceive productDtoReceive){
        return ResponseEntity.ok(serviceProduct.save(productDtoReceive));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ProductDtoResponse> getById (@RequestParam String id){
        return ResponseEntity.ok(serviceProduct.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDtoResponse>> getByPrice (){
        return ResponseEntity.ok(serviceProduct.getByPrice(5,16));
    }

    @GetMapping("findByName/{name}")
    public ResponseEntity<List<ProductDtoResponse>> getByName (@PathVariable("name") String name){
        return ResponseEntity.ok(serviceProduct.getByName(name));
    }
}
