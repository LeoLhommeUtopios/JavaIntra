package org.example.demomongodb.service;

import org.bson.types.ObjectId;
import org.example.demomongodb.dto.ProductDtoReceive;
import org.example.demomongodb.dto.ProductDtoResponse;
import org.example.demomongodb.entity.Product;
import org.example.demomongodb.exception.NotFoundException;
import org.example.demomongodb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct {

    private ProductRepository repository;

    public ServiceProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDtoResponse save (ProductDtoReceive productDtoReceive){
        Product product = dtoToProduct(productDtoReceive);
        repository.save(product);
        return productToDto(product);
    }

    public ProductDtoResponse getById (String id){
        Product product = repository.findById(new ObjectId(id)).orElseThrow( ()-> new NotFoundException("No object with id :" + id));
        return productToDto(product);
    }

    public List<ProductDtoResponse> getByPrice (float prixMini, float prixMax){
        List<Product> products = repository.findAllByPrixBetween(prixMini,prixMax);
        return products.stream().map(this::productToDto).toList();
    }

    public List<ProductDtoResponse> getByName (String name){
        List<Product> products = repository.findByProductName(name);
        return products.stream().map(this::productToDto).toList();
    }

    private Product dtoToProduct (ProductDtoReceive productDtoReceive){
        return  new Product(productDtoReceive.getName(),productDtoReceive.getPrix(),productDtoReceive.getStock());
    }

    private ProductDtoResponse productToDto (Product product){
        return new ProductDtoResponse(product.getId().toString(), product.getName(), product.getPrix(), product.getStock() > 0);
    }


}
