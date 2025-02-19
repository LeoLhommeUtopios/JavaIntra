package org.example.Demo1;

public class Calcul {

    public  double addition (double x, double y){
        return x+y;
    }

    public  double division (double x, double y){
        if(y!=0){
            return x/y;
        }
        throw new DivideByZeroException();
    }
}
