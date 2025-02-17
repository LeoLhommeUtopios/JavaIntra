package org.example.democleancode.service;

import java.time.LocalDate;

public class Voiture {
    private int id;
    private int roue;
    private int porte;
    private LocalDate createdAt;

    public Voiture() {
        this.createdAt = LocalDate.now();
    }

    public Voiture(int roue, int porte) {
        this();
        this.roue = roue;
        this.porte = porte;
    }

    public Voiture(int id, int roue, int porte) {
        this(roue,porte);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoue() {
        return roue;
    }

    public void setRoue(int roue) {
        this.roue = roue;
    }

    public int getPorte() {
        return porte;
    }

    public void setPorte(int porte) {
        this.porte = porte;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
