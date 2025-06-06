package com.example.Assurance.Repository;

import com.example.Assurance.Models.Assure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AssureRepository extends JpaRepository<Assure, Integer> {
    List<Assure> findByNomOrPrenom(String nom, String prenom);
    List<Assure> findByMedecinGeneralisteNumMedGen(Integer numMedGen);
    List<Assure> findByDateNaissanceBetween(LocalDate startDate, LocalDate endDate);
    boolean existsByNumPatient(Integer numPatient); // Pour vérifier l'existence d'un assuré
}
