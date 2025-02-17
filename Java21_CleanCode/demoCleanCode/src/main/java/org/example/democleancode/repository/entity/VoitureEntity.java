package org.example.democleancode.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class VoitureEntity {

    @Id
    @GeneratedValue
    private int id;

    private int roue;
    private int porte;

    public VoitureEntity(int roue, int porte) {
        this.roue = roue;
        this.porte = porte;
    }

    public VoitureEntity() {
    }

    public VoitureEntity(int id, int roue, int porte) {
        this.id = id;
        this.roue = roue;
        this.porte = porte;
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
}
