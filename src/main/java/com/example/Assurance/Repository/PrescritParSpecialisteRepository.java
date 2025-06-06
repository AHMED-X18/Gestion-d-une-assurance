package com.example.Assurance.Repository;

import com.example.Assurance.Models.PrescritParSpecialiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescritParSpecialisteRepository extends JpaRepository<PrescritParSpecialiste, PrescritParSpecialiste.PrescritParSpecialisteId> {
    List<PrescritParSpecialiste> findByMedecinSpecialisteNumMedSpe(Integer numMedSpe);
    List<PrescritParSpecialiste> findByMedicamentIdMedicament(Integer idMedicament);
    @Query("SELECT p FROM PrescritParSpecialiste p JOIN p.medecinSpecialiste ms JOIN ms.feuillesDeMaladie fm JOIN fm.consultation c JOIN c.assure a WHERE a.numPatient = :numPatient")
    List<PrescritParSpecialiste> findByAssureNumPatient(Integer numPatient);
}
