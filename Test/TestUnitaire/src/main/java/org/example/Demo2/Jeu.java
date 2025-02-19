package org.example.Demo2;

public class Jeu {

    public final Ide de;

    public Jeu(Ide de) {
        this.de = de;
    }

    public boolean jouer (){
        return de.lancer() == 20;
    }
}
