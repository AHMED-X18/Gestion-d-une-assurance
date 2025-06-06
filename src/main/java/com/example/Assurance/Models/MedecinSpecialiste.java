package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "MEDECIN_SPECIALISTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedecinSpecialiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumMedSpe")
    private Integer numMedSpe;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Prenom", nullable = false)
    private String prenom;

    @Column(name = "Specialite", nullable = false)
    private String specialite;

    @OneToOne(mappedBy = "medecinSpecialiste")
    private User user;

    @OneToMany(mappedBy = "medecinSpecialiste")
    private List<FeuilleDeMaladie> feuillesDeMaladie;

    @OneToMany(mappedBy = "medecinSpecialiste")
    private List<PrescritParSpecialiste> prescriptions;
}
