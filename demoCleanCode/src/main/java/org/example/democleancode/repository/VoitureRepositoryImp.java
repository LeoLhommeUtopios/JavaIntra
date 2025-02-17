package org.example.democleancode.repository;

import org.example.democleancode.repository.entity.VoitureEntity;
import org.example.democleancode.service.Voiture;
import org.example.democleancode.service.port.RepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoitureRepositoryImp implements RepositoryInterface {

    private VoitureRepository voitureRepository;

    public VoitureRepositoryImp(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @Override
    public Voiture save(Voiture voiture) {
        VoitureEntity voitureEntity = voitureToEntity(voiture);
        voitureRepository.save(voitureEntity);
        return entityToVoiture(voitureEntity);
    }

    @Override
    public Voiture getVoiture(int id) {
        VoitureEntity voitureEntity = voitureRepository.getReferenceById(id);
        return entityToVoiture(voitureEntity);
    }

    @Override
    public List<Voiture> getVoiture() {
        List<VoitureEntity> voitureEntities = voitureRepository.findAll();
        List<Voiture> voitures = voitureEntities.stream().map(this::entityToVoiture).toList();
        return voitures;
    }

    private VoitureEntity voitureToEntity (Voiture voiture){
        return new VoitureEntity(voiture.getRoue(), voiture.getPorte());
    }
    private Voiture entityToVoiture (VoitureEntity voitureEntity){
        return new Voiture(voitureEntity.getId(), voitureEntity.getRoue(), voitureEntity.getPorte());
    }
}
