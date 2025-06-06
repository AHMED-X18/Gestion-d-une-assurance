package com.example.Assurance.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "prescrit_par_specialiste")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescritParSpecialiste {
    @EmbeddedId
    private PrescritParSpecialisteId id;

    @ManyToOne
    @MapsId("idMedicament")
    @JoinColumn(name = "IdMedicament")
    private Medicament medicament;

    @ManyToOne
    @MapsId("numMedSpe")
    @JoinColumn(name = "NumMedSpe")
    private MedecinSpecialiste medecinSpecialiste;

    @Column(name = "Qte", nullable = false)
    private Integer qte;

    @Embeddable
    public static class PrescritParSpecialisteId implements Serializable {
        @Column(name = "IdMedicament")
        private Integer idMedicament;

        @Column(name = "NumMedSpe")
        private Integer numMedSpe;

        public PrescritParSpecialisteId() {
        }

        public PrescritParSpecialisteId(Integer idMedicament, Integer numMedSpe) {
            this.idMedicament = idMedicament;
            this.numMedSpe = numMedSpe;
        }

    }
}