package co.edu.utp.isc.gia.medicalhistory.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @JoinTable(
            name = "REL_HISTORIA_ENFERMEDAD_FAMILIAR",
            joinColumns = @JoinColumn(name = "FK_ENFERMEDAD_FAMILIAR"),
            inverseJoinColumns = @JoinColumn(name = "FK_HISTORIA_CLINICA")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<MedicalHistoryEntity> medicalHistoryEntityList;

}
