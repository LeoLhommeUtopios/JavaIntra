package org.example;

final public class Voiture extends Vehicule{

    private int porte;
    public Voiture(int roue,int porte) {
        super(roue);
        this.porte = porte;
    }

    public int getPorte() {
        return porte;
    }

    public void setPorte(int porte) {
        this.porte = porte;
    }
}
