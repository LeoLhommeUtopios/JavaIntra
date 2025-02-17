package org.example.democleancode.controller;


import org.example.democleancode.controller.dto.VoitureDtoReceive;
import org.example.democleancode.controller.dto.VoitureDtoResponse;
import org.example.democleancode.service.Voiture;
import org.example.democleancode.service.VoitureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/voiture")
public class VoitureController {

    private VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @PostMapping
    public ResponseEntity<VoitureDtoResponse> addVoiture (@RequestBody VoitureDtoReceive voitureDto){
        return  ResponseEntity.ok(voitureService.save(voitureDto));
    }

    @GetMapping
    public ResponseEntity<List<VoitureDtoResponse>> getAll (){
        return ResponseEntity.ok(voitureService.getVoiture());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoitureDtoResponse> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(voitureService.getVoiture(id));
    }


}
