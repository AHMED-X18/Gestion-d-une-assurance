package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "MEDECIN_GENERALISTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedecinGeneraliste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumMedGen")
    private Integer numMedGen;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Prenom", nullable = false)
    private String prenom;

    @Column(name = "Sexe", nullable = false)
    private String sexe;

    @OneToOne(mappedBy = "medecinGeneraliste")
    private User user;

    @OneToMany(mappedBy = "medecinGeneraliste")
    private List<Assure> assures;

    @OneToMany(mappedBy = "medecinGeneraliste")
    private List<FeuilleDeMaladie> feuillesDeMaladie;

    @OneToMany(mappedBy = "medecinGeneraliste")
    private List<PrescritParGeneraliste> prescriptions;
}