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

    @Column(name = "ALERGIAS")
    private String drugAllergies;

    @Column(name = "OPERACIONES")
    private String operations;

    @Column(name = "MEDICACION_ACTUAL")
    private String currentMedications;

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
    @JoinColumn(name = "ID_USUARIO", foreignKey = @ForeignKey(name = "uId"))
    private PatientEntity patientEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcedureEntity> procedureEntities;

}
