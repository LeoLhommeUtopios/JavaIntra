package org.example.demomongodb.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "product")
public class Product {
    @Id
    private ObjectId id;

    @Indexed(name = "product_name",unique = true)
    private String name;

    @Field(name = "productPrice")
    private float prix;

    private int stock;

    public Product(String name, float prix, int stock) {
        this.name = name;
        this.prix = prix;
        this.stock = stock;
    }

    public Product(ObjectId id, String name, float prix, int stock) {
        this(name,prix,stock);
        this.id = id;
    }

    public Product() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
