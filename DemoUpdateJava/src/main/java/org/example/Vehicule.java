package org.example;

public sealed abstract class Vehicule permits Voiture,Moto{

    protected int roue;

    public Vehicule(int roue) {
        this.roue = roue;
    }

    public void demarer(){
        System.out.println("le vehicule demare");
    }

    public void stop (){
        System.out.println("le vehicule s'arrete");
    }

    public int getRoue() {
        return roue;
    }

    public void setRoue(int roue) {
        this.roue = roue;
    }
}
