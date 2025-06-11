package com.example.Assurance.Services;

import com.example.Assurance.Models.Consultation;
import com.example.Assurance.Models.MedecinSpecialiste;
import com.example.Assurance.Models.Medicament;
import com.example.Assurance.Models.PrescritParGeneraliste;
import com.example.Assurance.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionService {
    @Autowired
    private MedecinSpecialisteRepository medecinSpecialisteRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Autowired
    private PrescritParGeneralisteRepository prescritParGeneralisteRepository;

    @Autowired
    private PrescritParSpecialisteRepository prescritParSpecialisteRepository;

    public boolean prescrireConsultationChezSpecialiste(Integer numMedGen, Integer numMedSpe) {
        Optional<MedecinSpecialiste> specialiste = medecinSpecialisteRepository.findById(numMedSpe);
        if (specialiste.isPresent()) {
            // Logique pour créer une consultation (simplifiée ici)
            Consultation consultation = new Consultation();
            consultation.setStatut("Planifiée");
            consultationRepository.save(consultation);
            return true;
        }
        return false;
    }

    public boolean prescrireMedicaments(Integer numMedGen, Integer idMedicament, Integer qte) {
        Optional<Medicament> medicament = medicamentRepository.findById(idMedicament);
        if (medicament.isPresent()) {
            PrescritParGeneraliste prescription = new PrescritParGeneraliste();
            prescription.setMedicament(medicament.get());
            prescription.setQuantite(qte);
            // Logique pour lier au médecin (à compléter avec le contexte)
            prescritParGeneralisteRepository.save(prescription);
            return true;
        }
        return false;
    }
}
