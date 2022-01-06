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
@Table(name = "HISTORIA_CLINICA")
public class MedicalHistoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_HISTORIA")
    private Long historyId;

    @Column(name = "MEDICACION_ACTUAL")
    private String currentMedication;

    @Column(name = "HACE_EJERCICIO")
    private boolean doExercise;

    @Column(name = "BEBE_ALCOHOL")
    private boolean alcoholConsumption;

    @Column(name = "FUMADOR")
    private boolean smoker;

    @Column(name = "COMENTARIO_ADICIONAL")
    private String additionalComment;

    @Column(name = "PESO")
    private double weight;

    @Column(name = "ESTATURA")
    private double height;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USUARIO")
    private PatientEntity patientEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalHistoryEntity")
    private List<ProcedureEntity> procedureEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalHistoryEntity")
    private List<DrugAllergyEntity> drugAllergyEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalHistoryEntity")
    private List<FamiliarDiseaseEntity> familiarDiseaseEntities;

}
