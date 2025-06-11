package com.example.Assurance.Services;

import com.example.Assurance.Models.Assure;
import com.example.Assurance.Models.MedecinGeneraliste;
import com.example.Assurance.Repository.AssureRepository;
import com.example.Assurance.Repository.MedecinGeneralisteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssureService {

    @Autowired
    private AssureRepository assureRepository;

    @Autowired
    private MedecinGeneralisteRepository medecinGeneralisteRepository;

    public Assure inscrireAssure(Assure assure) {
        return assureRepository.save(assure);
    }

    public List<Assure> getAllAssures() {
        return assureRepository.findAll();
    }

    @Transactional
    public void associerMedecinTraitant(int numAssure, int medecinId) {
        Assure assure = assureRepository.findById(numAssure)
                .orElseThrow(() -> new RuntimeException("Assuré non trouvé"));

        MedecinGeneraliste medecinGeneraliste = medecinGeneralisteRepository.findById(medecinId)
                .orElseThrow(() -> new RuntimeException("Medecin non trouvé"));;

        assure.setMedecinGeneraliste(medecinGeneraliste);
        assureRepository.save(assure);
    }
}

