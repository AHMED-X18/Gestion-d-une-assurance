package com.example.Assurance.Repository;

import com.example.Assurance.Models.MedecinSpecialiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinSpecialisteRepository extends JpaRepository<MedecinSpecialiste, Integer> {
    // Recherche par nom ou prénom (insensible à la casse)
    List<MedecinSpecialiste> findByNomOrPrenom(String nom, String prenom);

    // Recherche par spécialité
    List<MedecinSpecialiste> findBySpecialite(String specialite);
}