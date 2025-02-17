package org.example.demomongodb.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProductDtoResponse {
    private String id;
    private String name;

    private float prix;

    private boolean isAvailable;

    public ProductDtoResponse(String id,String name, float prix, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.isAvailable = isAvailable;
    }

    public ProductDtoResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
