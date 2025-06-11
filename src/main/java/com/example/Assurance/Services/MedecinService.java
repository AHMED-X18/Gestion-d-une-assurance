package com.example.Assurance.Services;

import com.example.Assurance.Models.Assure;
import com.example.Assurance.Models.MedecinGeneraliste;
import com.example.Assurance.Repository.AssureRepository;
import com.example.Assurance.Repository.MedecinGeneralisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    @Autowired
    private MedecinGeneralisteRepository medecinGeneralisteRepository;

    @Autowired
    private AssureRepository assureRepository;

    public MedecinGeneraliste consulterMedecinGeneraliste(Integer numMedGen) {
        Optional<MedecinGeneraliste> medecin = medecinGeneralisteRepository.findById(numMedGen);
        return medecin.orElse(null);
    }

    public boolean enregistrerMedecinTraitantPourAssure(Integer numMedGen, Integer numPatient) {
        Optional<MedecinGeneraliste> medecin = medecinGeneralisteRepository.findById(numMedGen);
        Optional<Assure> assure = assureRepository.findById(numPatient);

        if (medecin.isPresent() && assure.isPresent()) {
            assure.get().setMedecinGeneraliste(medecin.get());
            assureRepository.save(assure.get());
            return true;
        }
        return false;
    }

    public List<MedecinGeneraliste> trouverMedecinsParNomOuPrenom(String nom, String prenom) {
        return medecinGeneralisteRepository.findByNomOrPrenom(nom, prenom);
    }

    public List<MedecinGeneraliste> getAllMedecins(){
        return medecinGeneralisteRepository.findAll();
    }
}
