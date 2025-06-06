package com.example.Assurance.Repository;

import com.example.Assurance.Models.FeuilleDeMaladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FeuilleDeMaladieRepository extends JpaRepository<FeuilleDeMaladie, Integer> {
    List<FeuilleDeMaladie> findByAssureNumPatient(Integer numPatient);
    List<FeuilleDeMaladie> findByMedecinGeneralisteNumMedGen(Integer numMedGen);
    List<FeuilleDeMaladie> findByMedecinSpecialisteNumMedSpe(Integer numMedSpe);
    List<FeuilleDeMaladie> findByConsultationIdConsultation(Integer idConsultation);
    List<FeuilleDeMaladie> findByDateEmissionBetween(LocalDate startDate, LocalDate endDate);
    List<FeuilleDeMaladie> findByEstEnvoyee(Boolean estEnvoyee);
    // Vérifier si une feuille existe pour un assuré et une consultation
    boolean existsByAssureNumPatientAndConsultationIdConsultation(Integer numPatient, Integer idConsultation);
}
