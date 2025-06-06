package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "prescrit_par_generaliste")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescritParGeneraliste {
    @EmbeddedId
    private PrescritParGeneralisteId id;

    @ManyToOne
    @MapsId("idMedicament")
    @JoinColumn(name = "IdMedicament")
    private Medicament medicament;

    @ManyToOne
    @MapsId("numMedGen")
    @JoinColumn(name = "NumMedGen")
    private MedecinGeneraliste medecinGeneraliste;

    @Column(name = "Qte", nullable = false)
    private Integer qte;

    @Embeddable
    public static class PrescritParGeneralisteId implements Serializable {
        @Column(name = "IdMedicament")
        private Integer idMedicament;

        @Column(name = "NumMedGen")
        private Integer numMedGen;

        public PrescritParGeneralisteId() {}

        public PrescritParGeneralisteId(Integer idMedicament, Integer numMedGen) {
            this.idMedicament = idMedicament;
            this.numMedGen = numMedGen;
        }

    }
}