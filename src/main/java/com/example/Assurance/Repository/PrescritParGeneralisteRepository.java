package com.example.Assurance.Repository;

import com.example.Assurance.Models.PrescritParGeneraliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescritParGeneralisteRepository extends JpaRepository<PrescritParGeneraliste, PrescritParGeneraliste.PrescritParGeneralisteId> {
    List<PrescritParGeneraliste> findByMedecinGeneralisteNumMedGen(Integer numMedGen);
    List<PrescritParGeneraliste> findByMedicamentIdMedicament(Integer idMedicament);
    @Query("SELECT p FROM PrescritParGeneraliste p JOIN p.medecinGeneraliste mg JOIN mg.assures a WHERE a.numPatient = :numPatient")
    List<PrescritParGeneraliste> findByAssureNumPatient(Integer numPatient);
}
