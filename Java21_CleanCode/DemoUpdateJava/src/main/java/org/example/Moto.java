package org.example;

final public class Moto extends Vehicule{

    private String guidon;

    public Moto(int roue,String guidon) {
        super(roue);
        this.guidon = guidon;
    }

    public String getGuidon() {
        return guidon;
    }

    public void setGuidon(String guidon) {
        this.guidon = guidon;
    }
}
