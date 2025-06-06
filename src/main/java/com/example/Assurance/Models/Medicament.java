package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "MEDICAMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMedicament")
    private Integer idMedicament;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Posologie", nullable = false)
    private String posologie;

    @Column(name = "Duree", nullable = false)
    private Float duree;

    @Column(name = "Quantite", nullable = false)
    private Integer quantite;

    @Column(name = "Prix")
    private Float prix;

    @OneToMany(mappedBy = "medicament")
    private List<PrescritParGeneraliste> prescriptionsGeneralistes;

    @OneToMany(mappedBy = "medicament")
    private List<PrescritParSpecialiste> prescriptionsSpecialistes;
}