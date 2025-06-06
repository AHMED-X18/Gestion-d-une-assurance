package com.example.Assurance.Repository;


import com.example.Assurance.Models.MedecinGeneraliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinGeneralisteRepository extends JpaRepository<MedecinGeneraliste, Integer> {
    // Recherche par nom ou prénom (insensible à la casse)
    List<MedecinGeneraliste> findByNomOrPrenom(String nom, String prenom);

    // Recherche par sexe
    List<MedecinGeneraliste> findBySexe(String sexe);
}