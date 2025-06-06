package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "FEUILLE_DE_MALADIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeuilleDeMaladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFeuille")
    private Integer idFeuille;

    @Column(name = "DateEmission", nullable = false)
    private LocalDate dateEmission;

    @Column(name = "EtatCivil", nullable = false)
    private Boolean etatCivil;

    @Column(name = "ModeDePaiement", nullable = false)
    private String modeDePaiement;

    @Column(name = "Frais", nullable = false)
    private Float frais;

    @Column(name = "Commentaires")
    private String commentaires;

    @Column(name = "estEnvoyee", nullable = false)
    private Boolean estEnvoyee;

    @ManyToOne
    @JoinColumn(name = "NumPatient")
    private Assure assure;

    @ManyToOne
    @JoinColumn(name = "NumMedGen")
    private MedecinGeneraliste medecinGeneraliste;

    @ManyToOne
    @JoinColumn(name = "NumMedSpe")
    private MedecinSpecialiste medecinSpecialiste;

    @OneToOne
    @JoinColumn(name = "IdConsultation")
    private Consultation consultation;

    @OneToMany(mappedBy = "feuilleDeMaladie")
    private List<Remboursement> remboursements;
}