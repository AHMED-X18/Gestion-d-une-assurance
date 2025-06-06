package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "AGENT_SECURITE_SOCIALE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentSecuriteSociale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAgent")
    private Integer idAgent;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Prenom", nullable = false)
    private String prenom;

    @OneToOne(mappedBy = "agentSecuriteSociale")
    private User user;
}