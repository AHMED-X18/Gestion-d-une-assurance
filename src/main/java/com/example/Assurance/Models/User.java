package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser")
    private Integer idUser;

    @Column(name = "Login", nullable = false, unique = true)
    private String login;

    @Column(name = "MotDePasse", nullable = false)
    private String motDePasse;

    @OneToOne
    @JoinColumn(name = "NumMedGen")
    private MedecinGeneraliste medecinGeneraliste;

    @OneToOne
    @JoinColumn(name = "NumMedSpe")
    private MedecinSpecialiste medecinSpecialiste;

    @OneToOne
    @JoinColumn(name = "IdAgent")
    private AgentSecuriteSociale agentSecuriteSociale;
}