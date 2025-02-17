package org.example.democleancode.service.port;

import org.example.democleancode.service.Voiture;

import java.util.List;

public interface RepositoryInterface {
    public Voiture save (Voiture voiture);
    public Voiture getVoiture(int id);
    public List<Voiture> getVoiture();
}
