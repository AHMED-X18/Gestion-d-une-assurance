package com.example.Assurance.Services;

import com.example.Assurance.Models.Assure;
import com.example.Assurance.Repository.AssureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssureService {
    @Autowired
    private AssureRepository assureRepository;

    public Assure inscrireAssure(String nom, String prenom, LocalDate dateNaissance) {
        Assure assure = new Assure();
        assure.setNom(nom);
        assure.setPrenom(prenom);
        assure.setDateNaissance(dateNaissance);
        return assureRepository.save(assure);
    }

    public boolean assureExiste(Integer numPatient) {
        return assureRepository.existsByNumPatient(numPatient);
    }
}
