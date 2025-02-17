package org.example.democleancode.repository;

import org.example.democleancode.repository.entity.VoitureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<VoitureEntity,Integer> {
}
