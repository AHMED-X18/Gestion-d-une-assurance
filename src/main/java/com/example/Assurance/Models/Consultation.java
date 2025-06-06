package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "CONSULTATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdConsultation")
    private Integer idConsultation;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "Heure", nullable = false)
    private LocalTime heure;

    @Column(name = "Duree", nullable = false)
    private Float duree;

    @Column(name = "Statut", nullable = false)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "NumPatient")
    private Assure assure;

    @ManyToOne
    @JoinColumn(name = "IdFeuille")
    private FeuilleDeMaladie feuilleDeMaladie;
}