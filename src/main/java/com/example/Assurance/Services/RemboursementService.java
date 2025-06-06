package com.example.Assurance.Services;

import com.example.Assurance.Models.Remboursement;
import com.example.Assurance.Repository.FeuilleDeMaladieRepository;
import com.example.Assurance.Repository.RemboursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RemboursementService {
    @Autowired
    private RemboursementRepository remboursementRepository;

    public Remboursement effectuerRemboursement(Integer idFeuille, String moyenDePaiement, String statut) {
        Remboursement remboursement = new Remboursement();
        //remboursement.setFeuilleDeMaladie(FeuilleDeMaladieRepository.findById(idFeuille)); // À ajuster avec l'entité complète
        remboursement.setMoyenDePaiement(moyenDePaiement);
        remboursement.setStatut(statut);
        return remboursementRepository.save(remboursement);
    }

    public List<Remboursement> rembourserParCashOuVirement(Integer idFeuille) {
        List<String> moyens = Arrays.asList("cash", "virement");
        return remboursementRepository.findByFeuilleDeMaladieIdFeuilleAndMoyenDePaiement(idFeuille, moyens);
    }
}
