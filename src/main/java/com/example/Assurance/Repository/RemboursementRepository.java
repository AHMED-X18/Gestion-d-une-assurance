package com.example.Assurance.Repository;

import com.example.Assurance.Models.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Integer> {
    List<Remboursement> findByFeuilleDeMaladieIdFeuille(Integer idFeuille);
    List<Remboursement> findByMoyenDePaiement(String moyenDePaiement);
    List<Remboursement> findByStatut(String statut);
    // Filtrer par type de remboursement (cash ou virement)
    List<Remboursement> findByMoyenDePaiement(List<String> moyensDePaiement);
    List<Remboursement> findByFeuilleDeMaladieIdFeuilleAndMoyenDePaiement(Integer idFeuille, List<String> moyensDePaiement);
}
