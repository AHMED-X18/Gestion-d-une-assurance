package com.example.Assurance.Repository;

import com.example.Assurance.Models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
    List<Consultation> findByAssureNumPatient(Integer numPatient);
    List<Consultation> findByFeuilleDeMaladieIdFeuille(Integer idFeuille);
    List<Consultation> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Consultation> findByStatut(String statut);
    @Query("SELECT c FROM Consultation c JOIN c.feuilleDeMaladie fm JOIN fm.medicaments p WHERE p.idMedicament = :idMedicament")
    List<Consultation> findByMedicamentId(Integer idMedicament);
}
