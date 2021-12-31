package co.edu.utp.isc.gia.medicalhistory.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "PROCEDIMIENTO")
public class ProcedureEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PROCEDIMIENTO")
    private Long procedureId;

    @Column(name = "FECHA_PROCEDIMIENTO")
    private Date procedureDate;

    @Column(name = "DIAGNOSTICO")
    private String diagnosis;

    @Column(name = "TRATAMIENTO")
    private String treatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_DOCTOR")
    private DoctorEntity doctorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_HISTORIA")
    private MedicalHistoryEntity medicalHistoryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPO_PROCEDIMIENTO")
    private ProcedureTypeEntity procedureTypeEntity;
}
