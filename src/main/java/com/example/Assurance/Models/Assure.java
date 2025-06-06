package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ASSURE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumPatient")
    private Integer numPatient;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Prenom", nullable = false)
    private String prenom;

    @Column(name = "DateNaissance", nullable = false)
    private LocalDate dateNaissance;

    @ManyToOne
    @JoinColumn(name = "NumMedGen")
    private MedecinGeneraliste medecinGeneraliste;

    @OneToMany(mappedBy = "assure")
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "assure")
    private List<FeuilleDeMaladie> feuillesDeMaladie;
}