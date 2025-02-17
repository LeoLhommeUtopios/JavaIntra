package org.example.demomongodb.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProductDtoReceive {
    private String name;
    private float prix;
    private int stock;

    public ProductDtoReceive(String name, float prix, int stock) {
        this.name = name;
        this.prix = prix;
        this.stock = stock;
    }

    public ProductDtoReceive() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
