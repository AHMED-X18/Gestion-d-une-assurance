package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "REMBOURSEMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRemboursement")
    private Integer idRemboursement;

    @Column(name = "MoyenDePaiement", nullable = false)
    private String moyenDePaiement;

    @Column(name = "Statut", nullable = false)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "IdFeuille")
    private FeuilleDeMaladie feuilleDeMaladie;
}