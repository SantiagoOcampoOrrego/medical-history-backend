package co.edu.utp.isc.gia.medicalhistory.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "ENFERMEDAD_FAMILIAR")
public class FamiliarDiseaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENFERMEDAD_FAMILIAR_ID")
    private Long familiarDiseaseId;

    @Column(name = "PARENTESCO")
    private String relationship;

    @Column(name = "NOMBRE_ENFERMEDAD")
    private String diseaseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_HISTORIA")
    private MedicalHistoryEntity medicalHistoryEntity;

}
