package com.example.Assurance.Services;

import com.example.Assurance.Models.FeuilleDeMaladie;
import com.example.Assurance.Repository.FeuilleDeMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FeuilleDeMaladieService {
    @Autowired
    private FeuilleDeMaladieRepository feuilleDeMaladieRepository;

    public FeuilleDeMaladie enregistrerFeuilleDeMaladie(Integer numPatient, Float frais, LocalDate dateEmission) {
        FeuilleDeMaladie feuille = new FeuilleDeMaladie();
        feuille.setDateEmission(dateEmission);
        feuille.setFrais(frais);
        feuille.setEstEnvoyee(false);
        // Logique pour lier au patient (à compléter avec le contexte)
        feuilleDeMaladieRepository.save(feuille);
        return feuille;
    }

    public boolean existeFeuillePourConsultation(Integer numPatient, Integer idConsultation) {
        return feuilleDeMaladieRepository.existsByAssureNumPatientAndConsultationIdConsultation(numPatient, idConsultation);
    }
}
