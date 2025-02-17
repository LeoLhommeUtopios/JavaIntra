package org.example.democleancode.service;

import org.example.democleancode.repository.VoitureRepository;
import org.example.democleancode.controller.dto.VoitureDtoReceive;
import org.example.democleancode.controller.dto.VoitureDtoResponse;
import org.example.democleancode.repository.VoitureRepositoryImp;
import org.example.democleancode.service.port.RepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {
    private RepositoryInterface voitureRepository;

    public VoitureService(VoitureRepositoryImp voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public VoitureDtoResponse save  (VoitureDtoReceive voituredto){
        Voiture voiture = voitureFromVoitureDto(voituredto);
        voiture = voitureRepository.save(voiture);
        return voitureToVoitureDto(voiture);
    }

    public VoitureDtoResponse getVoiture(int id){
        Voiture voiture = voitureRepository.getVoiture(id);
        return voitureToVoitureDto(voiture);
    }

    public List<VoitureDtoResponse> getVoiture (){
        List<Voiture> voitures = voitureRepository.getVoiture();
        return voitures.stream().map(this::voitureToVoitureDto).toList();
    }

    private Voiture voitureFromVoitureDto (VoitureDtoReceive voitureDtoReceive){
        return new Voiture(voitureDtoReceive.getRoue(),voitureDtoReceive.getPorte());
    }

    private VoitureDtoResponse voitureToVoitureDto (Voiture voiture){
        return new VoitureDtoResponse(voiture.getId(), voiture.getRoue(), voiture.getPorte());
    }
}
