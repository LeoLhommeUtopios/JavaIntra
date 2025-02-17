package org.example.democleancode.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class VoitureDtoReceive {
    private int roue;
    private int porte;

    public VoitureDtoReceive(int roue, int porte) {
        this.roue = roue;
        this.porte = porte;
    }

    public VoitureDtoReceive() {
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
