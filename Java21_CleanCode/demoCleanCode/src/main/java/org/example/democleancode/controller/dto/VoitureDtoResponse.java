package org.example.democleancode.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class VoitureDtoResponse {

    private int id;
    private int roue;
    private int porte;

    public VoitureDtoResponse() {
    }

    public VoitureDtoResponse(int id, int roue, int porte) {
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
