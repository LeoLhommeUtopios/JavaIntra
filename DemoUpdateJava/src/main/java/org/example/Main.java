package org.example;

public class Main {
    public static void main(String[] args) {

//        Object obj = true;
//
//        switchFunc(obj);
//
//        String varStr = """
//
//        mon text %s %S
//        """.formatted(123,123);
//
//        System.out.println(varStr);

        Vehicule vehicule1 = new Voiture(4,3);
        Vehicule vehicule2 = new Moto(2,"Guidon droit");
        Vehicule vehicule3 = new Moto(3,"guidon courbé");

        switchVehicule(vehicule1);
        switchVehicule(vehicule2);
        switchVehicule(vehicule3);

    }

    public static void switchVehicule (Vehicule vehicule){
        switch (vehicule){
            case Moto moto -> System.out.printf("""
                    
                    Ma Moto a %s roues
                    et a un guidon : %s
                    """,moto.getRoue(), moto.getGuidon());
            case Voiture voiture -> System.out.printf("""
                    
                    Ma Voiture a %s roues
                    et a un %s portes
                    """,voiture.getRoue(), voiture.getPorte());
        }
    }

    public void getuser(){
        getInfoUser("entrer votre nom");
        getInfoUser("entrer votre nom");

        getInfoUser("entrer votre age",15);

        verfiinfo("","",12);


        // genration user
    }

    public String getInfoUser(String message){
        //recuperation nom

        // recuperation du prenom
        return "";
    }

    public int getInfoUser(String message ,int agemin){
        // recuperation age
        return 0;
    }

    public boolean verfiinfo (String nom,String prenom,int age){
        //verif info
         return true;
    }

    public static void switchFunc (Object obj){
        switch (obj){
            case Integer i -> System.out.println(i * 3);
            case String s -> System.out.println(s.toLowerCase());
            case null -> System.out.println("Obj est null");
            default -> System.out.printf("""
                    cas par default
                    %s n'est dans aucun des type specifié
                    fin du message !
                    """, obj);

        }
    }


}